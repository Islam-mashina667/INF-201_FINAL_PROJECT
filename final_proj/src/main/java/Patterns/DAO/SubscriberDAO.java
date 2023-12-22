package Patterns.DAO;

import Model.Model_Subscriber;
import Patterns.Singletone.DatebaseConnection;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Objects;

public class SubscriberDAO {
    private JdbcTemplate jdbcTemplate;
    public SubscriberDAO(){
        this.jdbcTemplate = DatebaseConnection.getConnetion();
    }
    public void INSERT(String sb_username){
        jdbcTemplate.update("insert into subscribers(sb_username) values (?)", sb_username);
    }

    public void DELETE(String sb_username){
        jdbcTemplate.update("delete from subscribers where sb_username = '"+sb_username+"'");
    }
    public List<Model_Subscriber> getSubscribers() {
        return jdbcTemplate.query("select * from subscribers", new BeanPropertyRowMapper<>(Model_Subscriber.class));
    }
    public boolean Check(String username){
        List<Model_Subscriber> subscribers = jdbcTemplate.query("select * from subscribers", new BeanPropertyRowMapper<>(Model_Subscriber.class));
        boolean check = false;
        for(Model_Subscriber s : subscribers) {
            if(Objects.equals(s.getSb_username(), username)) {
                check = true;
                break;
            }
        }
        return check;
    }
}

