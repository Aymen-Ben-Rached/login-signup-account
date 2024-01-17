module com.example.journey {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.journey to javafx.fxml;
    exports com.example.journey;
    exports com.example.journey.Controllers;
    opens com.example.journey.Controllers to javafx.fxml;
    exports com.example.journey.UI;
    opens com.example.journey.UI to javafx.fxml;
}