package com.example.adm_it;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BlockController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField EXPL_field;

    @FXML
    private TextField ID_field;

    @FXML
    private Button block_button;

    @FXML
    void initialize() {
        block_button.setOnAction(event -> {
            DataBaseHandle.changeInf(Integer.parseInt(ID_field.getText()), EXPL_field.getText());
        });
    }

}
