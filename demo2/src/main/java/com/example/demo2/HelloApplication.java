package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;


public class HelloApplication extends Application {
    static String[] VideoName;
    static int Amount_of_Video;
    static int ID = 0;

    static int passwordInputEfforts = 0;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        String filePath = "C:\\Users\\glebv\\Desktop\\Проекты Джава\\Эксперименты\\demo2\\src\\main\\java\\VideoLibrary\\НазванияВидео.txt";
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
        VideoName = truewords;
        Amount_of_Video = truewords.length+1;
        //Установка иконки приложения
        InputStream iconStream = getClass().getResourceAsStream("1.jpg");
        assert iconStream != null;
        Image image = new Image(iconStream);
          stage.getIcons().add(image);
    }

    public static void main(String[] args)  {
        launch();

    }
    public static void switchToNewWindow(String fxmlFile){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource(fxmlFile+".fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}