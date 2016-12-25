package org.phip123.copycat.view.start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.phip123.copycat.copy.process.configuration.Configuration;
import org.phip123.copycat.view.preferences.PreferencesController;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by phip123 on 24.12.2016.
 */
public class MainController {


    private final static Logger log = Logger.getLogger(MainController.class.getSimpleName());

    private Stage stage;
    private Parent parent;
    private Scene scene;

    private Configuration config;



    public MainController() {}

    @FXML
    public void initialize() {
        config = new Configuration();
    }

    @FXML
    public void setSource(ActionEvent actionEvent) {

    }

    @FXML
    public void setDestination(ActionEvent actionEvent) {
    }

    @FXML
    public void copy(ActionEvent actionEvent) {

    }

    public void openPreferences(ActionEvent event) {
        new PreferencesController().launchPrefScreen(new Stage());
    }

    public void launchMainScreen (Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/main.fxml"));
        try {
            this.stage = primaryStage;
            Parent parent = loader.load();
            primaryStage.setTitle("Main");
            primaryStage.setScene(new Scene(parent,400,100));
            primaryStage.show();
        } catch (IOException exception) {
            log.warning("Error displaying main view");
            throw new RuntimeException(exception);
        }
    }

}
