module com.example.td4_1_grillemvc_frommodele {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td4_1_grillemvc_frommodele to javafx.fxml;
    exports com.example.td4_1_grillemvc_frommodele;
}