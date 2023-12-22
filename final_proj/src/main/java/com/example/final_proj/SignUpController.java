package com.example.final_proj;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import Model.Person;
import Patterns.DAO.PersonDAO;
import animations.Shake;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button goBack_button;

    @FXML
    private TextField email_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button register_button;

    @FXML
    private TextField username_field;



    @FXML
    void initialize() {
        register_button.setOnAction(actionEvent -> {
            PersonDAO pd = new PersonDAO();
            Person person = new Person();
            person.setUsername(username_field.getText());
            person.setPassword(password_field.getText());
            person.setEmail(email_field.getText());
            if(pd.SignInCheck(person)){
                Shake usernameAnim = new Shake(username_field);
                Shake passwordAnim = new Shake(password_field);
                Shake emailAnim = new Shake(email_field);
                usernameAnim.playAnim();
                passwordAnim.playAnim();
                emailAnim.playAnim();
            }
            else pd.INSERT(person);
        });
    }
    @FXML
    public void toSignInPage(ActionEvent event) throws IOException {
        Scene secondPageScene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignInPage.fxml"))));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(secondPageScene);
        window.show();
    }
}
