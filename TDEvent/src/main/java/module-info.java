module com.example.tdevent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tdevent to javafx.fxml;
    exports com.example.tdevent;
}