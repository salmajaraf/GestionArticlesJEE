package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Fragile;
import Connection.DBConnection;
public class FragileDao {

    public void insererFragile(Fragile articleFragile) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO articles_fragiles (nom, prixHT, emballage) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, articleFragile.getNom());
                statement.setDouble(2, articleFragile.getPrixHT());
                statement.setString(3, articleFragile.getEmballage());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierArticleFragile(int code, String nouveauNom, double nouveauPrixHT, String nouvelEmballage) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "UPDATE articles_fragiles SET nom=?, prixHT=?, emballage=? WHERE code=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nouveauNom);
                statement.setDouble(2, nouveauPrixHT);
                statement.setString(3, nouvelEmballage);
                statement.setInt(4, code);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerArticleFragile(int code) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "DELETE FROM articles_fragiles WHERE code=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, code);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Fragile selectionnerArticleFragile(int code) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM articles_fragiles WHERE code=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, code);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String nom = resultSet.getString("nom");
                        double prixHT = resultSet.getDouble("prixHT");
                        String emballage = resultSet.getString("emballage");
                        return new Fragile(nom, prixHT, emballage);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    
}
