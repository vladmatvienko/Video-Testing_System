package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
public class VideoChangeController {
    public int Amount_of_Video = HelloApplication.Amount_of_Video-1;



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
        HelloApplication.switchToNewWindow("VideoPlayer");

    }
}
