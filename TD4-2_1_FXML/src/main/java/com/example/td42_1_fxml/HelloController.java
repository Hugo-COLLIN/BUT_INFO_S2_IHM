package com.example.td42_1_fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    public void onButtonUnClick()
    {
        welcomeText.setText("Clic sur le bouton un");
    }

    @FXML
    public void onButtonDeuxClick()
    {
        welcomeText.setText("Clic sur le bouton deux");
    }
}