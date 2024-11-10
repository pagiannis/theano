package com.example.demo;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class OpenApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("open-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Θέατρο Θεανώ");
        stage.setScene(scene);

        URL cssURL = getClass().getResource("/css/styles.css");
        if (cssURL != null) {
            scene.getStylesheets().add(cssURL.toExternalForm());
        } else {
            System.out.println("CSS file not found.");
        }

        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}