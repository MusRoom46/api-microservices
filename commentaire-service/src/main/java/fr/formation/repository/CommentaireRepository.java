package fr.formation.repository;

import fr.formation.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    List<Commentaire> findByProduitId(Long produitId);
}
