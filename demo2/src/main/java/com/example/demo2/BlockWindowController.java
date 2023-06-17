package com.example.demo2;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BlockWindowController {
    @FXML
    private TextField EXPL_field;

    @FXML
    private TextField ID_field;

    @FXML
    private Button block_button;

    @FXML
    void initialize() {
        DataBaseHandle db = new DataBaseHandle();
        block_button.setOnAction(event -> {
            try {
                db.changeInf(Integer.parseInt(ID_field.getText()), EXPL_field.getText());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
