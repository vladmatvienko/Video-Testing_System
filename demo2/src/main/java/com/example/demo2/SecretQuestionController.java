package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class SecretQuestionController {
    ObservableList<String> secretQuestionList = FXCollections.observableArrayList("Девичья фамилия мамы", "Оценка по матанализу", "Вес");
    @FXML
    private TextField secretAnswerField;
    @FXML
    private ComboBox<String> secretQuestionComboBox = new ComboBox<>(secretQuestionList) ;
    DataBaseHandle db = new DataBaseHandle();
    public void initialize() throws SQLException, ClassNotFoundException {
    secretQuestionComboBox.setValue("Девичья фамилия мамы");
    secretQuestionComboBox.setItems(secretQuestionList);
    System.out.println(secretQuestionComboBox.getValue().trim());
    db.setSecretQuestion(SignUpController.loginOfCurrentUser, secretQuestionComboBox.getValue().trim());


    }
    @FXML
    void SaveSecretQuestion(ActionEvent event) throws SQLException, ClassNotFoundException {
        System.out.println("Проверка");
        db.setSecretAnswer(SignUpController.loginOfCurrentUser, secretAnswerField.getText().trim());

    }

}




