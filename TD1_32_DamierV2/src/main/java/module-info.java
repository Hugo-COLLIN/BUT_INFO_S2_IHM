module com.example.td1_3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.td1_3 to javafx.fxml;
    exports com.example.td1_3;
}