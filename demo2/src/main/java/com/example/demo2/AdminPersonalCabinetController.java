package com.example.demo2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class AdminPersonalCabinetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Control_button;

    @FXML
    private Button Personal_cab_button;

    @FXML
    private TextArea All_Users_TextArea;

    @FXML
    private Button Video_base_button;

    @FXML
    void initialize() {
        DataBaseHandle db = new DataBaseHandle();
        Control_button.setOnAction(event -> {
            Control_button.getScene().getWindow().hide();

            HelloApplication.switchToNewWindow("ControlOfUsers");
        });
        Personal_cab_button.setOnAction(event -> {

            try {
                All_Users_TextArea.setText(db.getPersonalInformation().toString());

            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        });


    }


}