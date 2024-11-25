package com.example.demo;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class OpenApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("open-view.fxml"));
        StackPane root = loader.load();
        Scene scene = new Scene(root);
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