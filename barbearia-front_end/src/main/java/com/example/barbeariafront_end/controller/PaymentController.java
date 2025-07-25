package com.example.barbeariafront_end.controller;

import com.example.barbearia.model.Produto;
import com.example.barbearia.service.BarbeiroService;
import com.example.barbearia.service.ProdutoService;
import com.example.barbearia.service.ServicoService;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.MFXCheckListView;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


    Map<String, BooleanProperty> estadosServicos = new HashMap<>();

    @Autowired
    private BarbeiroService barbeiroService;

    @FXML
    private ListView<String> listService;



    Map<String, BooleanProperty> estadosProducts = new HashMap<>();

    @FXML
    private ListView<String> listProducts;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        barberResponse.setItems(FXCollections.observableList(barbeiroService.getBarbeiros().stream()
                .map(barbeiro -> barbeiro.getNameBarber())
                .toList()));

        ObservableList<String> methodPayment = FXCollections.observableArrayList(
                "Pix",
                "Dinheiro",
                "Cartão de credito",
                "Cartao de Debito",
                "Fiado"
        );

        metodopayment.setItems(methodPayment);

        ObservableList<String> servicos = FXCollections.observableList(servicoService.getServicos().stream().map(s -> String.format("%-20s R$%.2f", s.getDescService(),s.getValueService())).toList());
        ObservableList<String> produtos = FXCollections.observableList(produtoService.getProdutos().stream().map(s-> String.format("%-20s R$%.2f", s.getProductName(), s.getPriceProduct())).toList());
        produtos.forEach(item->{
            BooleanProperty property = new SimpleBooleanProperty(false);
            property.addListener((obs, o, n) -> setTotalprice());
            estadosProducts.put(item, property);
        });
        servicos.forEach(item -> {
            BooleanProperty property = new SimpleBooleanProperty(false);
            property.addListener((obs, o, n) ->setTotalprice());
            estadosServicos.put(item, property);

        });
        listProducts.setItems(produtos);
        listProducts.setCellFactory(CheckBoxListCell.forListView(item->estadosProducts.get(item)));
        listProducts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listService.setItems(servicos);
        listService.setCellFactory(CheckBoxListCell.forListView(item -> estadosServicos.get(item)));
        listService.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    };





    public void setTotalprice(){

        List<String> servicos = estadosServicos.entrySet().stream()
                .filter(e->e.getValue().get())
                .map(e-> e.getKey().split("R\\$")[0].trim()).toList();

        List<String> produtos = estadosProducts.entrySet().stream()
                .filter(e->e.getValue().get())
                .map(e->e.getKey().split("R\\$")[0].trim()).toList();

        double total = servicoService.getPriceServicos(servicos) + produtoService.getValorProdutos(produtos);

        totalprice.setText("R$ "+ String.valueOf(total));

    }


    public void gerarpayment(){


    }

}

