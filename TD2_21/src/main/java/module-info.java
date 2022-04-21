module com.example.td2_21 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td2_21 to javafx.fxml;
    exports com.example.td2_21;
}