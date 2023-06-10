package com.example.videotesting;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VideoChange.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }
    static String[] VideoName = {"0", "1", "2", "3"};
    static int Amount_of_Video = VideoName.length;
    static int ID = 0;
    public static void main(String[] args) {
        launch();
    }
}