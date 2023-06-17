package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.InputStream;
import java.io.IOException;



public class HelloApplication extends Application {
    static String[] VideoName = {"0", "1", "2", "3"};
    static int Amount_of_Video = VideoName.length;
    static int ID = 0;
    static int passwordInputEfforts = 0;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
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