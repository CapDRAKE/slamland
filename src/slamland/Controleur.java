package slamland;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controleur {
	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	private static ArrayList <Object> parcs;
	private static int i = 0;
	private static Object[][] donnees = new Object[15][2];
	private static PreparedStatement statement;
	private static ResultSet res;
	
	
	//Méthode pour se connecter à la bdd
	public static void connexionBdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion =DriverManager.getConnection("jdbc:mysql://127.0.0.1/slamland?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");
			 st = connexion.createStatement();
		}

		catch (SQLException e) {
			System.err.println("Erreur de connexion à la base de donnéees " + e);
		} catch (ClassNotFoundException e) {
			System.err.println("Driver non chargé " + e);
		}
	}
	
	//Méthode pour se déconnecter de la bdd
	public static void deconnexionBdd() {
		try {
			connexion.close();
		} catch (SQLException e) {
			System.err.println("Erreur lors de la déconnexion " + e);
		}
	}
	
	//Méthode pour se connecter
	public static boolean connexion(String login, String mdp) {
		boolean rep = false;
		connexionBdd();
		//PreparedStatement statement = connexion.prepareStatement("select login, mdp from Utilisateurs where login = ? and mdp = ?;");
		try {
			statement = connexion.prepareStatement("SELECT login, mdp FROM Utilisateur WHERE login = ? AND mdp = ?;");
			statement.setString(1, login);
			statement.setString(2, mdp);
			res = statement.executeQuery();
			if (res.next()) {
				//String getLogin = res.getString("login");
				rep = true;
			}
			res.close();
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}
	
	//Méthode pour obtenir la liste des parcs
	public static Object[][] getLesParcs(String uneVille) {
		connexionBdd();
		try {
			statement = connexion.prepareStatement("SELECT nom, ville FROM Parc_attractions WHERE ville = ?;");
			statement.setString(1, uneVille);
			rs = statement.executeQuery();
			while (rs.next()) {
				System.out.println("oui yes");
				 donnees[i][1] = rs.getString(1);
				 donnees[i][0] = rs.getString(2);
				 i++;
				 
			}
			rs.close();
		}
		catch(SQLException erreur) {
	    	System.out.println("Mauvaise saisie");
		}
		deconnexionBdd();
		return donnees;

	}
	
	//Méthode pour ajouter un parc
	public static boolean ajouterParc(String nom, String ville) {
		connexionBdd();
		boolean rep = false;
		try {
			PreparedStatement statement = connexion.prepareStatement("insert into parc_attractions (nom, ville) values (?, ?);");
			statement.setString(1,  nom);
			statement.setString(2,  ville);
			int nbLignes = statement.executeUpdate();
			rep = true;
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}
	

}