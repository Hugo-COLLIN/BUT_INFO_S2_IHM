module com.example.td1_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td1_2 to javafx.fxml;
    exports com.example.td1_2;
}