package Test;

import Dao.MagasinDao;
import model.Magasin;

public class MagasinDaoTest {
    public static void main(String[] args) {
        MagasinDao magasinDao = new MagasinDao();

        // Exemple d'ajout d'un magasin
        Magasin nouveauMagasin = new Magasin();
        nouveauMagasin.setNom("ElectroMagasin");
        magasinDao.insererMagasin(nouveauMagasin);

        // Exemple d'ajout d'un article à un magasin
        int magasinId = 1;  
        int articleCode = 1;  
        magasinDao.ajouterArticleAuMagasin(magasinId, articleCode);

     // Exemple de modification d'un magasin
        int magasinId1 = 1;  // Remplacez par l'ID réel du magasin
        magasinDao.modifierMagasin(magasinId1, "NouveauNomElectroMagasin");

        // Exemple de suppression d'un magasin
        magasinDao.supprimerMagasin(magasinId);

        // Exemple de sélection d'un magasin
        int magasinIdSelectionne = 2;  // Remplacez par l'ID réel du magasin
        Magasin magasinSelectionne = magasinDao.selectionnerMagasin(magasinIdSelectionne);
        if (magasinSelectionne != null) {
            System.out.println("Magasin sélectionné : " + magasinSelectionne.getNom());
        } else {
            System.out.println("Aucun magasin trouvé avec l'ID " + magasinIdSelectionne);
        }
    }
}
