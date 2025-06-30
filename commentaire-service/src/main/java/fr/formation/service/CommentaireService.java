package fr.formation.service;

import fr.formation.dto.CommentaireDTO;
import fr.formation.dto.ProduitDTO;
import fr.formation.model.Commentaire;
import fr.formation.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public Commentaire add(Commentaire c) {
        if (!isProduitNotable(c.getProduitId())) {
            throw new RuntimeException("Le produit n'est pas notable");
        }

        // Validation des sous-notes
        validateNotes(c);

        // Calcul automatique de la note
        c.setNote(calculateNote(c));
        return repository.save(c);
    }

    public Optional<Commentaire> get(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Commentaire update(Long id, Commentaire nouveau) {
        Commentaire c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commentaire introuvable"));

        c.setTexte(nouveau.getTexte());
        c.setQualiteProduit(nouveau.getQualiteProduit());
        c.setRapportQualitePrix(nouveau.getRapportQualitePrix());
        c.setFaciliteUtilisation(nouveau.getFaciliteUtilisation());
        validateNotes(c);
        c.setNote(calculateNote(c));

        return repository.save(c);
    }

    private void validateNotes(Commentaire c) {
        if (c.getQualiteProduit() < 0 || c.getQualiteProduit() > 5
                || c.getRapportQualitePrix() < 0 || c.getRapportQualitePrix() > 5
                || c.getFaciliteUtilisation() < 0 || c.getFaciliteUtilisation() > 5) {
            throw new IllegalArgumentException("Les sous-notes doivent être comprises entre 0 et 5");
        }
    }

    private int calculateNote(Commentaire c) {
        return Math.round((c.getQualiteProduit() + c.getRapportQualitePrix() + c.getFaciliteUtilisation()) / 3f);
    }

    public boolean isProduitNotable(Long produitId) {
        String url = "http://localhost:8081/produits/" + produitId + "/notable";
        Boolean notable = restTemplate.getForObject(url, Boolean.class);
        return Boolean.TRUE.equals(notable);
    }

    public CommentaireDTO getCommentaireEnrichi(Long id) {
        Commentaire commentaire = get(id).orElseThrow(() -> new RuntimeException("Commentaire introuvable"));

        String url = "http://localhost:8081/produits/" + commentaire.getProduitId();
        ProduitDTO produit = restTemplate.getForObject(url, ProduitDTO.class);

        CommentaireDTO dto = new CommentaireDTO();
        dto.setId(commentaire.getId());
        dto.setTexte(commentaire.getTexte());
        dto.setNote(commentaire.getNote());
        dto.setQualiteProduit(commentaire.getQualiteProduit());
        dto.setRapportQualitePrix(commentaire.getRapportQualitePrix());
        dto.setFaciliteUtilisation(commentaire.getFaciliteUtilisation());
        dto.setProduitId(commentaire.getProduitId());
        dto.setNomProduit(produit != null ? produit.getNom() : null);

        return dto;
    }
}
