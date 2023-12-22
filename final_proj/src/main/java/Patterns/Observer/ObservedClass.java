package Patterns.Observer;

import Model.Movie;
import Patterns.DAO.SubscriberDAO;
import animations.Shake;
import com.example.final_proj.NotifCardController;
import com.example.final_proj.NotificationsPageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ObservedClass implements Observed {
    @Override
    public void addObserver(String sb_username, Button subscribe_button) {
        SubscriberDAO sd = new SubscriberDAO();
        if(!sd.Check(sb_username)){
            sd.INSERT(sb_username);
        }
        else{
            Shake usernameAnim = new Shake(subscribe_button);
            usernameAnim.playAnim();
        }
    }

    @Override
    public void removeObserver(String sb_username, Button unsubscribe_button) {
        SubscriberDAO sd = new SubscriberDAO();
        if(sd.Check(sb_username)) {
            sd.DELETE(sb_username);
        }
        else {
            Shake usernameAnim = new Shake(unsubscribe_button);
            usernameAnim.playAnim();
        }
    }

    @Override
    public void notifyObservers(Movie movie) throws IOException {

    }
}
