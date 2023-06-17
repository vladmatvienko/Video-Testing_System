package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
public class ControlOfUsersController {


        @FXML
        private Button Block_button;

        @FXML
        private Button Role_button;

        @FXML
        void initialize() {
            Block_button.setOnAction(event -> {
                //Block_button.getScene().getWindow().hide();
                HelloApplication.switchToNewWindow("Block_window");
            });
            Role_button.setOnAction(event -> {
                //Block_button.getScene().getWindow().hide();
                HelloApplication.switchToNewWindow("Role_window");
            });


        }

    }


