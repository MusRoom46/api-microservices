package fr.formation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CommentaireService {
    public static void main(String[] args) {
        SpringApplication.run(CommentaireService.class, args);
    }
}