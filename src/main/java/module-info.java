module com.scanner.standalone {
    requires javafx.controls;
    requires javafx.fxml;

    requires de.jensd.fx.glyphs.fontawesome;
    requires json.simple;
    requires rest.assured;
    requires json.path;
    requires com.fasterxml.jackson.databind;
    requires maven.artifact;
    requires com.google.common;

    opens com.scanner.standalone to javafx.fxml;
    exports com.scanner.standalone;
    exports com.scanner.standalone.Controllers;
    opens com.scanner.standalone.Controllers to javafx.fxml;
}