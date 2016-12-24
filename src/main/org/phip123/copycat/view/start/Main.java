package org.phip123.copycat.view.start;/**
 * Created by phip123 on 24.12.2016.
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class Main extends Application {

    private static final Logger log = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new MainController().launchMainScreen(primaryStage);
    }
}
