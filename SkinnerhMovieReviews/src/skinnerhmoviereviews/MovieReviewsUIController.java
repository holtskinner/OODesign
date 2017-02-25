package skinnerhmoviereviews;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author holt
 */
public class MovieReviewsUIController implements Initializable {
    
    @FXML
    private TextField searchTextField;
    
    @FXML
    private ListView moviesListView;
    
    @FXML
    private WebView webView;
    
    private ArrayList<MovieReview> reviews;
    
    private String query = "Zootopia";
    private WebEngine webEngine;
    private ObservableList<String> movieListItems;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
    
    public void ready() {
        webEngine = webView.getEngine();
        movieListItems = FXCollections.observableArrayList();
        
        moviesListView.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            // When the contents of the newsListView changes a situation can be created
            // where autoselection results in a new_val that is out of range of the stories.
            // The following makes sure the new_val is within the bounds of stories.
            if ((int)new_val < 0 || (int)new_val > (reviews.size() - 1)) {
                return;
            }
            MovieReview review = reviews.get((int)new_val);
            webEngine.load(review.url);
        });
        
        searchTextField.setText(query);
        loadMovies();
    }
    
    private void loadMovies() {
        
        try {
            reviews = MovieReviewsParser.getMovieReviews(query);
        } catch (Exception ex) {
            displayExceptionAlert(ex);
            return;
        }
        
       movieListItems.clear();
       
       for (MovieReview review : reviews) {
           movieListItems.add(review.title);
       }
       
       moviesListView.setItems(movieListItems);
       
       if (reviews.size() > 0) {
            moviesListView.getSelectionModel().select(0);
            moviesListView.getFocusModel().focus(0);
            moviesListView.scrollTo(0);
        }
    }
    
    @FXML
    private void handleSearch(ActionEvent event) {
        if (searchTextField.getText().equals("")) {
            displayErrorAlert("The search field cannot be blank. Enter one or more search words.");
            return;
        }
        query = searchTextField.getText();
        loadMovies();
    }
    
    @FXML
    private void handleUpdate(ActionEvent event) {
        loadMovies();
    }
    
    @FXML
    private void handleAbout(ActionEvent event) {
        displayAboutAlert();
    }
    
    private void displayErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error!");
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void displayExceptionAlert(Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception");
        alert.setHeaderText("An Exception Occurred!");
        alert.setContentText("An exception occurred.  View the exception information below by clicking Show Details.");

        // Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }
    
    private void displayAboutAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("New York Times Movie Reviews Viewer");
        alert.setContentText("This application was developed by Holt Skinner for CS4330 at the University of Missouri.");
        
        TextArea textArea = new TextArea("The New York Times API is used to obtain a feed of Movie Reviews.  Developer information is available at http://developer.nytimes.com. ");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
            
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(textArea, 0, 0);

        alert.getDialogPane().setExpandableContent(expContent);
        
        alert.showAndWait();
    }
}
