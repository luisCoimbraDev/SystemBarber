package com.example.barbeariafront_end.controller;

import com.example.barbearia.service.BarbeiroService;
import com.example.barbearia.service.ProdutoService;
import com.example.barbearia.service.ServicoService;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckListView;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class PaymentController implements Initializable {

    private ConfigurableApplicationContext springContext;

    @FXML
    private MFXComboBox<String> barberResponse;

    @FXML
    private MFXButton buttonDash;

    @FXML
    private MFXButton buttonDiferir;

    @FXML
    private MFXButton buttonGeren;

    @FXML
    private MFXButton buttonPayment;

    @FXML
    private MFXButton buttonPeople;

    @FXML
    private MFXButton buttonRel;

    @FXML
    private MFXCheckListView<String> checklistProducts;

    @FXML
    private MFXCheckListView<String> checklistService;

    @FXML
    private BorderPane fundo;

    @FXML
    private MFXButton gerarpayment;

    @FXML
    private MFXComboBox<String> metodopayment;

    @FXML
    private TextField totalprice;

    @FXML
    private VBox vboxBar;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private BarbeiroService barbeiroService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checklistService.getItems().addAll(servicoService.getServicos().stream()
                .map(p -> p.getDescService())
               .toList());
        checklistProducts.getItems().addAll(produtoService.getProdutos().stream()
                .map(p-> p.getProductName())
                .toList());
        ObservableList<String> barbeiros = FXCollections.observableList(barbeiroService.getBarbeiros().stream()
                .map(barbeiro -> barbeiro.getNameBarber())
                .toList());
        barberResponse.setItems(barbeiros);

        ObservableList<String> methodPayment = FXCollections.observableArrayList(
                "Pix",
                "Dinheiro",
                "Cartão de credito",
                "Cartao de Debito",
                "Fiado"
        );

        metodopayment.setItems(methodPayment);



    };

}

