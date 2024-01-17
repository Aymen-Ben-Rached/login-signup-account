package com.example.journey.Controllers;

import com.example.journey.SceneSwitch;
import com.example.journey.Services.ServiceUser;
import com.example.journey.UI.HomeUI;
import com.example.journey.UI.SignUpUI;
import com.example.journey.Utils.DataSource;

import com.example.journey.Utils.UserSession;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class HelloController {
    private Connection connection = DataSource.getInstance().getCon();
    @FXML
    private TextField emailText;

    @FXML
    private Button loginBtn;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button signupBtn;

    @FXML
    void loginBtnOnAction(ActionEvent event) throws IOException {
        if(!emailText.getText().isEmpty() && !passwordText.getText().isEmpty()){
            loginMessageLabel.setText("Trying to login");
            validateLogin();
        }
        else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }
    public void validateLogin() throws IOException {

        ServiceUser serviceUser = new ServiceUser();
        Boolean isLoggedIn = serviceUser.validateLogin(emailText.getText(),passwordText.getText());


        if(isLoggedIn) {

            loginMessageLabel.setText("Welcome");

        }
        else {
            loginMessageLabel.setText("Invalid login");
        }


    }
    @FXML
    void signupBtnOnAction(ActionEvent event) {

    }

}
