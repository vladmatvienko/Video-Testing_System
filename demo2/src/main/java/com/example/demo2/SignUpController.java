package com.example.demo2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Класс предназначен для контроля регистрации пользователей
 * @author bli34
 * @version 1.0.0
 */
public class SignUpController {
    /**
     * @param secretQuestionCheckBox проверяет ответ на секретный вопрос в БД
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private CheckBox secretQuestionCheckBox;
    /**
     * @param authSignUpButton кнопка, которая позволяет авторизоваться в системе при регистрации
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Button authSignUpButton;
    /**
     * @param fillAllGapsLabel заметка, которая выскакивает когда все поля заполненны
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Label fillAllGapsLabel;
    /**
     * @param signUpFatherName поле, в которое нужно ввести отчество
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextField signUpFatherName;
    /**
     * @param login_field поле, в котором находится логин пользователя при регистрации
     * @author bli34
     * @version 1.0.0
     */

    @FXML
    private TextField login_field;
    /**
     * @param password_field поле, в котором находится пароль пользователя при регестрации
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private PasswordField password_field;
    /**
     * @param signUpDate поле, в котором находится дата регистрации пользователя
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextField signUpDate;
    /**
     * @param signUpEmail поле, в котором находится почта пользователя при регестрации
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextField signUpEmail;
    /**
     * @param signUpName поле, в котором находится имя пользователя при регестрации
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextField signUpName;
    /**
     * @param signUpPhonenumber поле, в котором находится номер пользователя при регестрации
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextField signUpPhonenumber;
    /**
     * @param signUpSurname поле, в котором находится отчество пользователя при регестрации
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextField signUpSurname;
    /**
     * @param loginIsUsed заметка, которая появляется при проверке логина регистрации, который используется
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Label loginIsUsed;
    /**
     * @param loginOfCurrentUser заметка, которая появляется при проверке логина регистрации на принадлежность пользователю
     * @author bli34
     * @version 1.0.0
     */
    public static String loginOfCurrentUser;
    /**
     * initialize() нужен для перехода в приложение после регистрации и дальнейших действий в ПКА
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    void initialize() {
        fillAllGapsLabel.setVisible(false);
        loginIsUsed.setVisible(false);
        secretQuestionCheckBox.setVisible(false);
    }
    /**
     * @param event парметр, благодаря которому выполняется метод clickSignUpButton
     * clickSignUpButton() метод, который позволяет нажать на кнопку регистрации
     * @throws SQLException в случае, когда clickSignUpButton не срабтывает
     * @throws ClassNotFoundException в случае, когда clickSignUpButton не срабтывает
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    void clickSignUpButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        boolean a =
        login_field.getText().trim().isEmpty() || password_field.getText().trim().isEmpty() || signUpName.getText().trim().isEmpty()
        || signUpSurname.getText().trim().isEmpty()  || signUpDate.getText().trim().isEmpty()|| signUpEmail.getText().trim().isEmpty();
        if(a == true){
            fillAllGapsLabel.setVisible(true);
        }

        else {
        DataBaseHandle db = new DataBaseHandle();
        UserData user = new UserData();
        //регулярные выражения и проверки
        ArrayList<String> passwordsArray = db.getPasswordArray();
            if(passwordsArray.contains(login_field.getText())){
              loginIsUsed.setVisible(true);
               login_field.setText(null);
               }
                    else{
                         user.setLogin(login_field.getText().trim());
                         user.setPassword(password_field.getText().trim());
                         user.setName(signUpName.getText().trim());
                         user.setSurname(signUpSurname.getText().trim());
                         user.setFatherName(signUpFatherName.getText().trim());
                         user.setBirthDate(signUpDate.getText().trim());
                         user.setEmail(signUpEmail.getText().trim());
                         user.setPhoneNumber(signUpPhonenumber.getText().trim());
                         user.setSecretQuestion("-");
                         user.setSecretAnswer("-");
                         user.setGroup("user");
                         user.setAccess(1);
                         loginOfCurrentUser = user.getLogin().trim();
                        //проверить этот метод *
                         db.SignUpUser(user.getName(), user.getSurname(),user.getEmail(), user.getLogin(), user.getPassword(), user.getFatherName(), user.getBirthDate(), user.getGroup(), user.getSecretQuestion(), user.getPhoneNumber(), user.getAccess(), user.getSecretAnswer());
                         secretQuestionCheckBox.setVisible(true);
                         secretQuestionCheckBox.setOnAction(e -> HelloApplication.switchToNewWindow("SecretQuestion"));
                         //Stage stage = (Stage) authSignUpButton.getScene().getWindow();
                         //stage.close();//может сделать окно подтверждения регистрации?

    }}}
    /**
     * @param event парметр, благодаря которому выполняется метод loginFieldAction
     * loginFieldAction() метод, который позволяет посмотреть использован л логин или нет
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    void loginFieldAction(KeyEvent event) {
        loginIsUsed.setVisible(false);
    }
    //альтернатива *
    //@FXML
    //void addSecretQuestion(ActionEvent event) {
        //loginOfCurrentUser = login_field.getText();
       // HelloApplication.switchToNewWindow("SecretQuestion");


  //  }

}






