package skinnerhcheckers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;

    private CheckerBoard board;

    // called when stage had been shown
    public void ready(Stage stage) {
        this.stage = stage;
        menuBarHeight = menuBar.getHeight();
        render();
        vBox.widthProperty().addListener(lambdaChangeListener);
        vBox.heightProperty().addListener(lambdaChangeListener);
    }

 // Lambda expression to allow changing of the window size
    ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
        render();
    };

    //Called everytime a new grid is needed
    private void render() {
        if (board != null) {
            vBox.getChildren().remove(board.getBoard());
        }

        boardWidth = vBox.getWidth();
        boardHeight = vBox.getHeight() - menuBarHeight; // stage contains menu, want to avoid in calculations

        board = new CheckerBoard(numRowsColumns, numRowsColumns, boardWidth, boardHeight, lightColor, darkColor);
        vBox.getChildren().add(board.build());
    }

    @FXML
    private void gridChange16(ActionEvent event) {
        if (numRowsColumns == 16) {
            return;
        }
        numRowsColumns = 16;
        render();
    }

    @FXML
    private void gridChange10(ActionEvent event) {
        if (numRowsColumns == 10) {
            return;
        }
        numRowsColumns = 10;
        render();
    }

    @FXML
    private void gridChange8(ActionEvent event) {
        if (numRowsColumns == 8) {
            return;
        }
        numRowsColumns = 8;
        render();
    }

    @FXML
    private void gridChange3(ActionEvent event) {
        if (numRowsColumns == 16) {
            return;
        }
        numRowsColumns = 3;
        render();
    }

    @FXML
    private void colorChangeDefault(ActionEvent event) {
        if (lightColor == Color.RED) {
            return;
        }
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        render();
    }

    @FXML
    private void colorChangeBlue(ActionEvent event) {
        if (lightColor == Color.LIGHTBLUE) {
            return;
        }
        lightColor = Color.LIGHTBLUE;
        darkColor = Color.DARKBLUE;
        render();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {}
}