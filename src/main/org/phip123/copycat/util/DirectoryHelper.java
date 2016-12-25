package org.phip123.copycat.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.util.Optional;

/**
 * Created by philipp on 12/24/16.
 */
public class DirectoryHelper {

    public static final String DEFAULT_DIR = "default_dir";


    public static Optional<File> showDirectoryChooser(ActionEvent event, String title) {
        Node node = (Node) event.getSource();
        DirectoryChooser dirChooser = new DirectoryChooser();
        dirChooser.setTitle(title);
        File file = dirChooser.showDialog(node.getScene().getWindow());
        return file != null ? Optional.of(file) : Optional.<File>empty();
    }


}
