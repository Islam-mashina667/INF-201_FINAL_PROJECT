package Patterns.Singletone;
import org.springframework.jdbc.core.JdbcTemplate;import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import java.util.Objects;
public class DatebaseConnection {
    private static JdbcTemplate connection;
    public static synchronized JdbcTemplate getConnetion(){
        if(connection == null){
        connection = jdbcTemplate();
        }
        return connection;
    }
    private static DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/final_proj");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        return dataSource;
    }
    private static JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}