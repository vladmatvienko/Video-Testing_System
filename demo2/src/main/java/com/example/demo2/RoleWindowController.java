package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class RoleWindowController {
        @FXML
        private TextField ID_field;

        @FXML
        private Button analytic_button;

        @FXML
        private Button user_button;

        @FXML
        void initialize() {
            DataBaseHandle db = new DataBaseHandle();
            user_button.setOnAction(event -> {
                try {
                    db.RoleInfUser(Integer.parseInt(ID_field.getText()));
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
            analytic_button.setOnAction(event -> {
                try {
                    db.RoleInfAnalytic(Integer.parseInt(ID_field.getText()));
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });

        }

    }

