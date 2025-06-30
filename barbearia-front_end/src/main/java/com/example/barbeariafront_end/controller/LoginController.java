package com.example.barbeariafront_end.controller;

import java.io.IOException;
import java.net.URI;

import com.example.barbearia.service.UserSystemService;
import io.github.palexdev.materialfx.controls.MFXTextField;
import jakarta.persistence.Entity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginController {

    @Autowired
    private UserSystemService userSystemService;

    @FXML
    private MFXTextField mfxUser;

   @FXML
   private MFXTextField mfxpassword;


    private Stage stage;

    public void Login(ActionEvent event){
        String user = mfxUser.getText().toLowerCase();
        String password = mfxpassword.getText().toLowerCase();

        if(userSystemService.verifyUser(user,password)){
            mfxUser.setText("Usuario validado");
        }else{
            mfxUser.setText("usuario nao validado");
        }

    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void closeProgram(ActionEvent event){
        stage.close();
    }
}
