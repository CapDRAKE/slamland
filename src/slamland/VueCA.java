package slamland;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueCA extends JPanel implements ActionListener {
	/**
	 Vue de chiffre d'affaire
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText, userText2;
	private JButton selectButton;
	private JLabel userLabel, userLabel2, registered;

	public VueCA() {
		
		//Label 
		userLabel = new JLabel("Nom du parc :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Carré d'insertion
		userText = new JTextField(20);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);
		
		//Bouton
		selectButton = new JButton("Obtenir le CA");
		selectButton.setBounds(30, 80, 150, 25);
		this.add(selectButton);
		
		selectButton.addActionListener(this);
		
		setVisible(true);
		
	}
	
	//S'affiche s'il y a un chiffre d'affaire
	public void victoire(int CA) {
		registered = new JLabel("Chiffre d'affaire" + CA);
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}
	
	//S'affiche si il n'y a pas de CA
	public void loupe() {
		registered = new JLabel("Aucun visiteur n'a fait d'attraction dans ce Parc !");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}

	//S'execute quand l'utilisateur appuie sur le bouton
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == selectButton) {
			String nom = userText.getText();
			int chiffre = Controleur.calculerCA(nom);
			if (chiffre == 0) {
				loupe();
			}
			else {
				victoire(chiffre);
			}
			this.revalidate();
		}
	}
}