package com.example.demo2;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
/**
 * Класс предназначен для контроля смены видео и является наследником класса Initializable
 * @author bli34
 * @version 1.0.0
 */
public class VideoPlayerController implements Initializable {
    /**
     * @param mv показывает видео
     * @author bli34
     * @version 1.0.0
     */
    @FXML private MediaView mv;
    /**
     * @param mp воспроизводит звуковую дорожку
     * @author bli34
     * @version 1.0.0
     */
    @FXML private MediaPlayer mp;
    /**
     * @param me воспроизводит всё вместе
     * @author bli34
     * @version 1.0.0
     */
    @FXML private Media me;
    /**
     * @param url параметр, благодаря которому выполняется метод initialize
     * @param resourceBundle параметр, благодаря которому выполняется метод initialize
     * initialize() метод инициализации ранее упомянутых данных
     * @author bli34
     * @version 1.0.0
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String path = new File("C:\\Users\\glebv\\Desktop\\Проекты Джава\\Эксперименты\\demo2\\src\\main\\java\\VideoLibrary\\"+HelloApplication.ID+".MP4").getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(me);
        mv.setMediaPlayer(mp);
        mp.setAutoPlay(true);
        DoubleProperty width = mv.fitWidthProperty();
        DoubleProperty height = mv.fitHeightProperty();
        width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
    }
}
