package org.phip123.copycat.view.preferences;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.phip123.copycat.util.DirectoryHelper;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

import static org.phip123.copycat.util.DirectoryHelper.DEFAULT_DIR;

/**
 * Created by phip123 on 24.12.2016.
 */
public class PreferencesController {
    private final static Logger log = Logger.getLogger(PreferencesController.class.getSimpleName());

    private Stage stage;
    private Preferences pref;


    public PreferencesController () {}

    @FXML
    public void initialize () {
        pref = Preferences.userRoot().node(this.getClass().getName());

    }

    @FXML
    public void setDefaultDirectory(ActionEvent actionEvent) {
        Optional<File> dir = DirectoryHelper.showDirectoryChooser(actionEvent,"Pick default directory");
        pref.put(DEFAULT_DIR,dir.orElse(new File("")).getAbsolutePath());
        log.info("Set default dir to : " + dir.orElse(new File("")).getAbsolutePath());
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
