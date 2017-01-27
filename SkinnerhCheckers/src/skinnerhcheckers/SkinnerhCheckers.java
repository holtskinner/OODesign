package skinnerhcheckers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author holt skinner
 */
public class SkinnerhCheckers extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        
        Scene scene = new Scene(root);
        stage.setTitle("Checkers");
        stage.setScene(scene);
        stage.show();
        controller.ready(stage);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
