module com.example.td2_51 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td2_51 to javafx.fxml;
    exports com.example.td2_51;
}