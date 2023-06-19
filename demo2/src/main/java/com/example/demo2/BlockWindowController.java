package com.example.demo2;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * Класс предназначен для того, чтобы перенести данные пользователя в БД
 * @author bli34
 * @version 1.0.0
 */
public class BlockWindowController {
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
     * @param EXPL_field текстом объяснения в поле для объяснения
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextField EXPL_field;
    /**
     * @param ID_field идентификационным текстом в поле для ID пользователя
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextField ID_field;
    /**
     * @param block_button является кнопкой, при нажатии на которую все ранее записанные ответы идут в базу данных
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Button block_button;
    /**
     * initialize() нужен для внесения ID и ответов пользователя в БД
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    void initialize() {
        /**
         * @param DataBaseHandle является параметром, который позволяет управлять базой данных
         * @throws RuntimeException(e) в случае, если информация в базе данных не изменилась
         * @author bli34
         * @version 1.0.0
         */
        DataBaseHandle db = new DataBaseHandle();
        block_button.setOnAction(event -> {
            try {
                db.changeInf(Integer.parseInt(ID_field.getText()), EXPL_field.getText());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
