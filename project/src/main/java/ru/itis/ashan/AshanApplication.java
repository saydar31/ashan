package ru.itis.ashan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itis.ashan.bl.repositories.UserRepository;

@SpringBootApplication
public class AshanApplication {


    public static void main(String[] args) {
        SpringApplication.run(AshanApplication.class, args);
    }

}
