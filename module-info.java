module com.example.futurevaluecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.futurevaluecalculator to javafx.fxml;
    exports com.example.futurevaluecalculator;
}