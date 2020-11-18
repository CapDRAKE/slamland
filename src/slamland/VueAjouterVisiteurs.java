package slamland;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VueAjouterVisiteurs extends JPanel implements ActionListener {
	/**
	@author ramse
	Vue Ajouter visiteur
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText, userText2, userText3;
	private JButton selectButton;
	private JLabel userLabel, userLabel2, registered;

	public VueAjouterVisiteurs() {
		
		//Dénomination
		userLabel = new JLabel("Nom du visiteur:");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Insertion
		userText = new JTextField(40);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);
		
		//Dénomination
		userLabel = new JLabel("Prenom du visiteur :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Insertion
		userText2 = new JTextField(40);
		userText2.setBounds(110, 10, 160, 25);
		this.add(userText2);
		
		//Dénomination
		userLabel = new JLabel("Date de naissance du visiteur (format : AAAA-MM-JJ :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Insertion
		userText3 = new JTextField(25);
		userText3.setBounds(110, 10, 160, 25);
		this.add(userText3);
		
		//Boutton
		selectButton = new JButton("Ajouter");
		selectButton.setBounds(30, 80, 150, 25);
		this.add(selectButton);
		
		selectButton.addActionListener(this);
		
		setVisible(true);
		
	}
	
	//Si ajout réussi
	public void victoire() {
		registered = new JLabel("Ajout du visiteur réussi !");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}
	
	//Si l'utilisateur appuie sur le boutton
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == selectButton) {
			String nom = userText.getText();
			String prenom = userText2.getText();
			String date = userText3.getText();
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
			if (Controleur.ajouterVisiteur(nom, prenom, date)) {
				victoire();
			}
			this.revalidate();
		}
	}
}