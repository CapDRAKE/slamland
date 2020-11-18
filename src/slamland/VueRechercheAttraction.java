package slamland;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueRechercheAttraction extends JPanel implements ActionListener {
	/**
	 @author ramse
	 Vue rechercher attraction
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText, userText2, userText3;
	private JButton selectButton;
	private JLabel userLabel, userLabel2, registered;
	
	public VueRechercheAttraction() {
		
		//Dénomination
		userLabel = new JLabel("Nom de l'attraction à rechercher:");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Insertion
		userText = new JTextField(20);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);
		
		//Boutton
		selectButton = new JButton("Rechercher l'attraction");
		selectButton.setBounds(30, 80, 150, 25);
		this.add(selectButton);
		
		selectButton.addActionListener(this);
		
		setVisible(true);
		
	}
	
	//Si trouvé
	public void victoire() {
		registered = new JLabel("Attraction trouvée");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}
	 
	//Si pas trouvé
	public void loupe() {
		registered = new JLabel("Attraction introuvable");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}

	//Si l'utilisateur appuie sur le bouton
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == selectButton) {
			String nom = userText.getText();
			if (Controleur.verifAttraction(nom)) {
				victoire();
			}
			else {
				loupe();
			}
			this.revalidate();
		}
	}
	
}
