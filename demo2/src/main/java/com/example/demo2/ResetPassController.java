package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.sql.SQLException;
/**
 * Класс предназначен для смены пароля
 * @author bli34
 * @version 1.0.0
 */
public class ResetPassController {
    /**
     * @param user предназначен для обновления данных пользователя
     * @author bli34
     * @version 1.0.0
     */
    UserData user = new UserData();
    /**
     * @param db предназначен для обновления базы данных
     * @author bli34
     * @version 1.0.0
     */
    DataBaseHandle db = new DataBaseHandle();
    /**
     * @param AnswerOnSecretQuestion поле для ответа на секреьный вопрос
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextField AnswerOnSecretQuestion;
    /**
     * @param ErrorThesamePasswordField выдаёт ошибку при введении того-же пароля, что и раньше(отдельное поле)
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Label ErrorThesamePasswordField;
    /**
     * @param InputNewPassLabel заметка, которая просит ввести новый пароль
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Label InputNewPassLabel;
    /**
     * @param NewPassword_Field поле для введения нового пароля
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextField NewPassword_Field;
    /**
     * @param currentSecretAnswer сохраняетответ на секретный вопрос
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Label currentSecretAnswer;
    /**
     * @param successfulChangeLabel выводит сообщение о успешном изменении пароля
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Label successfulChangeLabel;
    /**
     * @param saveButton кнопка сохранения введенных данных
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Button saveButton;
    /**
     * @param event парметр, благодаря которому выполняется метод ClickOnAnswerField
     * ClickOnAnswerField() метод, кооторый позволяет нажать на поле с ответом
     * @throws SQLException в случае, когда ClickOnAnswerField не срабтывает
     * @throws ClassNotFoundException в случае, когда ClickOnAnswerField не срабтывает
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    void ClickOnAnswerField(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(AnswerOnSecretQuestion.getText().equals(db.getSecretAnswer(SignInController.loginOfCurrentUser))){
            InputNewPassLabel.setVisible(true);
            NewPassword_Field.setVisible(true);
            saveButton.setVisible(true);

        }
        else {
            HelloApplication.switchToNewWindow("MessageToAdmin");
        }

    }
    /**
     * @param event парметр, благодаря которому выполняется метод inputNewPassEvent
     * inputNewPassEvent() метод, кооторый позволяет ввести новый пароль после введения того же нового пароля
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    void inputNewPassEvent(KeyEvent event) {
         ErrorThesamePasswordField.setVisible(false);
    }
    /**
     * @param event парметр, благодаря которому выполняется метод ClickOnSaveButton
     * ClickOnSaveButton() метод, кооторый позволяет нажать на кнопку сохранения введенных данных
     * @throws SQLException в случае, когда ClickOnSaveButton не срабтывает
     * @throws ClassNotFoundException в случае, когда ClickOnSaveButton не срабтывает
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    void ClickOnSaveButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        user.setPassword(NewPassword_Field.getText());
        user.setLogin(SignInController.loginOfCurrentUser);//видимо не в том месте был loginOfCurrentUser в SignIn, так как был 0
        if(db.getThisPassword(SignInController.loginOfCurrentUser).equals(NewPassword_Field.getText())){
            ErrorThesamePasswordField.setVisible(true);
            NewPassword_Field.setText(null);}
        else if (!db.getThisPassword(SignInController.loginOfCurrentUser).equals(NewPassword_Field.getText())) {
            db.setPassword(NewPassword_Field.getText(), SignInController.loginOfCurrentUser);
            successfulChangeLabel.setVisible(true);
            db.antiban(SignInController.loginOfCurrentUser);
            db.setPassword(NewPassword_Field.getText(), SignInController.loginOfCurrentUser);
            //обновляем пароль выводим надпись успешной смены
        }
        System.out.println("Правильно!");
    }


    /**
     * initialize() метод инициализации ранее введенных данных
     * @throws SQLException в случае, когда initialize не срабтывает
     * @throws ClassNotFoundException в случае, когда initialize не срабтывает
     * @author bli34
     * @version 1.0.0
     */
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
