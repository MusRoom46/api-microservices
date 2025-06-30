package fr.formation.controller;

import fr.formation.dto.CommentaireDTO;
import fr.formation.model.Commentaire;
import fr.formation.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireService service;

    @PostMapping
    public Commentaire ajouter(@RequestBody Commentaire c) {
        return service.add(c);
    }

    @GetMapping("/{id}")
    public CommentaireDTO get(@PathVariable Long id) {
        return service.getCommentaireEnrichi(id);
    }

    @PutMapping("/{id}")
    public Commentaire modifier(@PathVariable Long id, @RequestBody Commentaire c) {
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        service.delete(id);
    }
}
