package model;

public class Fragile extends Article {
    private String emballage;

    // Constructeur avec emballage
    public Fragile(String nom, double prixHT, String emballage) {
        super(nom, prixHT);
        this.setEmballage(emballage);
    }

    // Constructeur sans emballage
    public Fragile(String nom, double prixHT) {
        super(nom, prixHT);
    }

	public String getEmballage() {
		return emballage;
	}

	public void setEmballage(String emballage) {
		this.emballage = emballage;
	}
	public double prixTransport() {
        return super.prixTransport() * 2;
    }
}
