package org.phip123.copycat.view.start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.phip123.copycat.copy.process.Process;
import org.phip123.copycat.copy.process.configuration.Configuration;
import org.phip123.copycat.copy.result.Result;
import org.phip123.copycat.util.DirectoryHelper;
import org.phip123.copycat.view.preferences.PreferencesController;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Created by phip123 on 24.12.2016.
 */
public final class MainController {


    private final static Logger log = Logger.getLogger(MainController.class.getSimpleName());

    private Stage stage;
    private Parent parent;
    private Scene scene;

    private Configuration config;


    public MainController() {}

    @FXML
    public void initialize() {
        log.info("init");
        config = Configuration.getLocalConfig();
    }

    @FXML
    public void setSource(ActionEvent actionEvent) {
        Optional<File> file = DirectoryHelper.showDirectoryChooser(actionEvent,"Set Source");
        file.ifPresent(f -> config.setSource(f.getAbsolutePath()));
    }

    @FXML
    public void setDestination(ActionEvent actionEvent) {
        Optional<File> file = DirectoryHelper.showDirectoryChooser(actionEvent,"Set Destination");
        file.ifPresent(f -> config.setDestination(f.getAbsolutePath()));
    }

    @FXML
    public void copy(ActionEvent actionEvent) {
        try {
            this.config = getTestConfig();
            Process process = Process.newLocalProcess(config);
            handleResult(process.start());
            config = Configuration.getLocalConfig();
        } catch (IllegalArgumentException ex) {
            handleException(ex);
            log.warning("User wanted to copy but folders were empty");
        }
    }

    private void handleException(IllegalArgumentException ex) {
        //show error
    }

    private void handleResult(Result result) {
        switch (result.getResultType()) {
            case SUCCESS:
                break;
            case FAILURE:
                break;
            case EMPTY:log.info("Empty");
                break;
        }
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

    public Configuration getTestConfig() {
        String source = "/home/philipp/Documents/Test1/";
        String dest = "/home/philipp/Documents/Test2/";
        Configuration config = Configuration.getLocalConfig();
        config.setSource(source);
        config.setDestination(dest);
        return config;
    }
}
