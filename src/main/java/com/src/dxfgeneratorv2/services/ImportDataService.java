package com.src.dxfgeneratorv2.services;

import com.src.dxfgeneratorv2.plates.DataSpliter;
import com.src.dxfgeneratorv2.plates.PlatesBase;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImportDataService {
    File selectedFile;

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

    public File getSelectedFile(){
        return selectedFile;
    }

    public FileInputStream getFileStream() throws FileNotFoundException {
        return new FileInputStream(selectedFile);
    }

    public void openExcel(Window window){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Excel Resource File");
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Excel files", "xls"));
        File selectedFile = fileChooser.showOpenDialog(window);

        this.setSelectedFile(selectedFile);
    }

    public int loadExcel(PlatesBase base){
        int r = 1;
        try {
            DataSpliter dataTemp;
            FileInputStream fis = getFileStream();
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            HSSFSheet sheet = wb.getSheetAt(0);//creating a Sheet object to retrieve the object
            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
            for (Row row : sheet) //iteration over row using for each loop
                if ("X".equals(row.getCell(23).getStringCellValue())) {
                    dataTemp = new DataSpliter();
                    dataTemp.Typ = row.getCell(1).getStringCellValue();
                    dataTemp.Wydajnosc = row.getCell(2).getStringCellValue();
                    dataTemp.Q_unit = row.getCell(3).getStringCellValue();
                    dataTemp.Ciśnienie = row.getCell(4).getStringCellValue();
                    dataTemp.Masa = row.getCell(5).getStringCellValue();
                    dataTemp.Temperatura = row.getCell(6).getStringCellValue();
                    dataTemp.MocSilnika = row.getCell(7).getStringCellValue();
                    dataTemp.RPM = row.getCell(8).getStringCellValue();
                    dataTemp.Napięcie = row.getCell(9).getStringCellValue();
                    dataTemp.Prąd = row.getCell(10).getStringCellValue();
                    dataTemp.Sprawność = row.getCell(11).getStringCellValue();
                    dataTemp.SprawnośćRodzaj = row.getCell(12).getStringCellValue();
                    dataTemp.N = row.getCell(13).getStringCellValue();
                    dataTemp.N2 = row.getCell(14).getStringCellValue();
                    dataTemp.frequency = row.getCell(15).getStringCellValue();
                    dataTemp.NormaEx = row.getCell(16).getStringCellValue();
                    dataTemp.Ta_low = row.getCell(17).getStringCellValue();
                    dataTemp.Ta_high = row.getCell(18).getStringCellValue();
                    dataTemp.NrSeryjny = row.getCell(19).getStringCellValue();
                    dataTemp.RokProdukcji = row.getCell(20).getStringCellValue();
                    dataTemp.NrSprawy = row.getCell(21).getStringCellValue();
                    dataTemp.model = row.getCell(22).getStringCellValue();
                    r++;
                    base.add(base.createPlate(dataTemp));
                }
        } catch (Exception e) {
            System.out.println(e.getMessage()+"   r="+r);
        }
        return base.getCounter();
    }


    public int loadA1Excel(PlatesBase base) {
        int r = 1;
        try {
            DataSpliter dataTemp;
            FileInputStream fis = getFileStream();
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            HSSFSheet sheet = wb.getSheetAt(0);//creating a Sheet object to retrieve the object
            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
            for (Row row : sheet) //iteration over row using for each loop
                if ("X".equals(row.getCell(4).getStringCellValue())) {
                    dataTemp = new DataSpliter();
                    dataTemp.A1Typ = row.getCell(1).getStringCellValue();
                    dataTemp.A1line1 = row.getCell(2).getStringCellValue();
                    dataTemp.A1line2 = row.getCell(3).getStringCellValue();
                    dataTemp.model = "A1";
                    r++;
                    base.add(base.createPlate(dataTemp));
                }
        } catch (Exception e) {
            System.out.println(e.getMessage()+"   r="+r);
        }
        return base.getCounter();
    }
}
