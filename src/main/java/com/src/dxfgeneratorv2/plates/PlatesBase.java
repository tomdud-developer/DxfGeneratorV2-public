package com.src.dxfgeneratorv2.plates;

import com.src.dxfgeneratorv2.plates.models.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class PlatesBase {

    ArrayList<AbstractPlate> plates;
    int counter;
    public PlatesBase() {
        plates = new ArrayList<>();
        counter = 0;
    }



    public <T extends AbstractPlate> void add(T t){
        plates.add(t);
        counter++;
    }

    public <T extends AbstractPlate> T createPlate(DataSpliter spliter){
        AbstractPlate plate;

        switch(spliter.model){
            case "W1": plate = new PlateModelW1(spliter);
                break;
            case "W2": plate = new PlateModelW2(spliter);
                break;
            case "W3": plate = new PlateModelW3(spliter);
                break;
            case "T1": plate = new PlateModelT1(spliter);
                break;
            case "A1": plate = new PlateModelA1(spliter);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + spliter.model);
        }
        return (T) plate;
    }

    public int getCounter(){
        return counter;
    }

    public void setOffsets(int[][] matrix){

        Iterator<AbstractPlate> iter = plates.iterator();
        for(int row = 7; row >=0; row--)
            for(int col = 0; col < 6; col++)
                if(matrix[row][col] == 1 && iter.hasNext()){
                    //Calculate offset//
                    double x = 5 + 114 * col; //95
                    double y = -5 - 71 * (7 - row);
                    iter.next().setOffset(x, y);
                }
    }
    public void setOffsetsA1(int[][] matrix){
        Iterator<AbstractPlate> iter = plates.iterator();
        for(int row = 7; row >=0; row--)
            for(int col = 0; col < 6; col++)
                if(matrix[row][col] == 1 && iter.hasNext()){
                    //Calculate offset//
                    double x = 5 + 95 * col; //95
                    double y = -5 - 95 * (7 - row);
                    iter.next().setOffset(x, y);
                }
    }

    public void drawBorders(Graphics g) {
        plates.forEach(plate -> plate.drawBorders(g));
    }

    public void drawText(Graphics g) {
        plates.forEach(plate -> plate.drawText(g));
    }

    public void drawAll(Graphics g) {
        plates.forEach(plate -> plate.drawAll(g));
    }
}

