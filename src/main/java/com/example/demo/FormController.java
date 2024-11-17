package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class FormController {

    @FXML
    private TextField firstNameInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private TextField phoneNumberInput;

    @FXML
    private TextField emailnput;

    @FXML
    private Spinner sheetsNumInput;

    @FXML
    private TextField PresentationInput;

    @FXML
    private void setPresentantionInputValue(){
        PresentationInput.setText("Hi");
    }

    // Method for submit button action
    @FXML
    private void handleSubmit() {
        String firstName = firstNameInput.getText();
        String lastName = lastNameInput.getText();
        String phone = phoneNumberInput.getText();
        String email = emailnput.getText();
        Object sheetsNumber = sheetsNumInput.getValue();



    }

}
