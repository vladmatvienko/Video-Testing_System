package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.sql.SQLException;

public class ResetPassController {
    UserData user = new UserData();
    DataBaseHandle db = new DataBaseHandle();
    @FXML
    private TextField AnswerOnSecretQuestion;

    @FXML
    private Label ErrorThesamePasswordField;

    @FXML
    private Label InputNewPassLabel;

    @FXML
    private TextField NewPassword_Field;

    @FXML
    private Label currentSecretAnswer;

    @FXML
    private Label successfulChangeLabel;

    @FXML
    private Button saveButton;

    @FXML
    void ClickOnAnswerField(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(AnswerOnSecretQuestion.getText().trim().equals(db.getSecretAnswer(SignInController.loginOfCurrentUser))){
            InputNewPassLabel.setVisible(true);
            NewPassword_Field.setVisible(true);
            saveButton.setVisible(true);

        }
        else {
            HelloApplication.switchToNewWindow("MessageToAdmin");
        }

    }
    @FXML
    void inputNewPassEvent(KeyEvent event) {
         ErrorThesamePasswordField.setVisible(false);
    }

    @FXML
    void ClickOnSaveButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        user.setPassword(NewPassword_Field.getText().trim());
        user.setLogin(SignInController.loginOfCurrentUser);//видимо не в том месте был loginOfCurrentUser в SignIn, так как был 0
        if(db.getThisPassword(SignInController.loginOfCurrentUser).equals(NewPassword_Field.getText().trim())){
            ErrorThesamePasswordField.setVisible(true);
            NewPassword_Field.setText(null);}
        else if (!db.getThisPassword(SignInController.loginOfCurrentUser).equals(NewPassword_Field.getText().trim())) {
            db.setPassword(NewPassword_Field.getText().trim(), SignInController.loginOfCurrentUser);
            successfulChangeLabel.setVisible(true);
            db.antiban(SignInController.loginOfCurrentUser);
            db.setPassword(NewPassword_Field.getText().trim(), SignInController.loginOfCurrentUser);
            //обновляем пароль выводим надпись успешной смены
        }
        System.out.println("Правильно!");
    }



    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
       // System.out.println(SignInController.loginOfCurrentUser);
        //System.out.println(db.getSecretQuestion(SignInController.loginOfCurrentUser));//= Сделал  так, что все бралось из таблицы?
        System.out.println(SignInController.loginOfCurrentUser);
        System.out.println(db.getSecretQuestion(SignInController.loginOfCurrentUser));
        currentSecretAnswer.setText(db.getSecretQuestion(SignInController.loginOfCurrentUser)+"?");
        ErrorThesamePasswordField.setVisible(false);
        InputNewPassLabel.setVisible(false);
        NewPassword_Field.setVisible(false);
        successfulChangeLabel.setVisible(false);
        saveButton.setVisible(false);




    }
}
