package skinnerhcheckers;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Controller implements Initializable {
    @FXML
    private VBox vBox;
    
    @FXML
    private MenuBar menuBar;
    private double menuBarHeight;
    
    private Stage stage;
    
    // default values
    private int numRowsColumns = 8;
    private double boardWidth = 500;
    private double boardHeight = 500;

    private CheckerBoard board;

    public void ready(Stage stage) {
        this.stage = stage;
        menuBarHeight = menuBar.getHeight();
        render();
        vBox.widthProperty().addListener(lambdaChangeListener);
        vBox.heightProperty().addListener(lambdaChangeListener);
    }
    
    ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
        render();
    };
    
    //Called everytime a new grid is needed
    private void render() {
        
        if(board != null) {
           vBox.getChildren().remove(board.getBoard());
        }
        
        boardWidth = vBox.getWidth();
        boardHeight =vBox.getHeight() - menuBarHeight; // stage contains menu, want to avoid in calculations

        board = new CheckerBoard(numRowsColumns, numRowsColumns, boardWidth, boardHeight);
        vBox.getChildren().add(board.build());
    }

    @FXML
    private void GridChange16(ActionEvent event) {
        numRowsColumns = 16;
        render();
    }
    
    @FXML
    private void GridChange10(ActionEvent event) {
        numRowsColumns = 10;
        render();
    }
    
    @FXML
    private void GridChange8(ActionEvent event) {
        numRowsColumns = 8;
        render();
    }
    
    @FXML
    private void GridChange3(ActionEvent event) {
        numRowsColumns = 3;
        render();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
