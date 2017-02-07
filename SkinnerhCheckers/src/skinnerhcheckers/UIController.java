package skinnerhcheckers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class UIController implements Initializable {
    @FXML
    private StackPane stackPane;

    private Stage stage;
    private Scene scene;

    private double boardSize;
    private double boardHeight;
    
    private int numRowsColumns;

    private Color darkColor;
    private Color lightColor;

    private CheckerBoard checkerBoard;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDefaultColor();
        setDefaultRowsCols();
    }

    // called when stage had been shown
    public void ready(Stage stage, Scene scene) {
        this.stage = stage;
        this.scene = scene;
        
        // Lambda expression to allow changing of the window size
        ChangeListener<Number> listener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            render();
        };
        
        scene.widthProperty().addListener(listener);
        scene.heightProperty().addListener(listener);
        
        render();
    }


    //Called everytime a new grid is needed
    private void render() {
        boardSize = scene.getWidth();
        
        stackPane.getChildren().clear();
        checkerBoard = new CheckerBoard(numRowsColumns, boardSize, lightColor, darkColor);
        stackPane.getChildren().add(checkerBoard.build());
    }

    @FXML
    public void selectSize(ActionEvent event) {
        MenuItem menuItem = (MenuItem)(event.getSource());
        switch(menuItem.getId()) {
            case "16 x 16":
                numRowsColumns = 16;
                break;
            case "10 x 10":
                numRowsColumns = 10;
                break;
            case "8 x 8":
                numRowsColumns = 8;
                break;
            case "3 x 3":
                numRowsColumns = 3;
                break;
            default:
                setDefaultRowsCols();
        }
        render();
    }

    @FXML
    public void selectColor(ActionEvent event) {
        MenuItem menuItem = (MenuItem)(event.getSource());
        switch(menuItem.getId()) {
            case "Blue":
                setBlueColor();
                break;
            default:
                setDefaultColor();
        }
        render();
    }

    private void setDefaultColor() {
        darkColor = Color.BLACK;
        lightColor = Color.RED;
    }
    
    private void setBlueColor() {
        darkColor = Color.DARKBLUE;
        lightColor = Color.SKYBLUE;
    }
    
    private void setDefaultRowsCols() {
        numRowsColumns = 8;
    }
}