module com.example.td2_11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td2_11 to javafx.fxml;
    exports com.example.td2_11;
}