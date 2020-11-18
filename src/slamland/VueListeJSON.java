package slamland;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueListeJSON extends JPanel implements ActionListener {
		private JTextArea json;
		
		public VueListeJSON() {
			
			json = new JTextArea(Controleur.toJSON());
			this.add(json);
			
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}