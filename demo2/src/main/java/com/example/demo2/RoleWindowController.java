package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
/**
 * Класс предназначен для контроля окна с иерархией должностей
 * @author bli34
 * @version 1.0.0
 */
public class RoleWindowController {
    /**
     * @param resources является источником для взятия данных из ПКА
     * @author bli34
     * @version 1.0.0
     */
        @FXML
        private ResourceBundle resources;
    /**
     * @param location является ссылкой для перехода в ПК
     * @author bli34
     * @version 1.0.0
     */
        @FXML
        private URL location;
    /**
     * @param ID_field поле с ID пользователей
     * @author bli34
     * @version 1.0.0
     */
        @FXML
        private TextField ID_field;
    /**
     * @param analytic_button кнопка, которая позволяет перейти в окно аналитикой
     * @author bli34
     * @version 1.0.0
     */
        @FXML
        private Button analytic_button;
    /**
     * @param user_button кнопка, которая позволяет перейти в окно с данными пользователя
     * @author bli34
     * @version 1.0.0
     */
        @FXML
        private Button user_button;
    /**
     * initialize() метод инициализации ранее введенных данных
     * @author bli34
     * @version 1.0.0
     */
        @FXML
        void initialize() {
            DataBaseHandle db = new DataBaseHandle();
            user_button.setOnAction(event -> {
                try {
                    db.RoleInfUser(Integer.parseInt(ID_field.getText()));
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
            analytic_button.setOnAction(event -> {
                try {
                    db.RoleInfAnalytic(Integer.parseInt(ID_field.getText()));
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });

        }

    }

