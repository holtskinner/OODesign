/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomgrid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dale
 */
public class RandomGrid extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Grid.fxml"));
        Parent root = loader.load();
        GridController controller = loader.getController();

        //Parent root = FXMLLoader.load(getClass().getResource("Grid.fxml"));
        
        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
        
        controller.ready(stage);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
