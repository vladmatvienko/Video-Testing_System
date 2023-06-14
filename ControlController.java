package com.example.adm_it;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControlController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Access_button;

    @FXML
    private Button Block_button;

    @FXML
    private Button Role_button;

    @FXML
    void initialize() {
Block_button.setOnAction(event -> {
    //Block_button.getScene().getWindow().hide();

    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Block_window.fxml"));
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
Role_button.setOnAction(event -> {
            //Block_button.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Role_window.fxml"));
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


    }

}
