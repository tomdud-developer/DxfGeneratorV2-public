package com.src.dxfgeneratorv2.plates;

import com.src.dxfgeneratorv2.FxController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

public class PlatesArragement {

    private GridPane gridPane;
    private Label remainingLabel;
    private ToggleButton[][] buttons = new ToggleButton[8][6];
    private Button createOffsetsButton;
    private FxController controller;

    public PlatesArragement(FxController controller){
        this.controller = controller;
        this.gridPane = controller.getGridPane();
        this.remainingLabel = controller.getRemainingLabel();
        this.createOffsetsButton = controller.getCreateOffsetsButton();
        initGrid();
    }

    private void initGrid(){
        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                event.consume();
                if(getRemaining()<0)((ToggleButton)event.getSource()).setSelected(false);
                if(getRemaining()==0 &&controller.getBaseCounter()>0) createOffsetsButton.setDisable(false);
                else createOffsetsButton.setDisable(true);
                remainingLabel.setText("Pozostało do zaznaczenia: " + getRemaining());
            }
        };
        for(int row = 1; row < gridPane.getRowCount(); row++)
            for(int col = 1; col < gridPane.getColumnCount(); col++) {
                ToggleButton button = new ToggleButton();
                button.setMaxWidth(90);
                button.setMaxHeight(30);
                button.setOnAction(buttonHandler);
                if(col == 6 && row == 3) button.setText("Max ROW for A1");
                else if(col == 6 && row > 3) button.setText("Only A1");
                else if(col == 6 && row < 3) button.setDisable(true);
                buttons[row-1][col-1] = button;
                gridPane.add(button,col,row);
            }
    }

    public int getRemaining(){
        return controller.getBaseCounter() - this.getActiveButtonsCounter();
    }

    private int getActiveButtonsCounter(){
        int counter = 0;
        for(int row = 0; row < gridPane.getRowCount()-1; row++)
            for(int col = 0; col < gridPane.getColumnCount()-1; col++)
                if(buttons[row][col].isSelected())counter++;
        return counter;
    }

    public int[][] getBooleanMatrixActivesButtons(){
        int[][] bb = new int[gridPane.getRowCount()][gridPane.getColumnCount()];
        for(int row = 0; row < gridPane.getRowCount()-1; row++)
            for(int col = 0; col < gridPane.getColumnCount()-1; col++)
                if(buttons[row][col].isSelected())bb[row][col] = 1;
                else bb[row][col] = 0;
           return bb;
    }







}
