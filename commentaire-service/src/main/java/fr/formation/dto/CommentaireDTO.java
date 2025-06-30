package fr.formation.dto;

public class CommentaireDTO {
    private Long id;
    private String texte;
    private int note;

    private int qualiteProduit;
    private int rapportQualitePrix;
    private int faciliteUtilisation;

    private Long produitId;
    private String nomProduit;

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

    public String getNomProduit() { return nomProduit; }
    public void setNomProduit(String nomProduit) { this.nomProduit = nomProduit; }
}
