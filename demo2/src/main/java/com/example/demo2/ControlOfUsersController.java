package com.example.demo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class ControlOfUsersController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button Access_button;

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


