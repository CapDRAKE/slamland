package slamland;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueListeAttraction extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTable listeParc;
	private int i;
	private JScrollPane scrollpane;

	public VueListeAttraction(ArrayList <attractions> attractions) {
		Object [][] lesAttractions = new Object[20][4];
		String[] entetes = {"Nom attraction", "Capacitée max", "Duree", "Prix"};
		
		i=0;
		while( i < attractions.size()) {
			lesAttractions[i][0] = attractions.get(i).getNom();
			lesAttractions[i][1] = attractions.get(i).getCapacite();
			lesAttractions[i][2] = attractions.get(i).getDuree();
			lesAttractions[i][3] = attractions.get(i).getPrix();
			i++;
		}
		listeParc = new JTable(lesAttractions, entetes);
		scrollpane = new JScrollPane(listeParc);
		
		this.add(scrollpane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}