module demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens demo to javafx.fxml;
    opens demo.controller to javafx.fxml;

    exports demo.app;
}
