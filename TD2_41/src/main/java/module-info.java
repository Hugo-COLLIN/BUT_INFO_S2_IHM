module com.example.td1_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td1_1 to javafx.fxml;
    exports com.example.td1_1;
}