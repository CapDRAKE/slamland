package slamland;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueListeXML extends JPanel implements ActionListener {
	//Variable
		private JTextArea xml;
		/**
		 @author ramse
		 Vue XML
		 */
		public VueListeXML() {
			//Affichage du format XML
			xml = new JTextArea(Controleur.toXML());
			this.add(xml);
			
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
