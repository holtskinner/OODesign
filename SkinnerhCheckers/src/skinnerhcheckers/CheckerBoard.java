package skinnerhcheckers;

import javafx.scene.paint.Color;

/**
 *
 * @author holt skinner
 */
public class CheckerBoard {
    
    private int numRows = 8, numCols = 8;
    private double boardWidth = 0, boardHeight = 0;
    private Color lightColor = Color.RED, darkColor = Color.BLACK;

    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
}
