module com.example.td5_cercle_binding {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td5_cercle_binding to javafx.fxml;
    exports com.example.td5_cercle_binding;
}