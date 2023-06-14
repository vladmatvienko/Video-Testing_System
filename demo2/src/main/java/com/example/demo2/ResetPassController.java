package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class ResetPassController {
    UserData user = new UserData();
    DataBaseHandle db = new DataBaseHandle();
    @FXML
    private Label currentSecretAnswer;


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        System.out.println(db.getSecretQuestion(SignInController.loginOfCurrentUser));//= null почему?
        currentSecretAnswer.setText(db.getSecretQuestion(SignInController.loginOfCurrentUser));



    }
}
