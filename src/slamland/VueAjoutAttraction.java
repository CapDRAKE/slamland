package slamland;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VueAjoutAttraction extends JPanel implements ActionListener {
	/**
	 Page d'ajout attraction
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText, userText2, userText3, userText4, userText5;
	private JButton selectButton;
	private JLabel userLabel, userLabel2, registered;

	public VueAjoutAttraction() {
		
		//Dénomination
		userLabel = new JLabel("Nom du parc:");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Insertion
		userText = new JTextField(40);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);
		
		//Dénomination
		userLabel = new JLabel("Nom de l'attraction :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Insertion
		userText2 = new JTextField(45);
		userText2.setBounds(110, 10, 160, 25);
		this.add(userText2);
		
		//Dénomination
		userLabel = new JLabel("Capacité :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Insertion
		userText3 = new JTextField(10);
		userText3.setBounds(110, 10, 160, 25);
		this.add(userText3);
		
		//Dénomination
		userLabel = new JLabel("Durée :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Insertion
		userText4 = new JTextField(10);
		userText4.setBounds(110, 10, 160, 25);
		this.add(userText4);
		
		//Dénomination
		userLabel = new JLabel("Prix :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Insertion
		userText5 = new JTextField(10);
		userText5.setBounds(110, 10, 160, 25);
		this.add(userText5);
		
		//bouton
		selectButton = new JButton("Ajouter");
		selectButton.setBounds(30, 80, 150, 25);
		this.add(selectButton);
		
		selectButton.addActionListener(this);
		
		setVisible(true);
		
	}

	//S'affiche si tout ajout réussi
	public void victoire() {
		registered = new JLabel("Ajout réussie");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}
	
	//S'affiche si l'ajout ne marche pas
	public void loupe() {
		registered = new JLabel("Echec de l'ajout (verifiez votre entrée)");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}
	
	//S'execute si l'utilisateur appuie sur le bouton
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == selectButton) {
			String nom = userText.getText();
			String nomA = userText2.getText();
			String capacite = userText3.getText();
			String duree = userText4.getText();
			String prix = userText5.getText();
			if(Controleur.verifParc(nom)) {
				int id = Controleur.trouverParc(nom);
				if(Controleur.ajouterAttraction(nomA, capacite, duree, prix, id)){
					victoire();
				}
				else {
					loupe();
				}
			}
			else {
				loupe();				
			}
		}
	}
}