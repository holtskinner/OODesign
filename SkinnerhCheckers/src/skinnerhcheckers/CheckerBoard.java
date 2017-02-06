package skinnerhcheckers;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author holt skinner
 */
public class CheckerBoard {
    
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private double rectangleSize;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    private AnchorPane anchorPane;

    // uses default colors
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight) {
       this.numRows = numRows;
       this.numCols = numCols;
       this.boardWidth = boardWidth;
       this.boardHeight = boardHeight;
       rectangleSize = boardWidth / numCols;
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
       this(numRows, numCols, boardWidth, boardHeight);
       this.lightColor = lightColor;
       this.darkColor = darkColor;
    }
  
    public AnchorPane build() {
        anchorPane = new AnchorPane();
        anchorPane.setPrefSize(boardWidth, boardHeight);
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                Rectangle rectangle = new Rectangle(j * rectangleSize, i * rectangleSize, rectangleSize, rectangleSize);
                Color color =  (j % 2) == (i % 2) ? lightColor : darkColor;
                rectangle.setFill(color);
                anchorPane.getChildren().add(rectangle);
            }
        }
        
        return anchorPane;
    }
    
    public AnchorPane getBoard() {
        return anchorPane;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public double getWidth() {
        return boardWidth;
    }

    public double getHeight() {
        return boardHeight;
    }
    
    public Color getLightColor() {
        return lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    
    public double getRectangleWidth() {
        return rectangleSize;
    }
    
    public double getRectangleHeight() {
        return rectangleSize;
    }
}