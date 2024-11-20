package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class FormController {

    private int i=1;

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
        Object sheetsNumber = sheetsNumInput.getValue();
        String presentation = presentationInput.getText();

        // Clear the VBox to remove the form
        formVBox.getChildren().clear();

        // Add booking information into the VBox
        Label titleLabel = new Label("Επιβεβαίωση Κράτησης");
        titleLabel.setStyle("-fx-font-family: Baskerville; -fx-font-size: 26px; -fx-font-weight: Bold; -fx-padding: 10;");

        Label firstNameLabel = new Label("Όνομα: " + firstName);
        firstNameLabel.setStyle("-fx-font-family: Baskerville; -fx-font-size: 18px;");

        Label lastNameLabel = new Label("Επίθετο: "+lastName);
        lastNameLabel.setStyle("-fx-font-family: Baskerville; -fx-font-size: 18px;");

        Label phoneLabel = new Label("Τηλέφωνο: "+phone);
        phoneLabel.setStyle("-fx-font-family: Baskerville; -fx-font-size: 18px;");

        Label emailLabel = new Label("Email: "+email);
        emailLabel.setStyle("-fx-font-family: Baskerville; -fx-font-size: 18px;");

        Label sheetsNumberLabel = new Label("Αριθμός Θέσεων: "+sheetsNumber);
        sheetsNumberLabel.setStyle("-fx-font-family: Baskerville; -fx-font-size: 18px;");

        Label presentationLabel = new Label("Παράσταση: "+presentation);
        presentationLabel.setStyle("-fx-font-family: Baskerville; -fx-font-size: 18px;");

        Label indexLabel = new Label("Αριθμός Κράτησης: "+i);
        indexLabel.setStyle("-fx-font-family: Baskerville; -fx-font-size: 18px;");
        i+=1;

        Label thankyouLabel = new Label("Ευχαριστούμε");
        thankyouLabel.setStyle("-fx-font-family: Baskerville; -fx-font-size: 25px; -fx-padding: 30");

        formVBox.getChildren().addAll(titleLabel, firstNameLabel, lastNameLabel, phoneLabel, emailLabel, sheetsNumberLabel, presentationLabel, indexLabel, thankyouLabel);
    }
}
