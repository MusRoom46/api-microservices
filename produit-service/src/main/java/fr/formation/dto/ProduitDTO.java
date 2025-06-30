package fr.formation.dto;

import java.util.List;

public class ProduitDTO {
    private Long id;
    private String nom;
    private double prix;
    private boolean notable;
    private double noteMoyenne;
    private List<CommentaireDTO> commentaires;

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public boolean isNotable() { return notable; }
    public void setNotable(boolean notable) { this.notable = notable; }

    public double getNoteMoyenne() { return noteMoyenne; }
    public void setNoteMoyenne(double noteMoyenne) { this.noteMoyenne = noteMoyenne; }

    public List<CommentaireDTO> getCommentaires() { return commentaires; }
    public void setCommentaires(List<CommentaireDTO> commentaires) { this.commentaires = commentaires; }
}
