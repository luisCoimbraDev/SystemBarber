package com.example.barbeariafront_end.controller;

import com.example.barbeariafront_end.HelloApplication;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MenuController {

    @FXML
    private MFXButton buttonDash;

    @FXML
    private MFXButton buttonGeren;

    @FXML
    private MFXButton buttonPayment;

    @FXML
    private MFXButton buttonPeople;

    @FXML
    private MFXButton buttonRel;

    @Autowired
    private ConfigurableApplicationContext springContext;

    @FXML
    private BorderPane fundo;

    @FXML
    private AnchorPane telaload;

    @FXML
    private VBox vboxBar;


    private void trocarConteudo(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
            fxmlLoader.setControllerFactory(springContext::getBean);
            Parent tela = fxmlLoader.load();
            //Stage stage = (Stage) telaload.getScene().getWindow();
            //telaload.setMaxHeight(stage.getHeight());
            AnchorPane.setTopAnchor(tela, 0.0);
            AnchorPane.setBottomAnchor(tela, 0.0);
            AnchorPane.setLeftAnchor(tela, 0.0);
            AnchorPane.setRightAnchor(tela, 0.0);
            telaload.getChildren().setAll(tela);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirDashboard() {
        trocarConteudo("Dashboard-view.fxml");
    }

    @FXML
    private void abrirPagamentos() {
        trocarConteudo("Payment-view.fxml");
    }

    @FXML
    private void abrirRelatorios() {
        trocarConteudo("");
    }
}

