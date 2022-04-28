module com.example.td22_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td22_1 to javafx.fxml;
    exports com.example.td22_1;
}