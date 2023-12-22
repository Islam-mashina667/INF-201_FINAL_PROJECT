package com.example.final_proj;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import Model.Movie;
import Patterns.DAO.SubscriberDAO;
import Patterns.Observer.Observed;
import Patterns.Observer.ObservedClass;
import Patterns.Observer.Observer;
import animations.Shake;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotificationsPageController {

    @FXML
    private Button back_button;

    @FXML
    private VBox notificationsCardLayout;

    @FXML
    private Button profile_button;

    @FXML
    private Button subscribe_button;

    @FXML
    private Button unsubscribe_button;
    public String sb_username;


    @FXML
    void back(ActionEvent event) throws IOException {
        Scene secondPageScene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainPage.fxml"))));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(secondPageScene);
        window.show();
    }
    Observed subscriber = new ObservedClass();
    @FXML
    public void Subscribe(ActionEvent event) throws IOException {
        subscriber.addObserver(sb_username, subscribe_button);
    }
    @FXML
    public void UnSubscribe(ActionEvent event) throws IOException {
        subscriber.removeObserver(sb_username, unsubscribe_button);
    }

    @FXML
    void initialize() throws IOException {
        sb_username = SignInController.username.toLowerCase();
        showNotify(sb_username);
    }
    @FXML
    public void showNotify(String sb_username) throws IOException {
        SubscriberDAO sd = new SubscriberDAO();
        if(sd.Check(sb_username)) {
            FilmsPageController fc = new FilmsPageController();
            List<Movie> list = new ArrayList<>(fc.films());
            for (int i = 0; i < list.size(); i++) {
                setNotification(list.get(i));
            }
        }
    }

    @FXML
    public void setNotification(Movie movie) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("NotifCard.fxml"));
        VBox cardBox = fxmlLoader.load();
        NotifCardController notifCardController = fxmlLoader.getController();
        notifCardController.setData(movie);
        notificationsCardLayout.getChildren().add(cardBox);
    }
}
