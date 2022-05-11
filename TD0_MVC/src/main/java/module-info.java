module com.example.td0_mvc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td0_mvc to javafx.fxml;
    exports com.example.td0_mvc;
}