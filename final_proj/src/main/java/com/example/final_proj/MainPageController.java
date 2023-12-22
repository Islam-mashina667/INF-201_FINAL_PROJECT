package com.example.final_proj;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Log_out_button;

    @FXML
    private Button book_a_ticket_button;

    @FXML
    private Button drinks_button;

    @FXML
    private Button films_button;

    @FXML
    private Button halls_button;

    @FXML
    private Button profile_button;

    @FXML
    private Button snacks_button;

    @FXML
    private Button vip_tickets_button;

    @FXML
    void initialize() {

    }

    @FXML
    public void logOut(ActionEvent event) throws IOException {
        Scene secondPageScene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignInPage.fxml"))));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(secondPageScene);
        window.show();
    }
    public void openFilmsPage(ActionEvent event) throws IOException {
        Scene secondPageScene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FilmsPage.fxml"))));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(secondPageScene);
        window.show();
    }
    @FXML
    public void openNotificationsPage(ActionEvent event) throws IOException {
        Scene secondPageScene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Notifications.fxml"))));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(secondPageScene);
        window.show();
    }
}
