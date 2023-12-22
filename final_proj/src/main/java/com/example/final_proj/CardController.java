package com.example.final_proj;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import Model.Movie;
import Patterns.Facade.MainFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label description;

    @FXML
    private Label genre;

    @FXML
    private Label name;

    @FXML
    private ImageView movieImage;

    @FXML
    private Button toBookingButton;

    @FXML
    void initialize() {

    }
    Movie staticMovie;
    @FXML
    public void setData(Movie movie) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(movie.getImageSrc())));
        movieImage.setImage(image);
        name.setText(movie.getName());
        description.setText(movie.getDescription());
        genre.setText(movie.getGenre());
        staticMovie = new Movie(movie.getName(), movie.getDescription(), movie.getGenre(), movie.getImageSrc(), movie.getPrice());
    }
    @FXML
    public Movie getStaticMovie() { return this.staticMovie; }
    @FXML
    public void toBookingPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BookingPage.fxml"));
        Parent bookingPage = loader.load();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        BookingPageController controller = loader.getController();
        controller.setMovieInfo(staticMovie);
        Scene bookingScene = new Scene(bookingPage);
        window.setScene(bookingScene);
        window.show();
        MainFacade mf = new MainFacade();
        mf.toBookingPageWithInfo();
    }
}
