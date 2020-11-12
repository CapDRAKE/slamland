package slamland;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueParc extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText;
	private JButton selectButton;
	private JLabel userLabel;	
	private static ArrayList <parc_attractions> parcs;
	private static final Object[][] lignes = {};
	private static final Object[] colonnes = {"", ""};
	private static DefaultTableModel listTableModel;
	private static JTable listeParc;
	
	public VueParc() {

		userLabel = new JLabel("Saisir ville :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);
		
		selectButton = new JButton("Selectionner");
		selectButton.setBounds(30, 80, 150, 25);
		this.add(selectButton);
		
		selectButton.addActionListener(this);
		
		setVisible(true);
	
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == selectButton) {
			String ville = userText.getText();
			parcs = new ArrayList <parc_attractions>();
			parcs = Controleur.getLesParcs(ville);
			int taille = Controleur.getNbParcs(ville);
			if(taille == 0) {
				System.out.println("Il n'y a pas de parc pour cette ville");
			}
			else {

			
			listTableModel = new DefaultTableModel (lignes, colonnes);
			listTableModel.addRow(new Object[] {"Ville", "Nom"});
			
			for(int i = 0; i < taille; i++) {
				listTableModel.addRow(new Object[] {parcs.get(i).getUnNom(),parcs.get(i).getUneVille()});
			}
			
			listeParc = new JTable(listTableModel);
			listeParc.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			listeParc.setCellEditor(null);
			listeParc.setBounds(0,100,500,30*taille+30);
			listeParc.setRowHeight(30);
			
			
			//JScrollPane scrollpane = null;
			//JTable tableau = null;
			//String[] entetes = {"Ville", "Nom du parc"};
			//tableau = new JTable(Controleur.getLesParcs(ville), entetes);
			//scrollpane = new JScrollPane(tableau);
			this.revalidate();
			this.add(listeParc);


			}
		}
	}
}
