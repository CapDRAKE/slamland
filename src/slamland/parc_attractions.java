package slamland;

public class parc_attractions {
	private static String Ville;
	private static String Nom;
	
	public parc_attractions(String uneVille, String unNom) {
		parc_attractions.Ville = uneVille;
		parc_attractions.Nom = unNom;
	}
	
	public static String getUneVille() {
		return Ville;
	}
	public static void setUneVille(String uneVille) {
		parc_attractions.Ville = uneVille;
	}
	public static String getUnNom() {
		return Nom;
	}
	public static void setUnNom(String unNom) {
		parc_attractions.Nom = unNom;
	}
	
	
}
