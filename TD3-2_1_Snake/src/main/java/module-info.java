module com.example.td32_1_snake {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td32_1_snake to javafx.fxml;
    exports com.example.td32_1_snake;
}