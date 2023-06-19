package com.example.demo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * Класс предназначен для того, чтобы БД пользователей
 * @author bli34
 * @version 1.0.0
 */
public class ControlOfUsersController {
    /**
     * @param resources является источником для взятия данных из ПКА
     * @author bli34
     * @version 1.0.0
     */
        @FXML
        private ResourceBundle resources;
    /**
     * @param location является ссылкой для перехода в ПК(Персонального Кабинета)
     * @author bli34
     * @version 1.0.0
     */
        @FXML
        private URL location;
    /**
     * @param Access_button кнопка, которая в зависимости от заполненных данных даёт доступ
     * @author bli34
     * @version 1.0.0
     */
        @FXML
        private Button Access_button;
    /**
     * @param Block_button является кнопкой, при нажатии на которую все ранее записанные ответы идут в базу данных
     * @author bli34
     * @version 1.0.0
     */
        @FXML
        private Button Block_button;
    /**
     * @param Role_button является кнопкой, при нажатии на которую выдаётся должность в зависимости от введенных данных
     * @author bli34
     * @version 1.0.0
     */
        @FXML
        private Button Role_button;
    /**
     * initialize() нужен для выполнения действий с ранее описанными параметрами
     * @author bli34
     * @version 1.0.0
     */
        @FXML
        void initialize() {
            Block_button.setOnAction(event -> {
                //Block_button.getScene().getWindow().hide();
                HelloApplication.switchToNewWindow("Block_window");
            });
            Role_button.setOnAction(event -> {
                //Block_button.getScene().getWindow().hide();
                HelloApplication.switchToNewWindow("Role_window");
            });


        }

    }


