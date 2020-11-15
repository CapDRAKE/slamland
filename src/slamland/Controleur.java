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
	
	
	//M�thode pour se connecter � la bdd
	public static void connexionBdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion =DriverManager.getConnection("jdbc:mysql://127.0.0.1/slamland?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");
			 st = connexion.createStatement();
		}

		catch (SQLException e) {
			System.err.println("Erreur de connexion � la base de donn�ees " + e);
		} catch (ClassNotFoundException e) {
			System.err.println("Driver non charg� " + e);
		}
	}
	
	//M�thode pour se d�connecter de la bdd
	public static void deconnexionBdd() {
		try {
			connexion.close();
		} catch (SQLException e) {
			System.err.println("Erreur lors de la d�connexion " + e);
		}
	}
	
	//M�thode pour se connecter
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
		
		//D�claration des variables des getStrings
		String nom;
		String ville;
		
		//D�claration du parc
		parc_attractions parc;
		
		//D�claration de la requ�te
		String req = "SELECT * FROM Parc_attractions";
		
		//D�claration de la liste des parcs
		ArrayList <parc_attractions> parcs;
		parcs = new ArrayList <parc_attractions>();
		
		try {
			//On execute 
			rs = st.executeQuery(req);
			while (rs.next()) {
				nom = rs.getString(2);
				ville = rs.getString(3);
				parc = new parc_attractions(ville, nom);
				parcs.add(parc);
			}
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
		
		//D�claration des variables des getStrings
		String nom;
		int capacite;
		int duree;
		int prix;
		
		//D�claration du parc
		attractions lesAttractions;
		
		//D�claration de la requ�te
		String req = "SELECT * FROM attraction";
		
		//D�claration de la liste des parcs
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
		
		//D�claration des variables des getStrings
		String nom;
		String prenom;
		Date dateNaiss;
		
		//D�claration du parc
		visiteur lesVisiteurs;
		
		//D�claration de la requ�te
		String req = "SELECT * FROM visiteur";
		
		//D�claration de la liste des parcs
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
	
	public static ArrayList<restaurant> getLesRestaurants() {
		connexionBdd();
		
		//D�claration des variables des getStrings
		String nom;
		int capacite;
		int nbTables;
		
		//D�claration du parc
		restaurant lesRestaurants;
		
		//D�claration de la requ�te
		String req = "SELECT * FROM restaurants";
		
		//D�claration de la liste des parcs
		ArrayList <restaurant> restaurant;
		restaurant = new ArrayList <restaurant>();
		
		try {
			//On execute 
			rs = st.executeQuery(req);
			while (rs.next()) {
				nom = rs.getString(2);
				capacite = rs.getInt(3);
				nbTables = rs.getInt(4);
				lesRestaurants = new restaurant(nom, capacite, nbTables);
				restaurant.add(lesRestaurants);
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println(erreur);
		}
		deconnexionBdd();

		return restaurant;

	}
	
	public static ArrayList<magasin> getLesMagasins() {
		connexionBdd();
		
		//D�claration des variables des getStrings
		String nom;
		String type;
		
		//D�claration du parc
		magasin lesMagasins;
		
		//D�claration de la requ�te
		String req = "SELECT commerce.nom, magasin.type_magasin FROM commerce, magasin WHERE commerce.Id_Commerce = magasin.Id_Commerce";
		
		//D�claration de la liste des parcs
		ArrayList <magasin> magasin;
		magasin = new ArrayList <magasin>();
		
		try {
			//On execute 
			rs = st.executeQuery(req);
			while (rs.next()) {
				nom = rs.getString(1);
				type = rs.getString(2);
				lesMagasins = new magasin(nom, type);
				magasin.add(lesMagasins);
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println(erreur);
		}
		deconnexionBdd();

		return magasin;

	}
	
	
	//M�thode pour ajouter un parc
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