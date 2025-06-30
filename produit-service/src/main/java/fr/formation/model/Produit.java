package fr.formation.model;

import jakarta.persistence.*;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private double prix;
    private boolean notable;

    // Getters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public boolean isNotable() {
        return notable;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setNotable(boolean notable) {
        this.notable = notable;
    }
}
