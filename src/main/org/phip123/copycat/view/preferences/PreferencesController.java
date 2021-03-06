package org.phip123.copycat.view.preferences;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.phip123.copycat.util.DirectoryHelper;
import org.phip123.copycat.util.UserPreferences;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Created by phip123 on 24.12.2016.
 */
public final class PreferencesController {
    private final static Logger log = Logger.getLogger(PreferencesController.class.getSimpleName());

    private Stage stage;

    @FXML
    private TextField defaultDirTxt;


    public PreferencesController () {}

    @FXML
    public void initialize () {
        defaultDirTxt.setText(UserPreferences.INSTANCE.getDefaultDirectory().getAbsolutePath());
    }

    @FXML
    public void setDefaultDirectory(ActionEvent actionEvent) {
        Optional<File> dir = DirectoryHelper.showDirectoryChooser(actionEvent,"Pick default directory");
        dir.ifPresent(this::setDefault);
    }

    private void setDefault(File file) {
        UserPreferences.INSTANCE.setDefaultDirectory(file);
        this.defaultDirTxt.setText(file.getAbsolutePath());
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
