package model;
import java.util.List;

public class Magasin {
    private int id;
    private String nom;
    private List<Article> articles;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public void add(Article article) {
        articles.add(article);
    }

    public boolean contains(Article article) {
        return articles.contains(article);
    }

    
}
