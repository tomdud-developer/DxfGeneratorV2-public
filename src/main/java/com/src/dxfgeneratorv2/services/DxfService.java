package com.src.dxfgeneratorv2.services;

import com.jsevy.jdxf.DXFDocument;
import com.jsevy.jdxf.DXFGraphics;
import com.src.dxfgeneratorv2.plates.PlatesBase;

public class DxfService {
    private DXFDocument dxfDocument;
    private PlatesBase base;

    static public enum saveEnum {
        BORDER, TEXT, ALL;
    }

    public DxfService(PlatesBase base){
        this.base = base;
    }
    public String generateDXF(saveEnum enu) {
        dxfDocument = new DXFDocument("All");
        // set units to mm
        dxfDocument.setUnits(4);
        // set precision digits to 8
        dxfDocument.setPrecisionDigits(8);

        DXFGraphics dxfGraphics = dxfDocument.getGraphics();


        switch (enu) {
            case BORDER:
                base.drawBorders(dxfGraphics);
                break;
            case TEXT:
                base.drawText(dxfGraphics);
                break;
            case ALL:
                base.drawAll(dxfGraphics);
                break;
        }

        String stringOutput = dxfDocument.toDXFString()
                .replaceAll("Xirod Italic", "xirod")
                .replaceAll("My Font Regular", "xirod8")
                .replaceAll("GOST type B", "OpenGostTypeB-Regular - copy");  //ma być
        System.out.println(stringOutput);
        return stringOutput;
    }

}
