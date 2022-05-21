module com.example.hanabi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hanabi to javafx.fxml;
    exports com.example.hanabi;
}