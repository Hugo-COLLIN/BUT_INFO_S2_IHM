module com.example.td4_mvc_grille {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td4_mvc_grille to javafx.fxml;
    exports com.example.td4_mvc_grille;
}