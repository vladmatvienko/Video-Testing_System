package com.example.videotesting;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class QuestionController implements Initializable {
    static int Num = 0;
    @FXML
    private Button Answer;
    @FXML
    private TextField Otvet;
    @FXML
    private Label Vopros;

    static int AmountOfRightAnswers = 0;
    @FXML
    public void ToAnswer(ActionEvent event) {
        if (Num<VideoChangeControllerAdmin.Questions.length) {
            String ttt = Otvet.getText();
            if (VideoChangeControllerAdmin.Answers[Num].equals(ttt)) {
                AmountOfRightAnswers = AmountOfRightAnswers + 1;
                System.out.println(AmountOfRightAnswers + "/" + VideoChangeControllerAdmin.Questions.length);
            } else {
                System.out.println(AmountOfRightAnswers + "/" + VideoChangeControllerAdmin.Questions.length);
            }
        }
        Stage stage = (Stage) Answer.getScene().getWindow();
        stage.close();
        Num = Num+1;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Num<VideoChangeControllerAdmin.Questions.length) {
            Vopros.setText(VideoChangeControllerAdmin.Questions[Num]);
        }
    }
}
