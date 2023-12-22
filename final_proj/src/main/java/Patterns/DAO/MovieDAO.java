package Patterns.DAO;
import Model.Movie;
import Patterns.Singletone.DatebaseConnection;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Objects;

public class MovieDAO {
    private JdbcTemplate jdbcTemplate;
    public MovieDAO(){
        this.jdbcTemplate = DatebaseConnection.getConnetion();
    }
    public void INSERT(Movie movie){
        jdbcTemplate.update("insert into movies(name) values (?)",
                movie.getName());
    }

    public void DELETE(String name){
        jdbcTemplate.update("delete from movies where name ="+name);
    }
    public boolean Check(Movie movie) {
        List<Movie> movies = jdbcTemplate.query("select * from movies", new BeanPropertyRowMapper<>(Movie.class));
        boolean check = false;
        for(Movie m : movies) {
            if(Objects.equals(m.getName(), movie.getName())) {
                check = true;
                break;
            }
        }
        return check;
    }
}