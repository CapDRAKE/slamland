package slamland;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VueParc extends JPanel implements ActionListener {
	/**
	 @author ramse
	 Vue liste parc
	 */
	//Variables
	private static final long serialVersionUID = 1L;
	private static JTable listeParc;
	private int i;
	private JScrollPane scrollpane;
	
	public VueParc(ArrayList <parc_attractions> lesParcs) {
		
		//Déclaration du tableau
		Object [][] parc = new Object[20][2];
		String[] entetes = {"Nom parc", "Ville"}; 
		
		i=0;
		
		//Ajoute les données dans le tableau
		while( i < lesParcs.size()) {
			parc[i][0] = lesParcs.get(i).getUnNom();
			parc[i][1] = lesParcs.get(i).getUneVille();
			i++;
		}
		
		//Ajoute le tableau et l'entete
		listeParc = new JTable(parc, entetes);
		scrollpane = new JScrollPane(listeParc);
		
		this.add(scrollpane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
