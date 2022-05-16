module com.example.td4_serpent_mvc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td4_serpent_mvc to javafx.fxml;
    exports com.example.td4_serpent_mvc;
}