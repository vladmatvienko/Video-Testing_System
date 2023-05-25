package com.example.demo2;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignUpController extends HelloApplication { ;
    Scanner sc = new Scanner(System.in);
    @FXML
    private Button SignUpButton;

    @FXML
    private TextField NameField;

    @FXML
    void InsertName(ActionEvent event) {

    }
    @FXML
    void initialize(){
        DataBaseHandle dataBase = new DataBaseHandle();
        SignUpButton.setOnAction(event -> {
            dataBase.SignUpUser(NameField.getText());
        });
    }
    @FXML
    void Click(ActionEvent event) {



        //String nameText  = NameField.getText().trim(); трим метод, который убирает все пробелы
        //if(!nameText.equals("")){
          //  loginUser(nameText);
       // }
       // else{
         //   System.out.println("Error");
        //}
    }
    //private void loginUser(String nameText) {
    //}
}

