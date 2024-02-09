package Test;

import Dao.ArticleDao;
import model.Article;

public class DaoTest {
    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDao();

        // Exemple d'ajout d'un article
        Article nouvelArticle = new Article("Poduit1", 1200.0);
        articleDao.ajouterArticle(nouvelArticle);

        // Exemple de modification d'un article
        articleDao.modifierArticle(8, "IPHONE S10", 1300.0);

        // Exemple de suppression d'un article
        //articleDao.supprimerArticle(3);

        // Exemple de sélection d'un article
        Article articleSelectionne = articleDao.selectionnerArticle(8);
        if (articleSelectionne != null) {
            System.out.println("Article sélectionné : " + articleSelectionne);
        } else {
            System.out.println("Aucun article trouvé avec le code 2.");
        }        
    }
}
