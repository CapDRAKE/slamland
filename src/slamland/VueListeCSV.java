package slamland;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 @author ramse
 Vue CSV
 */
public class VueListeCSV extends JPanel implements ActionListener {
		//Variables
		private JTextArea csv;
		
		public VueListeCSV() {
			
			//Affiche le resultat de la fonction
			csv = new JTextArea(Controleur.toCSV());
			this.add(csv);
			
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
