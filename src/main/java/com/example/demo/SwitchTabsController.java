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
    private void openReservationForm() throws IOException {
        mainStage.hide();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form-view.fxml"));
        Scene formScene = new Scene(fxmlLoader.load());

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
                // If the form loses focus, show the main stage again
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
                {"Κοκκινοσκουφίτσα", "2024-12-01  18:00"},
                {"Ο Πλούτος", "2024-12-05  21:20"},
                {"Ηρακλής", "2024-12-10  19:00"}
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
        performancePane.setStyle("-fx-background-color: #d3d3d3; -fx-opacity:0.8;");
        performancePane.setOnMouseEntered(event -> performancePane.setStyle("-fx-background-color: #bbbbbb;"));
        performancePane.setOnMouseExited(event -> performancePane.setStyle("-fx-background-color: #d3d3d3;"));

        VBox infoBox = new VBox();
        infoBox.setSpacing(5);
        infoBox.setStyle("-fx-alignment: center;");

        javafx.scene.control.Label nameLabel = new javafx.scene.control.Label(name);
        nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        javafx.scene.control.Label dateLabel = new javafx.scene.control.Label(date);
        dateLabel.setStyle("-fx-font-size: 12px;");

        infoBox.getChildren().addAll(nameLabel, dateLabel);

        Button bookButton = new Button("κράτηση");
        bookButton.setStyle("-fx-cursor: hand; -fx-opacity:1;");
        bookButton.setOnAction(event -> {
            try {
                openReservationForm();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Tooltip tooltip = new Tooltip(name + "\n" + date);
        Tooltip.install(performancePane, tooltip);

        performancePane.getChildren().addAll(infoBox, bookButton);

        int row = index / 5; // 5 per row
        int col = index % 5;
        performancesGrid.add(performancePane, col, row);
    }

}
