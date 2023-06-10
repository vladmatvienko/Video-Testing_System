module com.example.videotesting {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.videotesting to javafx.fxml;
    exports com.example.videotesting;
}