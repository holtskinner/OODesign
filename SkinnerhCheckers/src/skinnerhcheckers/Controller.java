package skinnerhcheckers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class Controller implements Initializable {
    
    // default values
    private final int numRows =	8;
    private final int numCols =	8;
    private final int boardWidth = 600;	
    private final int boardHeight = 600;
    
    private CheckerBoard board;	

    public void ready() {
        this.board = new CheckerBoard(numRows, numCols, boardWidth, boardHeight);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
