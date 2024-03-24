module com.example.cw_java {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cw_java to javafx.fxml;
    exports com.example.cw_java;
}