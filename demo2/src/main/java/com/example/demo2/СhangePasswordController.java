package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class СhangePasswordController {

    @FXML
    private Button ChangePasswordButtuon;

    @FXML
    private TextField newPassswordTextfield;

    @FXML
    private TextField theSameNewPassword;

    @FXML
    void ChangePasswordClick(ActionEvent event) throws SQLException, ClassNotFoundException {
        DataBaseHandle dataBase = new DataBaseHandle();
       // String oldPassword = dataBase.getThisPassword(SignInController.loginOfCurrentUser);
        String newPassword = newPassswordTextfield.getText();
        //проверка на совпадение со старым и с новым введенным
        dataBase.setPassword(newPassword, SignInController.loginOfCurrentUser);




    }

}
