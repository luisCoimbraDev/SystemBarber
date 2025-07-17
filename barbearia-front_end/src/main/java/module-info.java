open module com.example.barbeariafront_end {
        requires javafx.web;

    requires org.controlsfx.controls;
    requires com.example.barbearia;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires lombok;

        requires spring.context;
        requires spring.boot;
        requires jakarta.annotation;
    requires jakarta.persistence;
        requires spring.beans;
    requires MaterialFX;

    requires javafx.fxml;
    //opens com.example.barbeariafront_end to javafx.fxml;
        //opens com.example.barbeariafront_end.controller to javafx.fxml, spring.core, spring.beans;
    exports com.example.barbeariafront_end;
    exports com.example.barbeariafront_end.controller to spring.beans;
        //opens com.example.barbearia.service to javafx.fxml;


}

