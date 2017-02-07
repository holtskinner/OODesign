package skinnerhcheckers;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author holt skinner
 */
public class CheckerBoard {
    
    private int numRowsColumns;
    private double boardSize;
    private double rectangleSize;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    private AnchorPane anchorPane;

    // uses default colors
    public CheckerBoard(int numRowsColumns, double boardSize) {
       this.numRowsColumns = numRowsColumns;
       this.boardSize = boardSize;
       rectangleSize = boardSize / numRowsColumns;
    }
    
    public CheckerBoard(int numRowsColumns, double boardSize, Color lightColor, Color darkColor) {
       this(numRowsColumns, boardSize);
       this.lightColor = lightColor;
       this.darkColor = darkColor;
    }
  
    public AnchorPane build() {
        anchorPane = new AnchorPane();
        anchorPane.setPrefSize(boardSize, boardSize);
        
        for (int i = 0; i < numRowsColumns; i++) {
            for (int j = 0; j < numRowsColumns; j++) {
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

    public int getNumRowsColumns() {
        return numRowsColumns;
    }

    public double getBoardSize() {
        return boardSize;
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