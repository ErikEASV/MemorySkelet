module com.example.memoryskelet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.memoryskelet to javafx.fxml;
    exports com.example.memoryskelet;
}