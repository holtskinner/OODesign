/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomgrid;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dale
 */
public class GridController implements Initializable {

    @FXML
    private GridPane gridPane;
    
    private final int NUMROWS = 40;
    private final int NUMCOLS = 40;
    
    private double gridWidth;
    private double gridHeight;
    
    private double rectWidth;
    private double rectHeight;
    
    private final Color[] colors = {Color.CORAL, Color.DEEPPINK, Color.BISQUE, Color.AZURE, Color.SEAGREEN};
    
    private Stage stage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    public void ready(Stage stage) {
        this.stage = stage;

        render();
    }
    
    protected void render() {
        gridWidth = gridPane.getWidth();
        gridHeight = gridPane.getHeight();
        
        rectWidth = Math.ceil(gridWidth / NUMCOLS);
        rectHeight = Math.ceil(gridHeight / NUMROWS);
        
        Random rn = new Random();
        int numColors = colors.length;
        
        for (int row = 0; row < NUMROWS; row++) {
            for (int col = 0; col < NUMCOLS; col++) {
                Color color = colors[rn.nextInt(numColors)];
                Rectangle rect = new Rectangle(rectWidth, rectHeight, color);
                
                gridPane.add(rect, row, col);
            }
        }       
    }
    
    
    @FXML
    private void handleRefresh(ActionEvent event) {
        gridPane.getChildren().clear();
        render();
    }
    
    @FXML
    private void handleClear(ActionEvent event) {
        gridPane.getChildren().clear();
    }
    
    @FXML
    private void handleAbout(ActionEvent event) {
        System.out.println("About");
    }
    
}
