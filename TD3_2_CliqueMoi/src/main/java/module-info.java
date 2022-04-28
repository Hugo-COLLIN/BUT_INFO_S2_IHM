module com.example.td3_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td3_2 to javafx.fxml;
    exports com.example.td3_2;
}