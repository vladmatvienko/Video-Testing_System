package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.IOException;
/**
 * Класс, который запускает приложение и является наследником Application
 * @author bli34
 * @version 1.0.0
 */
public class HelloApplication extends Application {
    /**
     * @param VideoName даёт имена видеофайлам
     * @author bli34
     * @version 1.0.0
     */
    static String[] VideoName = {"0", "1", "2", "3"};
    /**
     * @param Amount_of_Video выдаёт количество количество видео
     * @author bli34
     * @version 1.0.0
     */
    static int Amount_of_Video = VideoName.length;
    /**
     * @param ID даёт ID пользователю
     * @author bli34
     * @version 1.0.0
     */
    static int ID = 0;
    /**
     * @param passwordInputEfforts определяет количество попыток ввода пароля
     * @author bli34
     * @version 1.0.0
     */
    static int passwordInputEfforts = 0;
    /**
     * @param stage нужен для выполнения метода
     * start() метод запуска программы
     * @throws IOException в случае, если программа не смогла запуститься
     * @author bli34
     * @version 1.0.0
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        //Установка иконки приложения
        InputStream iconStream = getClass().getResourceAsStream("1.jpg");
          Image image = new Image(iconStream);
          stage.getIcons().add(image);
    }
    /**
     * @param args создаёт массив для выполнения метода main
     * main() метод исполнения launch
     * launch() метод запуска видео
     * @author bli34
     * @version 1.0.0
     */
    public static void main(String[] args)  {
        launch();

    }
    /**
     * @param fxmlFile создаёт файл FXML, благодаря которому можно переключаться к следующему окну
     * switchToNewWindow() метод переключения от одного окна к другому
     * @author bli34
     * @version 1.0.0
     */
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