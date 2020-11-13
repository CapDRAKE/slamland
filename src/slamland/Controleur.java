package slamland;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controleur {
	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
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
			//res.close();
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}
	
	public static ArrayList<parc_attractions> getLesParcs() {
		connexionBdd();
		
		//Déclaration des variables des getStrings
		String nom;
		String ville;
		
		//Déclaration du parc
		parc_attractions parc;
		
		//Déclaration de la requête
		String req = "SELECT * FROM Parc_attractions";
		
		//Déclaration de la liste des parcs
		ArrayList <parc_attractions> parcs;
		parcs = new ArrayList <parc_attractions>();
		
		try {
			//On execute 
			rs = st.executeQuery(req);
			while (rs.next()) {
				nom = rs.getString(2);
				ville = rs.getString(3);
				System.out.println(nom);
				parc = new parc_attractions(ville, nom);
				parcs.add(parc);
			}
			System.out.println(parcs.size());
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println(erreur);
		}
		deconnexionBdd();

		return parcs;

	}
	
	public static ArrayList<attractions> getLesAttractions() {
		connexionBdd();
		
		//Déclaration des variables des getStrings
		String nom;
		int capacite;
		int duree;
		int prix;
		
		//Déclaration du parc
		attractions lesAttractions;
		
		//Déclaration de la requête
		String req = "SELECT * FROM attraction";
		
		//Déclaration de la liste des parcs
		ArrayList <attractions> attraction;
		attraction = new ArrayList <attractions>();
		
		try {
			//On execute 
			rs = st.executeQuery(req);
			while (rs.next()) {
				nom = rs.getString(2);
				capacite = rs.getInt(3);
				duree = rs.getInt(4);
				prix = rs.getInt(5);
				lesAttractions = new attractions(nom, capacite, duree, prix);
				attraction.add(lesAttractions);
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println(erreur);
		}
		deconnexionBdd();

		return attraction;

	}
	
	public static ArrayList<visiteur> getLesVisiteurs() {
		connexionBdd();
		
		//Déclaration des variables des getStrings
		String nom;
		String prenom;
		Date dateNaiss;
		
		//Déclaration du parc
		visiteur lesVisiteurs;
		
		//Déclaration de la requête
		String req = "SELECT * FROM visiteur";
		
		//Déclaration de la liste des parcs
		ArrayList <visiteur> visiteur;
		visiteur = new ArrayList <visiteur>();
		
		try {
			//On execute 
			rs = st.executeQuery(req);
			while (rs.next()) {
				nom = rs.getString(2);
				prenom = rs.getString(3);
				dateNaiss = rs.getDate(4);
				lesVisiteurs = new visiteur(nom, prenom, dateNaiss);
				visiteur.add(lesVisiteurs);
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println(erreur);
		}
		deconnexionBdd();

		return visiteur;

	}
	
	//Méthode pour ajouter un parc
	public static boolean ajouterParc(String nom, String ville) {
		connexionBdd();
		boolean rep = false;
		try {
			PreparedStatement statement = connexion.prepareStatement("insert into Parc_attractions (nom, ville) values (?, ?);");
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