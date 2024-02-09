package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Article;
import Connection.DBConnection;

public class ArticleDao {
    public void ajouterArticle(Article article) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO articles (nom, prixHT) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, article.getNom());
                statement.setDouble(2, article.getPrixHT());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void modifierArticle(int code, String nouveauNom, double nouveauPrixHT) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "UPDATE articles SET nom=?, prixHT=? WHERE code=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nouveauNom);
                statement.setDouble(2, nouveauPrixHT);
                statement.setInt(3, code);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerArticle(int code) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "DELETE FROM articles WHERE code=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, code);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Article selectionnerArticle(int code) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM articles WHERE code=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, code);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String nom = resultSet.getString("nom");
                        double prixHT = resultSet.getDouble("prixHT");
                        return new Article(nom, prixHT);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
   
}