package com.example.videotesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VideoPlayerController implements Initializable {
    @FXML
    private MediaView mv;
    @FXML
    private Button PlayButton;
    private Button QuestionButton;
    @FXML
    private MediaPlayer mp;
    @FXML
    private Media me;
    static int pass1 = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String path = new File("C:\\Users\\vlado\\Desktop\\Video-testing\\src\\main\\java\\VideoLibrary\\" + HelloApplication.VideoName[HelloApplication.ID] + ".MP4").getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(me);
        mv.setMediaPlayer(mp);
        mp.play();
        DoubleProperty width = mv.fitWidthProperty();
        DoubleProperty height = mv.fitHeightProperty();
        width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
        String filePath = "C:\\Users\\vlado\\Desktop\\Video-testing\\src\\main\\java\\VideoLibrary\\" + HelloApplication.VideoName[HelloApplication.ID] + "Остановки.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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
        Integer[] numbers = new Integer[truewords.length];
        for (int pass = 0; pass < truewords.length; pass++) {
            try
            {
                numbers[pass] = Integer.parseInt(truewords[pass]);
            }
            catch (NumberFormatException nfe)
            {
                numbers[pass] = null;
            }
        }
        numbers1 = numbers;
        mp.setStopTime(Duration.seconds(numbers[pass1]));
    }
      static Integer[]  numbers1;
    public void PlayQuestion (ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Question.fxml"));
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
    public void PlayVideo (ActionEvent event){
        mp.play();
        mp.seek(Duration.seconds(numbers1[pass1]));
        if (pass1<numbers1.length-1){
            pass1 = pass1 + 1;
            mp.setStopTime(Duration.seconds(numbers1[pass1]));
        }
        else{
           PlayButton.setVisible(false);
            numbers1= new Integer[]{};
            pass1 = 0;
            QuestionController.AmountOfRightAnswers = 0;

        }
        mp.play();
    }

}
