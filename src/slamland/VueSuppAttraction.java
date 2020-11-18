package slamland;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueSuppAttraction extends JPanel implements ActionListener {
	/**
	 @author ramse
	 Vue supprimer
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText, userText2, userText3;
	private JButton selectButton;
	private JLabel userLabel, userLabel2, registered;
	
	public VueSuppAttraction() {
		
		//Dénomination
		userLabel = new JLabel("Nom de l'attraction à supprimer:");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Insertion
		userText = new JTextField(20);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);
		
		//Boutton
		selectButton = new JButton("Supprimer");
		selectButton.setBounds(30, 80, 150, 25);
		this.add(selectButton);
		
		selectButton.addActionListener(this);
		
		setVisible(true);
		
	}
	
	
	//Si bien supprimé
	public void victoire() {
		registered = new JLabel("L'attraction a bien été supprimée");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}
	//Si pas supprimé
	public void loupe() {
		registered = new JLabel("Echec de la suppression (verifiez votre entrée)");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}

	//Si l'utilisateur appuie sur le boutton
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == selectButton) {
			String nom = userText.getText();
			if (Controleur.supprimerAttraction(nom)) {
				victoire();
			}
			else {
				loupe();
			}
			this.revalidate();
		}
	}
	
}
