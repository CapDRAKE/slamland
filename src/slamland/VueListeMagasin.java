package slamland;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VueListeMagasin extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTable listeMagasin;
	private int i;
	private JScrollPane scrollpane;


	public VueListeMagasin(ArrayList<magasin> lesMagasins) {
		// TODO Auto-generated constructor stub
		

		Object [][] magasins = new Object[20][3];
		String[] entetes = {"Nom", "Type de magasin"};
		
		int i=0;
		while( i < lesMagasins.size()) {
			magasins[i][0] = lesMagasins.get(i).getNom();
			magasins[i][1] = lesMagasins.get(i).getType();
			i++;
		}
		listeMagasin = new JTable(magasins, entetes);
		scrollpane = new JScrollPane(listeMagasin);
		
		this.add(scrollpane, BorderLayout.CENTER);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}