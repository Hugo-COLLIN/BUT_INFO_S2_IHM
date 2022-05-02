module com.example.td22_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td22_2 to javafx.fxml;
    exports com.example.td22_2;
}