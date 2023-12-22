package Patterns.DAO;

import Model.Person;
import Patterns.Singletone.DatebaseConnection;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Objects;

public class PersonDAO {
    private JdbcTemplate jdbcTemplate;
    public PersonDAO(){
        this.jdbcTemplate = DatebaseConnection.getConnetion();
    }
    public void INSERT(Person person){
        jdbcTemplate.update("insert into users(username, password, email) values (?, ?, ?)",
                person.getUsername(), person.getPassword(), person.getEmail());
    }

    public void DELETE(int id){
        jdbcTemplate.update("delete from users where id ="+id);
    }
    public boolean SignInCheck(Person person){
        List<Person> persons = jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<>(Person.class));
        boolean check = false;
        for(Person p : persons) {
            if(Objects.equals(p.getUsername(), person.getUsername()) && Objects.equals(p.getPassword(), person.getPassword())) {
                check = true;
                break;
            }
        }
        return check;
    }
}
