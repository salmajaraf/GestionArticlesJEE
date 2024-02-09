package model;

public class Article {
    protected int code;  // Vous pourriez vouloir fournir un getter pour code également
    private String nom;
    private double prixHT;

    public Article(String nom, double prixHT) {
        this.nom = nom;
        this.prixHT = prixHT;
    }

    public double prixTransport() {
        return prixHT * 0.05;  // prix transport repr 5% du prix du produit
    }

    public String getNom() {
        return nom;
    }

    public double getPrixHT() {
        return prixHT;
    }

    public String toString() {
        return this.code + " " + this.nom;
    }
}
