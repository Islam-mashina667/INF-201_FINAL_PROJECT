package com.example.final_proj;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NotifCardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label notifText;

    @FXML
    void initialize() {

    }
    @FXML
    public void setData(Movie movie) {
        notifText.setText("We added a new movie named "+movie.getName()+"!");
    }

}
