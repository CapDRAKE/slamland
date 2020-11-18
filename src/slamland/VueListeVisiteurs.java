package slamland;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueListeVisiteurs extends JPanel implements ActionListener {
	/**
	@author ramse
	Vue lise visiteur
	 */
	//Variables
	private static final long serialVersionUID = 1L;
	private static JTable listeVisiteur;
	private int i;
	private JScrollPane scrollpane;

	public VueListeVisiteurs(ArrayList <visiteur> visiteurs) {
		
		//Déclaration du tableau
		Object [][] lesVisiteurs = new Object[20][3];
		String[] entetes = {"Nom", "Prenom", "Date de naissance"};
		
		int i=0;
		//On ajoute les éléments
		while( i < visiteurs.size()) {
			lesVisiteurs[i][0] = visiteurs.get(i).getNom();
			lesVisiteurs[i][1] = visiteurs.get(i).getPrenom();
			lesVisiteurs[i][2] = visiteurs.get(i).getDateNaiss();
			i++;
		}
		
		//On ajoute le tableau et l'entete
		listeVisiteur = new JTable(lesVisiteurs, entetes);
		scrollpane = new JScrollPane(listeVisiteur);
		
		this.add(scrollpane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}