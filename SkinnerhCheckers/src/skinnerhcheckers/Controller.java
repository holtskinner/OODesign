package skinnerhcheckers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Controller implements Initializable {
    
    // default values
    private int numRows =	8;
    private int numCols =	8;
    private double boardWidth = 600;	
    private double boardHeight = 600;

    
    private Stage stage;
    private CheckerBoard board;
    
    @FXML
    private AnchorPane root;

    public void ready(Stage stage) {
        this.stage = stage;
        this.boardHeight = stage.getHeight();
        this.boardWidth = stage.getWidth();
        this.board = new CheckerBoard(numRows, numCols, boardWidth, boardHeight);
    }
    
//    ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
//     drawGrid();
//    };
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
