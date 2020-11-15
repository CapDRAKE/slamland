package slamland;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueListeRestaurant extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTable listeRestaurant;
	private int i;
	private JScrollPane scrollpane;

	public VueListeRestaurant(ArrayList <restaurant> restaurant) {

		Object [][] lesRestaurant = new Object[20][3];
		String[] entetes = {"Nom", "Nombre de tables", "Capacité"};
		
		int i=0;
		while( i < restaurant.size()) {
			lesRestaurant[i][0] = restaurant.get(i).getNom();
			lesRestaurant[i][1] = restaurant.get(i).getNbTables();
			lesRestaurant[i][2] = restaurant.get(i).getCapacite();
			i++;
		}
		listeRestaurant = new JTable(lesRestaurant, entetes);
		scrollpane = new JScrollPane(listeRestaurant);
		
		this.add(scrollpane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}