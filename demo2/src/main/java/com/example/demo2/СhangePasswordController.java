package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;
/**
 * Класс предназначен для контроля изменения пароля
 * @author bli34
 * @version 1.0.0
 */
public class СhangePasswordController {
    /**
     * @param ChangePasswordButtuon кнопка подтверждения изменения пароля
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Button ChangePasswordButtuon;
    /**
     * @param newPassswordTextfield поле для нового пароля
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextField newPassswordTextfield;
    /**
     * @param newPassswordTextfield поле с таким же новым паролем
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextField theSameNewPassword;
    /**
     * @param event парметр, благодаря которому выполняется метод ChangePasswordClick
     * ChangePasswordClick() метод, меняющий пароль пользователя
     * @throws SQLException в случае, когда ChangePasswordClick не срабтывает
     * @throws ClassNotFoundException в случае, когда ChangePasswordClick не срабтывает
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    void ChangePasswordClick(ActionEvent event) throws SQLException, ClassNotFoundException {
        DataBaseHandle dataBase = new DataBaseHandle();
       // String oldPassword = dataBase.getThisPassword(SignInController.loginOfCurrentUser);
        String newPassword = newPassswordTextfield.getText();
        //проверка на совпадение со старым и с новым введенным
        dataBase.setPassword(newPassword, SignInController.loginOfCurrentUser);




    }

}
