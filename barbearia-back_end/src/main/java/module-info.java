module com.example.barbearia {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;
    requires spring.data.jpa;
    requires spring.orm;
    //requires java.persistence;
    requires jakarta.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires lombok;

    opens com.example.barbearia.model to org.hibernate.orm.core;

    exports com.example.barbearia;
}
