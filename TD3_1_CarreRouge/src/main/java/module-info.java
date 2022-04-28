module com.example.td3_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td3_1 to javafx.fxml;
    exports com.example.td3_1;
}