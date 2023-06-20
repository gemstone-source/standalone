module com.scanner.standalone {
    requires javafx.controls;
    requires javafx.fxml;

    requires de.jensd.fx.glyphs.fontawesome;
    requires json.simple;
    requires maven.artifact;
    requires com.google.common;
    //requires org.apache.commons.compress;
    requires java.compiler;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires json.path;
    requires com.sun.jna;
    requires jdk.management;
    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;
//    requires dependency.check.core;
//    requires dependency.check.utils;

    opens com.scanner.standalone to javafx.fxml;
    exports com.scanner.standalone;
    exports com.scanner.standalone.Controllers;
    opens com.scanner.standalone.Controllers to javafx.fxml;
}