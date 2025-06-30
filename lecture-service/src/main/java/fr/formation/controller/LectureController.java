package fr.formation.controller;

import fr.formation.model.Lecture;
import fr.formation.service.LectureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lectures")
public class LectureController {
    private final LectureService service;

    public LectureController(LectureService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Lecture getLecture(@PathVariable Long id) {
        return service.getLecture(id).orElse(null);
    }

    @GetMapping
    public List<Lecture> getAllLectures() {
        return service.getAllLectures();
    }

    @GetMapping("/external")
    public String getFromExternal(@RequestParam String url) {
        return service.getFromExternalService(url);
    }
}