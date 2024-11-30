package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
                {"Το Καλοκαίρι του Φόβου", "13-12-2024  20:30"},
                {"Λυσιστράτη", "13-12-2024  21:00"},
                {"Το Παιχνίδι της Σφαγής", "13-12-2024  22:00"},
                {"Η Αυλή των Θαυμάτων", "13-12-2024  21:00"},
                {"Αντιγόνη", "15-12-2024  20:45"},
                {"Ο Μικρός Πρίγκιπας", "15-11-2024  17:30"},
                {"Η Χιονάτη και οι Επτά Νάνοι", "15-12-2024  17:20"},
                {"Ένας Ήρωας με Παντόφλες", "18-12-2024  19:00"},
                {"Ο Κουρέας της Σεβίλλης", "20-12-2024  20:20"},
                {"Η Χώρα των Θαυμάτων", "21-12-2024  20:00"}
        };

        for (int i = 0; i < performances.length; i++) {
            addPerformanceToGrid(performances[i], i);
        }
    }


    private void addPerformanceToGrid(String[] performanceData, int index) {
        String name = performanceData[0];
        String date = performanceData[1];

        StackPane performancePane = new StackPane();
        performancePane.setPrefSize(120, 120);
        performancePane.setStyle("-fx-background-color: #d3d3d3; -fx-opacity:0.8; -fx-background-radius: 10; -fx-border-radius: 10; -fx-padding: 10;");
        performancePane.setOnMouseEntered(event -> performancePane.setStyle("-fx-background-color: #bbbbbb;"));
        performancePane.setOnMouseExited(event -> performancePane.setStyle("-fx-background-color: #d3d3d3;"));

        VBox infoBox = new VBox();
        infoBox.setSpacing(5);
        infoBox.setStyle("-fx-alignment: center; -fx-spacing: 10;");

        javafx.scene.control.Label nameLabel = new javafx.scene.control.Label(name);
        nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        javafx.scene.control.Label dateLabel = new javafx.scene.control.Label(date);
        dateLabel.setStyle("-fx-font-size: 12px;");

        infoBox.getChildren().addAll(nameLabel, dateLabel);

        Button bookButton = new Button("κράτηση");
        bookButton.setStyle("-fx-cursor: hand; -fx-opacity:1;");
        bookButton.setStyle("-fx-background-color: #e63946; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10;");
        bookButton.setOnAction(event -> {
            try {
                openReservationForm(name,date);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Tooltip tooltip = new Tooltip(name + "\n" + date);
        Tooltip.install(performancePane, tooltip);

        performancePane.getChildren().addAll(infoBox, bookButton);

        int row = index / 4; // 4 per row
        int col = index % 4;
        performancesGrid.add(performancePane, col, row);
    }

}
