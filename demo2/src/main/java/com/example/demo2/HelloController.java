package com.example.demo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
/**
 * Класс, который контролирует процессы в приложении
 * @author bli34
 * @version 1.0.0
 */
public class HelloController {
    /**
     * @param welcomeText приветствующие тексты
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Label welcomeText;
    /**
     * onHelloButtonClick() метод, благодаря которому можно нажать на кнопку перехода в следующее окно
     * @throws ClassNotFoundException в случае не выполнения onHelloButtonClick()
     * @throws SQLException в случае не выполнения onHelloButtonClick()
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    protected void onHelloButtonClick() throws SQLException, ClassNotFoundException {
       HelloApplication.switchToNewWindow("SignIn");
    }
}