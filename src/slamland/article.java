package slamland;

public class article {
		private String nom;
		private int prix;
		
		public article(String unNom, int unPrix) {
			this.nom = unNom;
			this.prix = unPrix;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public int getPrix() {
			return prix;
		}

		public void setPrix(int prix) {
			this.prix = prix;
		}
}
