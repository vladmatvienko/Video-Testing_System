package com.example.demo2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
/**
 * Класс предназначен для функционирования персонального кабинета администратора
 * @author bli34
 * @version 1.0.0
 */
public class AdminPersonalCabinetController {
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
     * @param Control_button является кнопкой управления, нажимая которую можно перейти в приложение
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Button Control_button;
    /**
     * @param Personal_cab_button является кнопкой управления, которая переводит администратора в личный кабинет
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Button Personal_cab_button;
    /**
     * @param All_Users_TextArea является текстовой зоной со всеми данными о пользователях программы
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextArea All_Users_TextArea;
    /**
     * @param Video_base_button является кнопкой, которая переводит пользователя в базу данных со всеми видео
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Button Video_base_button;
    /**
     * initialize() нужен для перехода в приложение после регистрации и дальнейших действий в ПКА
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    void initialize() {
        /**
         * @param DataBaseHandle является параметром, который позволяет управлять базой данных
         * @throws RuntimeException(e) в случае, когда кнопка Personal_cab_button не переводит в ПКА
         * @author bli34
         * @version 1.0.0
         */
        DataBaseHandle db = new DataBaseHandle();
        Control_button.setOnAction(event -> {
            Control_button.getScene().getWindow().hide();

            HelloApplication.switchToNewWindow("ControlOfUsers");
        });
        Personal_cab_button.setOnAction(event -> {

            try {
                All_Users_TextArea.setText(db.getPersonalInformation().toString());

            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        });


    }


}