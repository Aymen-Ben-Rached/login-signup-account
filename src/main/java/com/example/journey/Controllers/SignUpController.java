package com.example.journey.Controllers;

import com.example.journey.Entities.User;
import com.example.journey.Services.ServiceUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class SignUpController {
    private final ServiceUser serviceUser = new ServiceUser();

    @FXML
    private TextField emailText;

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button signupBtn;


    @FXML
    void signupBtnOnAction(ActionEvent event) {
        String firstName,lastName,email,password;
        firstName=firstNameText.getText();
        lastName=lastNameText.getText();
        email=emailText.getText();
        password=passwordText.getText();
        if(firstName.isEmpty()){
            firstNameError.setText("First name is required!");
        }
        if(lastName.isEmpty()){
            lastNameError.setText("Last name is required!");
        }
        if (email.isEmpty()){
            emailError.setText("Email is required!");
        }
        if(password.isEmpty()){
            passwordError.setText("Password is required");
        }
        else {
            User newUser = new User(0, firstName, lastName, email, password);
            try {
                serviceUser.add(newUser);
                welcomeText.setText("Welcome!");
                clearFields();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    private void clearFields() {
        firstNameText.clear();
        lastNameText.clear();
        emailText.clear();
        passwordText.clear();
    }


    /*public void initialize() {
        signupBtn.setDisable(true);
    }*/
    /*public boolean isDisabled(){
        if(passwordText.getText().isEmpty()||(firstNameText.getText().isEmpty()||lastNameText.getText().isEmpty()||emailText.getText().isEmpty())){
            signupBtn.setDisable(true);
            return true;
        }
        else signupBtn.setDisable(false);
        return false;
    }*/
    @FXML
    private Text lastNameError;
    @FXML
    private Text passwordError;
    @FXML
    private Text firstNameError;
    @FXML
    private Text emailError;
    @FXML
    private Text welcomeText;
}

