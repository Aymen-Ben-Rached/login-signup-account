package com.example.journey.Controllers;

import com.example.journey.Entities.User;
import com.example.journey.Services.ServiceUser;
import com.example.journey.Utils.DataSource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;

public class HomeController {
    private Connection connection = DataSource.getInstance().getCon();
    ServiceUser serviceUser = new ServiceUser();
    @FXML
    private Button compteBtn;

    @FXML
    private Button emailBtn;

    @FXML
    private TextField emailText;

    @FXML
    private Button firstNameBtn;

    @FXML
    private TextField firstNameText;

    @FXML
    private Button journauxBtn;

    @FXML
    private Button lastNameBtn;

    @FXML
    private TextField lastNameText;

    @FXML
    private Button offresBtn;

    @FXML
    private Button passwordBtn;
    @FXML
    private Label messageLabel;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button reclamationsBtn;

    @FXML
    private Button reservationsBtn;

    @FXML
    void emailEdit(ActionEvent event) {
        if(!emailText.getText().isEmpty()&&!firstNameText.getText().isEmpty()&&!lastNameText.getText().isEmpty()&&!passwordText.getText().isEmpty()){
            String firstName,lastName,email,password;
            firstName=firstNameText.getText();
            lastName=lastNameText.getText();
            email=emailText.getText();
            password=passwordText.getText();


            User newUser=new User(0,firstName,lastName,email,password);
            try{
                serviceUser.update(newUser);
                messageLabel.setText("Succes");
            }
            catch (SQLException ex){
                System.out.println(ex);
            }

        }
        else {
            messageLabel.setText("Champs vides!");
        }
    }



}
