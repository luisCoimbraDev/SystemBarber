package com.example.barbeariafront_end.controller;

import java.io.IOException;

import com.example.barbearia.service.UserSystemService;
import com.example.barbeariafront_end.HelloApplication;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class LoginController {

    @Autowired
    private UserSystemService userSystemService;

    @Autowired
    private ConfigurableApplicationContext springContext;

    @FXML
    private MFXTextField mfxUser;

   @FXML
   private MFXTextField mfxpassword;

   @FXML
   private TextField warpass;


    private Stage stage;

    public void Login(ActionEvent event) throws IOException{
        String user = mfxUser.getText().toLowerCase();
        String password = mfxpassword.getText().toLowerCase();
        warpass.setText("");



        if(userSystemService.verifyUser(user,password)){
            mfxpassword.setStyle("-fx-border-color: none");
            FXMLLoader fxmlLoader =new FXMLLoader(HelloApplication.class.getResource("Payment-view.fxml"));
            fxmlLoader.setControllerFactory(springContext::getBean);
            Parent root = fxmlLoader.load();
            Stage stage1 = new Stage();
            PaymentController paymentController = fxmlLoader.getController();
            //DashboardController dashboardController = fxmlLoader.getController();
            Scene scene = new Scene(root);
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.setScene(scene);
            closeProgram(null);
            stage1.show();
        }else{
            mfxpassword.setText("");
            mfxpassword.setStyle("-fx-border-color: #f70c20");
            warpass.setText("Usuario ou senha incorretos!");
        }

    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void closeProgram(ActionEvent event){
        stage.close();
    }
}
