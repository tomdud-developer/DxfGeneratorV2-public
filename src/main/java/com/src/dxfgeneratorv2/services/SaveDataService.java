package com.src.dxfgeneratorv2.services;

import com.jsevy.jdxf.*;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveDataService {

    private DXFDocument dxfDocument;
    private String currentDirectory;

    public void saveProcedure(Window window, String dxfString) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("DXF files (*.dxf)", "*.dxf");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(window);
        currentDirectory = file.getAbsolutePath();

        if (file != null) {
            try {
                PrintWriter writer;
                writer = new PrintWriter(file);
                writer.println(dxfString);
                writer.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public String getSavedDirectory(){
        return currentDirectory;
    }
}
