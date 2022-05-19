module com.example.td42_1_fxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.td42_1_fxml to javafx.fxml;
    exports com.example.td42_1_fxml;
}