package com.example.videotesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class VideoChangeController {

    @FXML private Button NextButton;
    @FXML private Button BackButton;
    @FXML private Button PlayButton;
    @FXML private Button Back_to_main_Button;
    @FXML private Button Change;
    @FXML Label VideoName1;

    @FXML void NextVideo(ActionEvent event) throws IOException, InterruptedException {
        if (HelloApplication.ID<HelloApplication.Amount_of_Video-1) {
            HelloApplication.ID = HelloApplication.ID + 1;
        }
        else{
        }
        System.out.println(HelloApplication.ID);
        VideoName1.setText(HelloApplication.VideoName[HelloApplication.ID]);
    }
    @FXML void PreviousVideo(ActionEvent event) throws IOException, InterruptedException {
        if (HelloApplication.ID>0) {
            HelloApplication.ID = HelloApplication.ID-1;
        }
        else{
        }
        System.out.println(HelloApplication.ID);
        VideoName1.setText(HelloApplication.VideoName[HelloApplication.ID]);
    }
    @FXML void Back_To_Main(ActionEvent event){
    }
    static String[] Questions;
    static String[] Answers;
    @FXML void PlayVideo(ActionEvent event) throws FileNotFoundException {
        String a = "Ответы.txt";
        String b = "Вопросы.txt";
        for (int t = 0; t < 2; t++) {
            if (t == 0) {
                String filePath = "C:\\Users\\vlado\\Desktop\\Video-testing\\src\\main\\java\\VideoLibrary\\" + HelloApplication.VideoName[HelloApplication.ID] + a;
                File file = new File(filePath);
                Scanner scanner = new Scanner(file);

                String line = scanner.nextLine();
                String[] words = line.split("");
                int Key1 = 0;
                int i1 = 0;
                while (Key1 < words.length) {
                    if (words[Key1].equals(",")) {
                        i1 = i1 + 1;
                    }
                    Key1 = Key1 + 1;
                }
                String[] truewords = new String[i1 + 1];
                int Key = 0;
                int i = 0;
                String wordy1 = "";
                while (Key < words.length) {
                    if (words[Key].equals(",")) {
                        truewords[i] = wordy1;
                        wordy1 = "";
                        i = i + 1;
                    } else if (Key == words.length - 1) {
                        wordy1 = wordy1 + words[Key];
                        truewords[i] = wordy1;
                    } else {
                        wordy1 = wordy1 + words[Key];
                    }
                    Key = Key + 1;
                }
                Answers = truewords;
            } else {
                String filePath = "C:\\Users\\vlado\\Desktop\\Video-testing\\src\\main\\java\\VideoLibrary\\" + HelloApplication.VideoName[HelloApplication.ID] + b;
                File file = new File(filePath);
                Scanner scanner = new Scanner(file);

                String line = scanner.nextLine();
                String[] words = line.split("");
                int Key1 = 0;
                int i1 = 0;
                while (Key1 < words.length) {
                    if (words[Key1].equals(",")) {
                        i1 = i1 + 1;
                    }
                    Key1 = Key1 + 1;
                }
                String[] truewords = new String[i1 + 1];
                int Key = 0;
                int i = 0;
                String wordy1 = "";
                while (Key < words.length) {
                    if (words[Key].equals(",")) {
                        truewords[i] = wordy1;
                        wordy1 = "";
                        i = i + 1;
                    } else if (Key == words.length - 1) {
                        wordy1 = wordy1 + words[Key];
                        truewords[i] = wordy1;
                    } else {
                        wordy1 = wordy1 + words[Key];
                    }
                    Key = Key + 1;
                }
                Questions = truewords;
            }
        }
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
        stage.show();

    }
}
