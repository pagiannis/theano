package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ReservationController {
    @FXML
    private Text textForButton;

    @FXML
    protected void onReservationButtonClick() {

        textForButton.setText("You clicked reservation");
    }

    @FXML
    protected void onComingButtonClick() {

        textForButton.setText("You clicked Coming");
    }
}