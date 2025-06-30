package fr.formation.service;

import fr.formation.dto.CommentaireDTO;
import fr.formation.dto.ProduitDTO;
import fr.formation.model.Produit;
import fr.formation.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public List<Produit> getAll() {
        return produitRepository.findAll();
    }

    public Produit getById(Long id) {
        return produitRepository.findById(id).orElseThrow();
    }

    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit update(Long id, Produit p) {
        Produit produit = getById(id);
        produit.setNom(p.getNom());
        produit.setPrix(p.getPrix());
        produit.setNotable(p.isNotable());
        return produitRepository.save(produit);
    }

    public void delete(Long id) {
        produitRepository.deleteById(id);
    }

    @Autowired
    private RestTemplate restTemplate;

    public List<CommentaireDTO> getCommentaires(Long produitId) {
        String url = "http://localhost:8082/commentaires/produit/" + produitId;
        CommentaireDTO[] commentaires = restTemplate.getForObject(url, CommentaireDTO[].class);
        return Arrays.asList(Optional.ofNullable(commentaires).orElse(new CommentaireDTO[0]));
    }

    public double getNoteMoyenne(Long produitId) {
        List<CommentaireDTO> commentaires = getCommentaires(produitId);
        return commentaires.stream()
                .mapToInt(CommentaireDTO::getNote)
                .average()
                .orElse(0.0);
    }

    public ProduitDTO getProduitComplet(Long id) {
        Produit produit = getById(id);

        // Appel au commentaire-service
        String url = "http://localhost:8082/commentaires/produit/" + id;
        CommentaireDTO[] tab = restTemplate.getForObject(url, CommentaireDTO[].class);
        List<CommentaireDTO> commentaires = Arrays.asList(Optional.ofNullable(tab).orElse(new CommentaireDTO[0]));

        double moyenne = commentaires.stream()
                .mapToInt(CommentaireDTO::getNote)
                .average()
                .orElse(0.0);

        // Composition de la réponse
        ProduitDTO dto = new ProduitDTO();
        dto.setId(produit.getId());
        dto.setNom(produit.getNom());
        dto.setPrix(produit.getPrix());
        dto.setNotable(produit.isNotable());
        dto.setNoteMoyenne(moyenne);
        dto.setCommentaires(commentaires);

        return dto;
    }

}
