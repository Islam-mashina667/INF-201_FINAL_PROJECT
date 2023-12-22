package Patterns.Facade;

import Model.Movie;
import com.example.final_proj.BookingPageController;
import com.example.final_proj.CardController;

public class MainFacade {
    CardController cc = new CardController();
    BookingPageController bc = new BookingPageController();
    public void toBookingPageWithInfo() {
        bc.setMovieInfo(cc.getStaticMovie());
    }
    public Movie movieAdder(String name, String description, String genre, String imageSrc, String price) {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setDescription(description);
        movie.setGenre(genre);
        movie.setImageSrc(imageSrc);
        movie.setPrice(Integer.parseInt(price));
        return movie;
    }
}
