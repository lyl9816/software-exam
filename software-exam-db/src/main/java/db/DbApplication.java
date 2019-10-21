package db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "db")
public class DbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class, args);
    }

}