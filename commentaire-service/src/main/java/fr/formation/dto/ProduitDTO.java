package fr.formation.dto;

public class ProduitDTO {
    private Long id;
    private String nom;
    private double prix;
    private boolean notable;

    // Getters / Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public boolean isNotable() { return notable; }
    public void setNotable(boolean notable) { this.notable = notable; }
}
