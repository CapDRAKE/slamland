package slamland;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VueSupprimerVisiteur extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText, userText2, userText3;
	private JButton selectButton;
	private JLabel userLabel, userLabel2, registered;

	public VueSupprimerVisiteur() {

		userLabel = new JLabel("Nom du visiteur à supprimer:");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		userText = new JTextField(40);
		userText.setBounds(110, 100, 160, 25);
		this.add(userText);
		
		selectButton = new JButton("Supprimer");
		//selectButton.setBounds(30, 80, 150, 25);
		this.add(selectButton);
		
		selectButton.addActionListener(this);
		
		setVisible(true);
		
	}
	
	public void victoire() {
		registered = new JLabel("Suppression  réussie");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}
	
	public void loupe() {
		registered = new JLabel("Echec de la suppression (verifiez votre entrée)");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == selectButton) {
			String nom = userText.getText();
			if (Controleur.supprimerVisiteur(nom)) {
				victoire();
			}
			else {
				loupe();
			}
			this.revalidate();
		}
	}
}