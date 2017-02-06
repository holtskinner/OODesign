package skinnerhcheckers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author holt skinner
 */
public class SkinnerhCheckers extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI.fxml"));
        Parent root = loader.load();
        UIController controller = loader.getController();
        
        Scene scene = new Scene(root, 600, 625);
        
        stage.setTitle("Checkers");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("crown.png")));
        
        stage.setScene(scene);
        stage.show();
        
        controller.ready(stage, scene);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
