package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;
/**
 * Класс предназначен для контроля смены видео
 * @author bli34
 * @version 1.0.0
 */
public class VideoChangeController {
    /**
     * @param Amount_of_Video количество видео
     * @author bli34
     * @version 1.0.0
     */
    public int Amount_of_Video = HelloApplication.Amount_of_Video-1;
    /**
     * @param NextButton кнопка переключения на следующее видео
     * @author bli34
     * @version 1.0.0
     */
    @FXML private Button NextButton;
    /**
     * @param BackButton кнопка переключения на предыдущее видео
     * @author bli34
     * @version 1.0.0
     */
    @FXML private Button BackButton;
    /**
     * @param PlayButton кнопка включения видео
     * @author bli34
     * @version 1.0.0
     */
    @FXML private Button PlayButton;
    /**
     * @param Back_to_main_Button кнопка возвращения на главный экран
     * @author bli34
     * @version 1.0.0
     */
    @FXML private Button Back_to_main_Button;
    /**
     * @param event парметр, благодаря которому выполняется метод NextVideo
     * NextVideo() метод, который позволяет перключится на следующее видео
     * @author bli34
     * @version 1.0.0
     */
    @FXML void NextVideo(ActionEvent event){
        if (HelloApplication.ID<Amount_of_Video) {
            HelloApplication.ID = HelloApplication.ID + 1;
        }
        else{
        }
        System.out.println(HelloApplication.ID);
    }
    /**
     * @param event парметр, благодаря которому выполняется метод PreviousVideo
     * PreviousVideo() метод, который позволяет перключится на предыдущее видео
     * @author bli34
     * @version 1.0.0
     */
    @FXML void PreviousVideo(ActionEvent event){
        if (HelloApplication.ID>0) {
            HelloApplication.ID = HelloApplication.ID-1;
        }
        else{
        }
        System.out.println(HelloApplication.ID);
    }
    /**
     * @param event парметр, благодаря которому выполняется метод Back_To_Main
     * Back_To_Main() метод, который позволяет вернутся на главный экран
     * @author bli34
     * @version 1.0.0
     */
    @FXML void Back_To_Main(ActionEvent event){
    }
    /**
     * @param event парметр, благодаря которому выполняется метод PlayVideo
     * PlayVideo() метод, который позволяет начать воспроизведение видео
     * @author bli34
     * @version 1.0.0
     */
    @FXML void PlayVideo(ActionEvent event) {
        HelloApplication.switchToNewWindow("VideoPlayer");

    }
}
