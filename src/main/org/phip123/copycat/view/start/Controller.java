package org.phip123.copycat.view.start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.phip123.copycat.copy.process.configuration.Configuration;

/**
 * Created by phip123 on 24.12.2016.
 */
public class Controller {

    private Configuration config;

    @FXML
    public void initialize() {
        config = new Configuration();
    }

    public void setSource(ActionEvent actionEvent) {
    }

    public void setDestination(ActionEvent actionEvent) {

    }

    public void copy(ActionEvent actionEvent) {

    }
}
