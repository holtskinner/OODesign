package skinnerhxmlparser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author holt
 */
public class SkinnerhXMLParser extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("XMLParserUI.fxml"));
        Parent root = (Parent)loader.load();
        XMLParserUIController controller = (XMLParserUIController)loader.getController();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        controller.ready(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
