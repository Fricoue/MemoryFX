module com.example.memoire {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.memoire to javafx.fxml;
    exports com.example.memoire;
}