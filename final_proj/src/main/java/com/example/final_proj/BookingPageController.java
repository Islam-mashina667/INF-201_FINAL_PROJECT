package com.example.final_proj;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import Model.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BookingPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Log_out_button;

    @FXML
    private Button butTicketButton;

    @FXML
    private Label movieDescription;

    @FXML
    private Label movieGenre;

    @FXML
    private ImageView movieImage;

    @FXML
    private Text movieName;

    @FXML
    private Button profile_button;

    @FXML
    private Label ticketPrice;

    @FXML
    void back(ActionEvent event) throws IOException {
        Scene secondPageScene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainPage.fxml"))));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(secondPageScene);
        window.show();
    }

    @FXML
    void initialize() throws IOException {

    }
    @FXML
    public void setMovieInfo(Movie movie) {
        movieName.setText(movie.getName());
        movieDescription.setText(movie.getDescription());
        movieGenre.setText(movie.getGenre());
        //Image image = new Image(movie.getImageSrc());
        //movieImage.setImage(image);
        ticketPrice.setText(String.valueOf(movie.getPrice())+" tenge");
    }
}
