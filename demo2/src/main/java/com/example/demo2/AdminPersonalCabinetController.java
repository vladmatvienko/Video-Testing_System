package com.example.demo2;



import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class AdminPersonalCabinetController {



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

    @FXML
    void clickVideoBase(ActionEvent event) {
        HelloApplication.switchToNewWindow("VideoChangeAdmin");

    }
}