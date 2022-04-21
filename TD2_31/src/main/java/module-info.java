module com.example.td31 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td31 to javafx.fxml;
    exports com.example.td31;
}