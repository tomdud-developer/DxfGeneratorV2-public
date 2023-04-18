package com.src.dxfgeneratorv2;

import com.src.dxfgeneratorv2.plates.PlatesArragement;
import com.src.dxfgeneratorv2.plates.PlatesBase;
import com.src.dxfgeneratorv2.services.DxfService;
import com.src.dxfgeneratorv2.services.ImportDataService;
import com.src.dxfgeneratorv2.services.SaveDataService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class FxController {

    @FXML
    private Button openButton;
    @FXML
    private Button loadButton;
    @FXML
    private TextArea openInfoText;
    @FXML
    private GridPane gridPane;
    @FXML
    private Label remainingLabel;
    @FXML
    private Label loadedLabel;
    @FXML
    private Button createOffsetsButton;
    @FXML
    private Button saveBordersButton;
    @FXML
    private Button saveTextButton;
    @FXML
    private Button saveAllButton;
    @FXML
    private TextArea saveInfoText;

    private ImportDataService importService;
    private PlatesBase base;
    private PlatesArragement arragement;
    private SaveDataService saveService;
    private DxfService dxfService;

    public FxController() {
        importService = new ImportDataService();
        base = new PlatesBase();
        saveService = new SaveDataService();
        dxfService = new DxfService(base);
    }


    public void initialize() {
        arragement = new PlatesArragement(this);
        createOffsetsButton.setDisable(true);
    }


    @FXML
    protected void openExcel() {
        try {
            importService.openExcel(openButton.getScene().getWindow());
            openInfoText.setText("Otwarto " + importService.getSelectedFile().getCanonicalPath());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void loadFromExcel() {
        int count = 0;
        count = importService.loadExcel(base);
        loadedLabel.setText("Wczytano " + count + " tabliczek");
        remainingLabel.setText("Pozostało do zaznaczenia: " + arragement.getRemaining());
    }

    @FXML
    protected void loadA1FromExcel() {
        int count = 0;
        count = importService.loadA1Excel(base);
        loadedLabel.setText("Wczytano " + count + " tabliczek");
        remainingLabel.setText("Pozostało do zaznaczenia: " + arragement.getRemaining());
    }

    @FXML
    protected void createOffsets(){
        base.setOffsets(arragement.getBooleanMatrixActivesButtons());
    }

    @FXML
    protected void createOffsetsA1(){
        base.setOffsetsA1(arragement.getBooleanMatrixActivesButtons());
    }



    @FXML
    protected void saveBorders(){
        String dxfDocument = dxfService.generateDXF(DxfService.saveEnum.BORDER);
        saveService.saveProcedure(saveBordersButton.getScene().getWindow(), dxfDocument);
        saveInfoText.setText("Zapisano do: " + saveService.getSavedDirectory());
    }

    @FXML
    protected void saveText(){
        String dxfDocument = dxfService.generateDXF(DxfService.saveEnum.TEXT);
        saveService.saveProcedure(saveBordersButton.getScene().getWindow(), dxfDocument);
        saveInfoText.setText("Zapisano do: " + saveService.getSavedDirectory());
    }

    @FXML
    protected void saveAll(){
        String dxfDocument = dxfService.generateDXF(DxfService.saveEnum.ALL);
        saveService.saveProcedure(saveBordersButton.getScene().getWindow(), dxfDocument);
        saveInfoText.setText("Zapisano do: " + saveService.getSavedDirectory());
    }

    public GridPane getGridPane() {
        return gridPane;
    }
    public Label getRemainingLabel() {
        return remainingLabel;
    }
    public Button getCreateOffsetsButton() {
        return createOffsetsButton;
    }

    public int getBaseCounter(){
        return base.getCounter();
    }
}