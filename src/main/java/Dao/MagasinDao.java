package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DBConnection;
import model.Magasin;

public class MagasinDao {
    public void insererMagasin(Magasin magasin) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO magasins (nom) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, magasin.getNom());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouterArticleAuMagasin(int magasinId, int articleCode) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO magasin_articles (magasin_id, article_code) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, magasinId);
                statement.setInt(2, articleCode);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierMagasin(int magasinId, String nouveauNom) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "UPDATE magasins SET nom=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nouveauNom);
                statement.setInt(2, magasinId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerMagasin(int magasinId) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "DELETE FROM magasins WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, magasinId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Magasin selectionnerMagasin(int magasinId) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM magasins WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, magasinId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String nom = resultSet.getString("nom");
                        Magasin magasin = new Magasin();
                        magasin.setId(magasinId);
                        magasin.setNom(nom);
                        return magasin;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
