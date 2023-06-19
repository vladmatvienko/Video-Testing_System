package com.example.demo2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Класс предназначен для контроля получаемых администратором сообщений от пользователей
 * @author bli34
 * @version 1.0.0
 */
public class MessageToAdminController {
    /**
     * @param adminRequestText текст запроса пользователя админу
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private TextArea adminRequestText;
    /**
     * @param shareWithAdminButton кнопка, позволяющая поделиться сообщением с админ
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    private Button shareWithAdminButton;
    /**
     * @param requestToAdminFile файл с запросом пользователя админу
     * @author bli34
     * @version 1.0.0
     */
    File requestToAdminFile = new File("C:\\Users\\glebv\\Desktop\\Проекты Джава\\Эксперименты\\demo2\\src\\main\\java\\requestsToAdmin\\"+SignInController.loginOfCurrentUser+".txt");
    //файл на почту или здесь, привязать к логину
    /**
     * @param event парметр, благодаря которому выполняется метод clickShareWithAdminButton
     * clickShareWithAdminButton() метод и кнопка, которые позволяют поделиться запросом с админом
     * @throws IOException в случае, когда кнопка clickShareWithAdminButton не срабатывает
     * @author bli34
     * @version 1.0.0
     */
    @FXML
    void clickShareWithAdminButton(ActionEvent event) throws IOException {
        requestToAdminFile.createNewFile();
        PrintWriter pw = new PrintWriter(requestToAdminFile);
        pw.println(adminRequestText.getText());
        pw.close();
    }

}
