package com.example.final_proj;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import Model.Movie;
import Patterns.DAO.MovieDAO;
import Patterns.Facade.MainFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FilmsPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Log_out_button;

    @FXML
    private HBox cardLayout;

    @FXML
    private Button profile_button;

    private List<Movie> films;

    @FXML
    void initialize() throws IOException {
        films = new ArrayList<>(films());
        for (int i = 0; i < films.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("card.fxml"));
            VBox cardBox = fxmlLoader.load();
            CardController cardController = fxmlLoader.getController();
            cardController.setData(films.get(i));
            cardLayout.getChildren().add(cardBox);
        }
    }
    @FXML
    public void back(ActionEvent event) throws IOException {
        Scene secondPageScene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainPage.fxml"))));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(secondPageScene);
        window.show();
    }
    public List<Movie> films() {
        List<Movie> list = new ArrayList<>();

        Movie movie = new Movie();
        movie.setName(" Thor");
        movie.setDescription(" Fantastic film Thor");
        movie.setGenre(" Fantastic genre");
        movie.setImageSrc("/images/thor-un-mundo-oscuro-poster-3.jpg");
        movie.setPrice(1200);
        list.add(movie);

        movie = new Movie();
        movie.setName("Terminator");
        movie.setDescription("Fantastic film Terminator");
        movie.setGenre("Fantastic genre");
        movie.setImageSrc("/images/4f339cd1fd7ccff6fa25391fecd182f2--terminator-poster-terminator-.jpg");
        list.add(movie);

        movie = new Movie();
        movie.setName("Avengers");
        movie.setDescription("Fantastic film Avengers");
        movie.setGenre("Fantastic genre");
        movie.setImageSrc("/images/95538.jpg");
        movie.setPrice(1600);
        list.add(movie);

        movie = new Movie();
        movie.setName("Avengers 2");
        movie.setDescription("Fantastic film Avengers Second Part");
        movie.setGenre("Fantastic genre");
        movie.setImageSrc("/images/3950363.jpg");
        movie.setPrice(1700);
        list.add(movie);

        movie = new Movie();
        movie.setName("Avengers 3");
        movie.setDescription("Fantastic film Avengers Third Part");
        movie.setGenre("Fantastic genre");
        movie.setImageSrc("/images/3214702.jpg");
        movie.setPrice(1900);
        list.add(movie);

        movie = new Movie();
        movie.setName("Martian");
        movie.setDescription("Fantastic film Martian");
        movie.setGenre("Fantastic genre");
        movie.setImageSrc("/images/e24ad7023de5c68f5dbc109b390599c9.jpg");
        movie.setPrice(2100);
        list.add(movie);

        MainFacade mf = new MainFacade();
        list.add(mf.movieAdder("Captain Marvel", "Captain Marvel First Part",
                "Fantastic genre", "/images/4363048.jpg", "1800"));

        return list;
    }
}
