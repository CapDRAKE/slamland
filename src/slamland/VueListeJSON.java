package slamland;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 @author ramse
 Vue liste JSON
 */
public class VueListeJSON extends JPanel implements ActionListener {
		//Variables
		private JTextArea json;
		
		public VueListeJSON() {
			
			//Va afficher la liste en json
			json = new JTextArea(Controleur.toJSON());
			this.add(json);
			
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}