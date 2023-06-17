package com.example.demo2;
import javafx.fxml.FXML;
public class HelloController {
    @FXML
    protected void onHelloButtonClick() {
       HelloApplication.switchToNewWindow("SignIn");
    }
}