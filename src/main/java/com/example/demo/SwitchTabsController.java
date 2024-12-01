package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SwitchTabsController {

    @FXML
    private AnchorPane openView;

    @FXML
    private AnchorPane performancesView;

    @FXML
    private GridPane performancesGrid;

    private Stage mainStage;

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @FXML
    public void initialize() {
        openView.setVisible(true);
        performancesView.setVisible(false);
    }


    @FXML
    private void openReservationForm(String name, String date) throws IOException {
        mainStage.hide();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form-view.fxml"));
        Scene formScene = new Scene(fxmlLoader.load());

        FormController formController = fxmlLoader.getController();
        formController.setPerformanceDetails(name, date);//Interact with Form Controller

        Stage formStage = new Stage();
        formStage.setTitle("Reservation Form");
        formStage.setScene(formScene);

        URL cssURL = getClass().getResource("/css/styles.css");
        if (cssURL != null) {
            formScene.getStylesheets().add(cssURL.toExternalForm());
        } else {
            System.out.println("CSS file not found.");
        }

        formStage.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                mainStage.show();
            }
        });

        formStage.show();

    }

    @FXML
    private void showPerformancesView() {
        openView.setVisible(false);
        performancesView.setVisible(true);
        loadPerformances();
    }

    @FXML
    private void showMainMenu(){
        openView.setVisible(true);
        performancesView.setVisible(false);
    }

    private void loadPerformances() {
        // Updated data structure without the image paths
        String[][] performances = {
                {"Κοκκινοσκουφίτσα", "01-12-2024  18:00"},
                {"Ο Πλούτος", "01-01-2024  21:20"},
                {"Ηρακλής", "01-10-2024  19:00"},
                {"Μήδεια", "05-12-2024  19:30"},
                {"Ηλέκτρα", "11-12-2024  21:45"},
                {"Η Τρικυμία", "11-12-2024  20:50"},
                {"Το Μαγεμένο Δάσος", "13-12-2024  20:30"},
                {"Λυσιστράτη", "13-12-2024  21:00"},
                {"Η Μικρή μας Πόλη", "13-12-2024  22:00"},
                {"Η Φάρμα των Ζώων", "13-12-2024  21:00"},
                {"Αντιγόνη", "15-12-2024  20:45"},
                {"Ο Μικρός Πρίγκιπας", "15-11-2024  17:30"}
        };

        for (int i = 0; i < performances.length; i++) {
            addPerformanceToGrid(performances[i], i);
        }
    }


    private void addPerformanceToGrid(String[] performanceData, int index) {
        String name = performanceData[0];
        String date = performanceData[1];

        StackPane performancePane = new StackPane();
        performancePane.setPrefSize(140, 140);
        performancePane.setStyle("-fx-background-color: #d3d3d3; -fx-background-radius: 5; -fx-border-radius: 5; -fx-padding: 5;");

        VBox infoBox = new VBox();
        infoBox.setSpacing(5);
        infoBox.setStyle("-fx-alignment: center;");

        javafx.scene.control.Label nameLabel = new javafx.scene.control.Label(name);
        nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        javafx.scene.control.Label dateLabel = new javafx.scene.control.Label(date);
        dateLabel.setStyle("-fx-font-size: 12px;");

        infoBox.getChildren().addAll(nameLabel, dateLabel);

        Button bookButton = new Button("κράτηση");
        bookButton.setStyle("-fx-cursor: hand; -fx-background-color: #FC7E7E; -fx-text-fill: white; -fx-background-radius:10px; -fx-border-radius:10px; -fx-border-color: #FC7E7E;");
        bookButton.setOnAction(event -> {
            try {
                openReservationForm(name,date);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        VBox contentBox = new VBox();
        contentBox.setSpacing(10);
        contentBox.setAlignment(Pos.CENTER);

        contentBox.getChildren().addAll(infoBox,bookButton);

        Tooltip tooltip = new Tooltip(name + "\n" + date);
        Tooltip.install(performancePane, tooltip);

        performancePane.getChildren().addAll(contentBox);

        int row = index / 4; // 4 per row
        int col = index % 4;
        performancesGrid.add(performancePane, col, row);
    }

}
