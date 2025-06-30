package fr.formation.model;

import jakarta.persistence.*;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texte;
    private int note;

    private int qualiteProduit;
    private int rapportQualitePrix;
    private int faciliteUtilisation;

    private Long produitId;

    // Getters / Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTexte() { return texte; }
    public void setTexte(String texte) { this.texte = texte; }

    public int getNote() { return note; }
    public void setNote(int note) { this.note = note; }

    public int getQualiteProduit() { return qualiteProduit; }
    public void setQualiteProduit(int qualiteProduit) { this.qualiteProduit = qualiteProduit; }

    public int getRapportQualitePrix() { return rapportQualitePrix; }
    public void setRapportQualitePrix(int rapportQualitePrix) { this.rapportQualitePrix = rapportQualitePrix; }

    public int getFaciliteUtilisation() { return faciliteUtilisation; }
    public void setFaciliteUtilisation(int faciliteUtilisation) { this.faciliteUtilisation = faciliteUtilisation; }

    public Long getProduitId() { return produitId; }
    public void setProduitId(Long produitId) { this.produitId = produitId; }
}
