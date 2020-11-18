package slamland;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VueAjoutAttraction extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText, userText2, userText3, userText4, userText5;
	private JButton selectButton;
	private JLabel userLabel, userLabel2, registered;

	public VueAjoutAttraction() {

		userLabel = new JLabel("Nom du parc:");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		userText = new JTextField(40);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);
		
		userLabel = new JLabel("Nom de l'attraction :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		userText2 = new JTextField(45);
		userText2.setBounds(110, 10, 160, 25);
		this.add(userText2);
		
		userLabel = new JLabel("Capacité :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		userText3 = new JTextField(10);
		userText3.setBounds(110, 10, 160, 25);
		this.add(userText3);
		
		userLabel = new JLabel("Durée :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		userText4 = new JTextField(10);
		userText4.setBounds(110, 10, 160, 25);
		this.add(userText4);
		
		userLabel = new JLabel("Prix :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		userText5 = new JTextField(10);
		userText5.setBounds(110, 10, 160, 25);
		this.add(userText5);
		
		selectButton = new JButton("Ajouter");
		selectButton.setBounds(30, 80, 150, 25);
		this.add(selectButton);
		
		selectButton.addActionListener(this);
		
		setVisible(true);
		
	}
	
	public void victoire() {
		registered = new JLabel("Ajout réussie");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}

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
			}
		}
	}
}