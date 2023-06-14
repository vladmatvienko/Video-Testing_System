package com.example.adm_it;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RoleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ID_field;

    @FXML
    private Button analytic_button;

    @FXML
    private Button user_button;

    @FXML
    void initialize() {
user_button.setOnAction(event -> {
    DataBaseHandle.RoleInfUser(Integer.parseInt(ID_field.getText()));
});
analytic_button.setOnAction(event -> {
    DataBaseHandle.RoleInfAnalytic(Integer.parseInt(ID_field.getText()));
});

    }

}
