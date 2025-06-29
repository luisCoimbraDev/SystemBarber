    module com.example.barbeariafront_end {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.example.barbearia;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires lombok;
        requires spring.webmvc;
        requires spring.context;
        requires spring.boot;
        requires jakarta.annotation;
        opens com.example.barbeariafront_end to javafx.fxml;
    opens com.example.barbeariafront_end.controller to javafx.fxml, spring.core;
    exports com.example.barbeariafront_end;
    exports com.example.barbeariafront_end.controller to spring.beans;
}