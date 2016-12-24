package org.phip123.copycat.view.start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.phip123.copycat.copy.process.configuration.Configuration;
import org.phip123.copycat.view.preferences.PreferencesController;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

/**
 * Created by phip123 on 24.12.2016.
 */
public class MainController {


    private final static Logger log = Logger.getLogger(MainController.class.getSimpleName());

    private Stage stage;
    private Parent parent;
    private Scene scene;

    private Preferences pref;
    private Configuration config;

    private static final String DEFAULT_DIR = "default_dir";

    public MainController() {}

    @FXML
    public void initialize() {
        config = new Configuration();
        pref = Preferences.userRoot().node(this.getClass().getName());
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

    @FXML
    public void setSource(ActionEvent actionEvent) {

    }

    @FXML
    public void setDestination(ActionEvent actionEvent) {
    }

    @FXML
    public void copy(ActionEvent actionEvent) {

    }

    @FXML
    public void setDefaultDirectory(ActionEvent actionEvent) {
        Optional<File> dir = showDirectoryChooser(actionEvent,"Pick default directory");
        pref.put(DEFAULT_DIR,dir.orElse(new File("")).getAbsolutePath());
        log.info("Set default dir to : " + dir.orElse(new File("")).getAbsolutePath());
    }

    private Optional<File> showDirectoryChooser(ActionEvent event, String title) {
        Node node = (Node) event.getSource();
        DirectoryChooser dirChooser = new DirectoryChooser();
        dirChooser.setTitle(title);
        File file = dirChooser.showDialog(node.getScene().getWindow());
        return file != null ? Optional.of(file) : Optional.<File>empty();
    }

    public void openPreferences(ActionEvent event) {
        new PreferencesController().launchPrefScreen(new Stage());
    }

}
