package com.example.demo;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormController {

    @FXML
    private VBox formVBox; // The VBox containing your form

    @FXML
    private TextField firstNameInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private TextField phoneNumberInput;

    @FXML
    private TextField emailInput;

    @FXML
    private Spinner<Integer> sheetsNumInput;

    @FXML
    public void initialize() {
        // Set the range for the seatSpinner
        sheetsNumInput.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));
    }

    @FXML
    private TextField presentationInput;


    // Method for submit button action
    @FXML
    private void handleSubmit() {
        String firstName = firstNameInput.getText();
        String lastName = lastNameInput.getText();
        String phone = phoneNumberInput.getText();
        String email = emailInput.getText();
        int sheetsNumber = sheetsNumInput.getValue();
        String presentation = presentationInput.getText();

        // Clear the VBox to remove the form
        formVBox.getChildren().clear();

        // Add booking information into the VBox
        Label titleLabel = new Label("Επιβεβαίωση Κράτησης");
        titleLabel.setStyle("-fx-font-family: Baskerville; -fx-font-size: 26px; -fx-font-weight: Bold; -fx-padding: 20;");
        formVBox.getChildren().add(titleLabel);

        // Create HBox for horizontal layout
        HBox confirmationBox = new HBox(20); // Horizontal spacing of 20
        confirmationBox.setAlignment(Pos.CENTER); // Center alignment

        // Create VBox for labels
        VBox labelColumn = new VBox(10); // Vertical spacing of 10
        labelColumn.setAlignment(Pos.CENTER_LEFT); // Align labels to the left
        labelColumn.getChildren().addAll(
                new Label("Όνομα:"),
                new Label("Επώνυμο:"),
                new Label("Τηλέφωνο:"),
                new Label("Email:"),
                new Label("Αριθμός θέσεων:"),
                new Label("Παράσταση:")
        );
        labelColumn.setStyle("-fx-font-family: Baskerville; -fx-font-size: 18px;");

        // Create VBox for values
        VBox valueColumn = new VBox(10); // Vertical spacing of 10
        valueColumn.setAlignment(Pos.CENTER_LEFT); // Align values to the left
        valueColumn.getChildren().addAll(
                new Label(firstName),
                new Label(lastName),
                new Label(phone),
                new Label(email),
                new Label(String.valueOf(sheetsNumber)),
                new Label(presentation)
        );
        valueColumn.setStyle("-fx-font-family: Baskerville; -fx-font-size: 18px;");

        // Add both VBoxes to the HBox
        confirmationBox.getChildren().addAll(labelColumn, valueColumn);

        // Add the HBox to the main VBox
        formVBox.getChildren().add(confirmationBox);

        Label thankyouLabel = new Label("Ευχαριστούμε");
        thankyouLabel.setStyle("-fx-font-family: Baskerville; -fx-font-size: 25px; -fx-padding: 45");

        formVBox.getChildren().add(thankyouLabel);
    }
}