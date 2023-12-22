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

public class SignInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button register_button;

    @FXML
    private Button signIn_button;

    @FXML
    private TextField username_field;

    public static String username;

    @FXML
    void initialize() {
        signIn_button.setOnAction(actionEvent -> {
            PersonDAO pd = new PersonDAO();
            Person person = new Person();
            person.setUsername(username_field.getText());
            person.setPassword(password_field.getText());
            if(pd.SignInCheck(person)){
                Scene mainPageScene = null;
                try {
                    mainPageScene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainPage.fxml"))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                username = username_field.getText().toLowerCase();
                Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                window.setScene(mainPageScene);
                window.show();
            }
            else {
                Shake usernameAnim = new Shake(username_field);
                Shake passwordAnim = new Shake(password_field);
                usernameAnim.playAnim();
                passwordAnim.playAnim();
            }
        });
    }

    @FXML
    public void toSignUpPage(ActionEvent event) throws IOException {
        Scene secondPageScene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUpPage.fxml"))));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(secondPageScene);
        window.show();
    }

    @FXML
    public void toMainPage(ActionEvent event) throws IOException {
        Scene mainPageScene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainPage.fxml"))));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainPageScene);
        window.show();
    }
}
