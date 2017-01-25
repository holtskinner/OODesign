package skinnerhcheckers;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 *
 * @author holt skinner
 */
public class CheckerBoard {
    
    private int numRows, numCols;
    private double boardWidth, boardHeight, rectangleWidth, rectangleHeight;
    private Color lightColor, darkColor;
    
    private AnchorPane board;

    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight) {
        this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build() {
        
        return null;
    }
    
    public AnchorPane getBoard() {
        return board != null ? board : null;
    }
    
    public int getNumRows() {
        return this.numRows;
    }
    
    public int getNumCols() {
        return this.numCols;
    }
    
    public double getWidth() {
        return this.boardWidth;
    }
    
    public double getHeight() {
        return this.boardHeight;
    }
    
    public Color getLightColor() {
        return this.lightColor;
    }
    
    public Color getDarkColor() {
        return this.darkColor;
    }
    
    public double getRectangleWidth() {
        return this.rectangleWidth;
    }
    
    public double getRectangleHeight() {
        return this.rectangleHeight;
    }
}