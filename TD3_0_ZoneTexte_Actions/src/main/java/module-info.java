module com.example.tp3_0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tp3_0 to javafx.fxml;
    exports com.example.tp3_0;
}