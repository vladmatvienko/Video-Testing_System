module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires javafx.media;
    requires java.desktop;


    opens com.example.demo2 to javafx.fxml;
    exports com.example.demo2;
}