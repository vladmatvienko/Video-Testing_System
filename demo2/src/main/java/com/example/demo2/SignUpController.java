package com.example.demo2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.ArrayList;


public class SignUpController {


    @FXML
    private CheckBox secretQuestionCheckBox;
    @FXML
    private Button authSignUpButton;

    @FXML
    private Label fillAllGapsLabel;
    @FXML
    private TextField signUpFatherName;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField signUpDate;

    @FXML
    private TextField signUpEmail;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpPhonenumber;

    @FXML
    private TextField signUpSurname;
    @FXML
    private Label loginIsUsed;
    public static String loginOfCurrentUser;
    @FXML
    void initialize() {
        fillAllGapsLabel.setVisible(false);
        loginIsUsed.setVisible(false);
        secretQuestionCheckBox.setVisible(false);
    }

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






