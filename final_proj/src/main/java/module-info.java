module com.example.final_proj {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires spring.jdbc;


    opens com.example.final_proj to javafx.fxml;
    exports com.example.final_proj;
    exports Model;
}