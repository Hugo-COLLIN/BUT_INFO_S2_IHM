module com.example.td1_3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td1_3 to javafx.fxml;
    exports com.example.td1_3;
}