package com.example.demo2;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoPlayerController implements Initializable {
    @FXML private MediaView mv;
    @FXML private MediaPlayer mp;
    @FXML private Media me;
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
