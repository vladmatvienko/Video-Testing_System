import java.sql.Connection;

public class PersonalCabinet extends com.example.demo2.DataBaseHandle {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> listView;

    @FXML private Label label1;
    @FXML private Label label2;
    @FXML private Label label3;
    @FXML private Label label4;
    @FXML private Label label5;
    @FXML private Label label6;
    @FXML private Label label7;
    @FXML private Label label8;
    @FXML

    public void initialize() {
        Connection dbConnection;
        label1.setText(USER_NAME);
        label2.setText(USER_SURNAME);
        label3.setText(USER_LOGIN);
        label4.setText(USER_PASSWORD);
        label5.setText(USER_BIRTHDATE);
        label6.setText(USER_PHONENUMBER);
        label7.setText(USER_EMAIL);
        label8.setText(USER_SECRETQUESTION);
    }
}