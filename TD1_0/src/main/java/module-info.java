module com.example.td1_0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td1_0 to javafx.fxml;
    exports com.example.td1_0;
}