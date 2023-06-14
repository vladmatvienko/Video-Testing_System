package com.example.adm_it;

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

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Control_button;

    @FXML
    private Button Personal_cab_button;

    @FXML
    private TextArea Text_area;

    @FXML
    private Button Video_base_button;

    @FXML
    void initialize() {
        //DataBaseHandle dataBase = new DataBaseHandle();
        //DataBase_2 db = new DataBase_2();
        //SignUpButton.setOnAction(event -> {
        //dataBase.SignUpUser(NameField.getText());
        Control_button.setOnAction(event -> {
            Control_button.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Control.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        Personal_cab_button.setOnAction(event -> {
            try {
                DataBaseHandle.GetPersonalInformation();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


    }


}
