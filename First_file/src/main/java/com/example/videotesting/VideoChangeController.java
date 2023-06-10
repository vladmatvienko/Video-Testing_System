package com.example.videotesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;


public class VideoChangeController {
    public int Amount_of_Video = HelloApplication.Amount_of_Video-1;

    @FXML private Button NextButton;
    @FXML private Button BackButton;
    @FXML private Button PlayButton;
    @FXML private Button Back_to_main_Button;

    @FXML void NextVideo(ActionEvent event){
        if (HelloApplication.ID<Amount_of_Video) {
            HelloApplication.ID = HelloApplication.ID + 1;
        }
        else{
        }
        System.out.println(HelloApplication.ID);
    }
    @FXML void PreviousVideo(ActionEvent event){
        if (HelloApplication.ID>0) {
            HelloApplication.ID = HelloApplication.ID-1;
        }
        else{
        }
        System.out.println(HelloApplication.ID);
    }
    @FXML void Back_To_Main(ActionEvent event){
    }
    @FXML void PlayVideo(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("VideoPlayer.fxml"));
        try
        {
            loader.load();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }
}
