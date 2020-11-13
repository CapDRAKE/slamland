package slamland;

import java.sql.Date;

public class visiteur {
		private String nom;
		private String prenom;
		private Date dateNaiss;
		
		public visiteur(String unNom, String unPrenom, Date uneDate) {
			this.nom = unNom;
			this.prenom = unPrenom;
			this.dateNaiss = uneDate;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public Date getDateNaiss() {
			return dateNaiss;
		}

		public void setDateNaiss(Date dateNaiss) {
			this.dateNaiss = dateNaiss;
		}
		
		
}
