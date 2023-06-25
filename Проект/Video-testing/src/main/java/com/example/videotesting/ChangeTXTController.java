package com.example.videotesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ChangeTXTController {
    @FXML
    private Button OpenTextFiles;
    @FXML
    private TextField ChangeTXTName;
    @FXML void TakeFileName(ActionEvent event) throws IOException {
        String FileName = ChangeTXTName.getText();
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.OPEN)) {
                    desktop.open(new File("C:\\Users\\vlado\\Desktop\\Video-testing\\src\\main\\java\\VideoLibrary\\" + FileName + "Вопросы.txt"));
                    desktop.open(new File("C:\\Users\\vlado\\Desktop\\Video-testing\\src\\main\\java\\VideoLibrary\\" + FileName + "Остановки.txt"));
                    desktop.open(new File("C:\\Users\\vlado\\Desktop\\Video-testing\\src\\main\\java\\VideoLibrary\\" + FileName + "Ответы.txt"));
                }
        }
    }
}
