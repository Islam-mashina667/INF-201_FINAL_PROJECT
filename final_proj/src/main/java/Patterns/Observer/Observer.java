package Patterns.Observer;

import javafx.scene.layout.VBox;

import java.io.IOException;

public interface Observer {
    void handleEvent(String sb_username) throws IOException;
}
