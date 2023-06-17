package com.example.demo2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class MessageToAdminController {

    @FXML
    private TextArea adminRequestText;
    File requestToAdminFile = new File("C:\\Users\\glebv\\Desktop\\Проекты Джава\\Эксперименты\\demo2\\src\\main\\java\\requestsToAdmin\\"+SignInController.loginOfCurrentUser+".txt");
    //файл на почту или здесь, привязать к логину

    @FXML
    void clickShareWithAdminButton(ActionEvent event) throws IOException {
        requestToAdminFile.createNewFile();
        PrintWriter pw = new PrintWriter(requestToAdminFile);
        pw.println(adminRequestText.getText());
        pw.close();
    }

}
