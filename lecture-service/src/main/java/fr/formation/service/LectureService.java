package fr.formation.service;

import fr.formation.model.Lecture;
import fr.formation.repository.LectureRepository;
import org.springframework.stereotype.Service;

import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import java.util.*;

@Service
public class LectureService {
    private final LectureRepository repository;
    private final HttpClient httpClient;

    public LectureService(LectureRepository repository) {
        this.repository = repository;
        this.httpClient = HttpClient.newHttpClient();
    }

    public Optional<Lecture> getLecture(Long id) {
        return repository.findById(id);
    }

    public List<Lecture> getAllLectures() {
        return repository.findAll();
    }

    public String getFromExternalService(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                return response.body();
            } else {
                return "Erreur : Code de statut HTTP " + response.statusCode();
            }
        } catch (IOException | InterruptedException e) {
            return "Erreur lors de la requête : " + e.getMessage();
        } catch (IllegalArgumentException e) {
            return "URL invalide : " + e.getMessage();
        }
    }
}