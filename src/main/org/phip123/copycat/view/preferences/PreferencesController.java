package org.phip123.copycat.view.preferences;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by phip123 on 24.12.2016.
 */
public class PreferencesController {
    private final static Logger log = Logger.getLogger(PreferencesController.class.getSimpleName());

    private Stage stage;

    public PreferencesController () {}

    @FXML
    public void initialize () {

    }


    public void launchPrefScreen(Stage stage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/preferences.fxml"));
        try {
            this.stage = stage;
            Parent parent = loader.load();
            stage.setTitle("Preferences");
            stage.setScene(new Scene(parent,600,500));
            stage.show();
        } catch (IOException exception) {
            log.warning("Error displaying preferences view");
            throw new RuntimeException(exception);
        }
    }
}
