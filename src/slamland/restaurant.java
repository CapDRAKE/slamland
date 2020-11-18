package slamland;
/**
 @author ramse
 @param nom
 @param nbTables
 @param capacite
 */
public class restaurant {
		private String nom;
		private int nbTables;
		private int capacite;
		
		
		public restaurant (String unNom, int unNbTables, int uneCapacite) {
			this.nom = unNom;
			this.nbTables = unNbTables;
			this.capacite = uneCapacite;
		}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public int getNbTables() {
			return nbTables;
		}


		public void setNbTables(int nbTables) {
			this.nbTables = nbTables;
		}


		public int getCapacite() {
			return capacite;
		}


		public void setCapacite(int capacite) {
			this.capacite = capacite;
		}
		
		
}
