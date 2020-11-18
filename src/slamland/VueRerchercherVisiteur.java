package slamland;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueRerchercherVisiteur extends JPanel implements ActionListener {
	/**
	 @author ramse
	 Vue recherche visiteur
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText, userText2, userText3;
	private JButton selectButton;
	private JLabel userLabel, userLabel2, registered;
	
	public VueRerchercherVisiteur() {
		
		//Dénomination
		userLabel = new JLabel("Nom du visiteur à rechercher:");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Insertion
		userText = new JTextField(20);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);
		
		//Boutton
		selectButton = new JButton("Rechercher le visiteur");
		selectButton.setBounds(30, 80, 150, 25);
		this.add(selectButton);
		
		selectButton.addActionListener(this);
		
		setVisible(true);
		
	}
	
	//Si trouvé
	public void victoire() {
		registered = new JLabel("Visiteur trouvé");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}
	
	//Si pas trouvé
	public void loupe() {
		registered = new JLabel("Introuvable");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}

	//Si l'utilisateur appuie sur le boutton
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == selectButton) {
			String nom = userText.getText();
			if (Controleur.verifVisiteur(nom)) {
				victoire();
			}
			else {
				loupe();
			}
			this.revalidate();
		}
	}
	
}
