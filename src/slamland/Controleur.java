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
	
	public static ArrayList<restaurant> getLesRestaurants() {
		connexionBdd();
		
		//Déclaration des variables des getStrings
		String nom;
		int capacite;
		int nbTables;
		
		//Déclaration du parc
		restaurant lesRestaurants;
		
		//Déclaration de la requête
		String req = "SELECT * FROM restaurants";
		
		//Déclaration de la liste des parcs
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
		
		//Déclaration des variables des getStrings
		String nom;
		String type;
		
		//Déclaration du parc
		magasin lesMagasins;
		
		//Déclaration de la requête
		String req = "SELECT commerce.nom, magasin.type_magasin FROM commerce, magasin WHERE commerce.Id_Commerce = magasin.Id_Commerce";
		
		//Déclaration de la liste des parcs
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
	
	public static boolean ajouterVisiteur(String nom, String prenom,String uneDate) {
		connexionBdd();
		boolean rep = false;
		try {
			PreparedStatement statement = connexion.prepareStatement("insert into visiteur (nom, prenom, dateNaiss) values (?, ?, ?);");
			statement.setString(1,  nom);
			statement.setString(2,  prenom);
			statement.setString(3, uneDate);
			int nbLignes = statement.executeUpdate();
			rep = true;
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}
	
	public static boolean supprimerVisiteur(String nom) {
		connexionBdd();
		boolean rep = false;
		try {
			PreparedStatement statement = connexion.prepareStatement("DELETE FROM visiteur WHERE nom = ?;");
			statement.setString(1,  nom);
			int nbLignes = statement.executeUpdate();
			rep = true;
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}
	
	public static String toXML() {
		connexionBdd();
		String XML;
		String nom;
		String nomAttraction;
		int capacite;
		int duree;
		int prix;
		
		String req = "SELECT parc_attractions.nom, attraction.nom, attraction.capacite_max, attraction.duree, attraction.prix FROM attraction, parc_attractions WHERE attraction.Id_Parc_attractions = parc_attractions.Id_Parc_attractions;";
		
		XML = "<?XML version'1.0' encading='UTF-8'?>";
		//Déclaration de la liste des parcs
		try {
			//On execute 
			rs = st.executeQuery(req);
			while (rs.next()) {
				nom = rs.getString(1);
				nomAttraction = rs.getString(2);
				capacite = rs.getInt(3);
				duree = rs.getInt(4);
				prix = rs.getInt(5);

				XML = XML + "\n<Parc>" + nom + "\n";
				XML = XML + "<Nom>" + nomAttraction + "</Nom>\n";
				XML = XML + "<Capacite>" + capacite + "</Capacite>\n";
				XML = XML + "<Duree>" + duree + "</Duree>\n";
				XML = XML + "<Prix>" + prix + "</Prix>\n";
				XML = XML + "</Parc>";
			}
			rs.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return XML;
	}
	
	public static boolean verifVisiteur(String nom) {
		boolean rep = false;
		
		connexionBdd();
		//Déclaration de la requête
		String req = "SELECT * FROM visiteur WHERE nom = '"+nom+"'";
		
		try {
			//On execute 
			rs = st.executeQuery(req);
			while (rs.next()) {
				rep = true;
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println(erreur);
		}
		deconnexionBdd();
		
		
		return rep;
	}
	
	public static ArrayList<article> getLesArticles() {
		connexionBdd();
		
		//Déclaration des variables des getStrings
		String nom;
		int prix;
		
		//Déclaration du parc
		article lesArticles;
		
		//Déclaration de la requête
		String req = "SELECT nom, prix FROM articles";
		
		//Déclaration de la liste des parcs
		ArrayList <article> articles;
		articles = new ArrayList <article>();
		
		try {
			//On execute 
			rs = st.executeQuery(req);
			while (rs.next()) {
				nom = rs.getString(1);
				prix = rs.getInt(2);
				lesArticles = new article(nom, prix);
				articles.add(lesArticles);
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println(erreur);
		}
		deconnexionBdd();

		return articles;

	}
	
	public static boolean verifParc(String nom) {
		boolean rep = false;
		
		connexionBdd();
		//Déclaration de la requête
		String req = "SELECT nom FROM parc_attractions WHERE nom = '"+nom+"'";
		
		try {
			//On execute 
			rs = st.executeQuery(req);
			while (rs.next()) {
				rep = true;
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println(erreur);
		}
		deconnexionBdd();
		
		
		return rep;
	}
	
	public static int trouverParc(String unNom) {
		int id = 0;
		
		connexionBdd();
		//Déclaration de la requête
		String req = "SELECT Id_Parc_attractions FROM parc_attractions WHERE nom = '"+unNom+"'";
		
		try {
			//On execute 
			rs = st.executeQuery(req);
			while (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println(erreur);
		}
		deconnexionBdd();
			
		return id;
	}
	
	public static boolean ajouterAttraction(String nom, String capacite, String duree, String prix, int id) {
		connexionBdd();
		boolean rep = false;
		try {
			PreparedStatement statement = connexion.prepareStatement("insert into attraction (nom, capacite_max, duree, prix, Id_Parc_attractions) values (?, ?, ?, ?, ?);");
			statement.setString(1,  nom);
			statement.setString(2,  capacite);
			statement.setString(3, duree);
			statement.setString(4, prix);
			statement.setInt(5, id);
			int nbLignes = statement.executeUpdate();
			rep = true;
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}
	
	public static boolean verifAttraction(String nom) {
		boolean rep = false;
		
		connexionBdd();
		//Déclaration de la requête
		String req = "SELECT * FROM attraction WHERE nom = '"+nom+"'";
		
		try {
			//On execute 
			rs = st.executeQuery(req);
			while (rs.next()) {
				rep = true;
			}
			rs.close();
		}
		catch(SQLException erreur) {
			System.out.println(erreur);
		}
		deconnexionBdd();
		
		
		return rep;
	}
	
	public static boolean supprimerAttraction(String nom) {
		connexionBdd();
		boolean rep = false;
		try {
			PreparedStatement statement = connexion.prepareStatement("DELETE FROM attraction WHERE nom = ?;");
			statement.setString(1,  nom);
			int nbLignes = statement.executeUpdate();
			if(nbLignes != 0) {
				rep = true;
			}
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}
	

}