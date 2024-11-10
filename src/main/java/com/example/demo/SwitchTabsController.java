package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SwitchTabsController {
    @FXML
    private TabPane tabPane; // Reference to your TabPane

    @FXML
    private Button button1, button2, button3;


    @FXML
    public void initialize() {
        // Set the default style class for button1
        button1.getStyleClass().add("selected-button");
    }

    @FXML private void switchToTab1() {
        tabPane.getSelectionModel().select(0); // Switch to Tab 1
        setSelectedButton(button1);
    }

    @FXML
    private void switchToTab2() {
        tabPane.getSelectionModel().select(1); // Switch to Tab 2
        setSelectedButton(button2);
    }

    @FXML
    private void switchToTab3() {
        tabPane.getSelectionModel().select(2); // Switch to Tab 3
        setSelectedButton(button3);
    }

    private void setSelectedButton(Button selectedButton) {
        button1.getStyleClass().remove("selected-button");
        button2.getStyleClass().remove("selected-button");
        button3.getStyleClass().remove("selected-button");
        selectedButton.getStyleClass().add("selected-button");
    }

    @FXML
    private void openReservationFormPresentation1() throws IOException {
        openReservationForm();
    }

    @FXML
    private void openReservationFormPresentation2() throws IOException {
        openReservationForm();
    }

    @FXML
    private void openReservationForm() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form-view.fxml"));
        Scene formScene = new Scene(fxmlLoader.load());

        Stage formStage = new Stage();
        formStage.setTitle("Reservation Form");
        formStage.setScene(formScene);
        formStage.show();
    }

}
