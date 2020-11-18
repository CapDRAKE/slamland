package slamland;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueAjouterParc extends JPanel implements ActionListener {
	/**
	 @author ramse
	 vue pour ajouter un parc
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText, userText2;
	private JButton selectButton;
	private JLabel userLabel, userLabel2, registered;

	public VueAjouterParc() {
		
		//Dénomination
		userLabel = new JLabel("La ville :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Insertion
		userText = new JTextField(20);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);
		
		//Dénomination
		userLabel = new JLabel("Nom du parc :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		//Insertion
		userText2 = new JTextField(20);
		userText2.setBounds(110, 10, 160, 25);
		this.add(userText2);
		
		//Bouton
		selectButton = new JButton("Ajouter");
		selectButton.setBounds(30, 80, 150, 25);
		this.add(selectButton);
		
		selectButton.addActionListener(this);
		
		setVisible(true);
		
	}
	
	//S'affiche si l'ajout du parc a été effectué 
	public void victoire() {
		registered = new JLabel("Ajout réussi");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == selectButton) {
			String ville = userText.getText();
			String nom = userText2.getText();
			if (Controleur.ajouterParc(nom, ville)) {
				victoire();
			}
			this.revalidate();
		}
	}
}