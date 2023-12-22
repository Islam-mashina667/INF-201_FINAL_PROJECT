package Patterns.Observer;

import Model.Movie;
import javafx.scene.control.Button;

import java.io.IOException;

public interface Observed {
    void addObserver(String sb_username, Button subscribe_button);
    void removeObserver(String sb_username, Button unsubscribe_button);
    void notifyObservers(Movie movie) throws IOException;
}
