package slamland;
/**
 @author ramse
 @param nom
 @param capacite
 @param duree
 @param prix
 */
public class attractions {
		private String nom;
		private int capacite;
		private int duree;
		private int prix;
		
		public attractions(String unNom, int uneCapacite, int uneDuree, int unPrix) {
			this.nom = unNom;
			this.capacite = uneCapacite;
			this.duree = uneDuree;
			this.prix = unPrix;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public int getCapacite() {
			return capacite;
		}

		public void setCapacite(int capacite) {
			this.capacite = capacite;
		}

		public int getDuree() {
			return duree;
		}

		public void setDuree(int duree) {
			this.duree = duree;
		}

		public int getPrix() {
			return prix;
		}

		public void setPrix(int prix) {
			this.prix = prix;
		}
		
		
}
