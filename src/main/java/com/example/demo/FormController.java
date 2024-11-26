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
    private VBox formVBox;

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
        sheetsNumInput.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));
    }

    @FXML
    private TextField presentationInput;

    @FXML
    private TextField dateInput;


    @FXML
    private void handleSubmit() {
        String firstName = firstNameInput.getText();
        String lastName = lastNameInput.getText();
        String phone = phoneNumberInput.getText();
        String email = emailInput.getText();
        int sheetsNumber = sheetsNumInput.getValue();
        String presentation = presentationInput.getText();
        String date = dateInput.getText();

        formVBox.getChildren().clear();

        Label titleLabel = new Label("Επιβεβαίωση Κράτησης");
        titleLabel.setStyle("-fx-font-family: Baskerville; -fx-font-size: 26px; -fx-font-weight: Bold; -fx-padding: 20;");
        formVBox.getChildren().add(titleLabel);

        HBox confirmationBox = new HBox(20);
        confirmationBox.setAlignment(Pos.CENTER);

        VBox labelColumn = new VBox(10);
        labelColumn.setAlignment(Pos.CENTER_LEFT);
        labelColumn.getChildren().addAll(
                new Label("Όνομα:"),
                new Label("Επώνυμο:"),
                new Label("Τηλέφωνο:"),
                new Label("Email:"),
                new Label("Αριθμός θέσεων:"),
                new Label("Παράσταση:"),
                new Label("Ημερομηνία-Ώρα:")
        );
        labelColumn.setStyle("-fx-font-family: Baskerville; -fx-font-size: 18px;");

        VBox valueColumn = new VBox(10);
        valueColumn.setAlignment(Pos.CENTER_LEFT);
        valueColumn.getChildren().addAll(
                new Label(firstName),
                new Label(lastName),
                new Label(phone),
                new Label(email),
                new Label(String.valueOf(sheetsNumber)),
                new Label(presentation),
                new Label(date)
        );
        valueColumn.setStyle("-fx-font-family: Baskerville; -fx-font-size: 18px;");

        confirmationBox.getChildren().addAll(labelColumn, valueColumn);

        formVBox.getChildren().add(confirmationBox);

        Label thankyouLabel = new Label("Ευχαριστούμε");
        thankyouLabel.setStyle("-fx-font-family: Baskerville; -fx-font-size: 25px; -fx-padding: 55");

        formVBox.getChildren().add(thankyouLabel);
    }
}