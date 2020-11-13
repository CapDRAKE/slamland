package slamland;

public class parc_attractions {
	private String Ville;
	private String Nom;
	
	public parc_attractions(String uneVille, String unNom) {
		this.Ville = uneVille;
		this.Nom = unNom;
	}
	
	public String getUneVille() {
		return Ville;
	}
	public void setUneVille(String uneVille) {
		this.Ville = uneVille;
	}
	public String getUnNom() {
		return Nom;
	}
	public void setUnNom(String unNom) {
		this.Nom = unNom;
	}
	
	
}
