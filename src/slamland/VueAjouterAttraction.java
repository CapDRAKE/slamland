package slamland;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueAjouterAttraction extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText, userText2, userText3, userText4, userText5;
	private JButton selectButton;
	private JLabel userLabel, userLabel2, userLabel3, userLabel4, userLabel5, registered;

	public VueAjouterAttraction() {

		userLabel = new JLabel("Nom de l'attraction");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);
		
		userLabel2 = new JLabel("Sa capacité maximale:");
		userLabel2.setBounds(29, 100, 80, 25);
		this.add(userLabel2);
		
		userText2 = new JTextField(20);
		userText2.setBounds(110, 10, 160, 25);
		this.add(userText2);
		
		userLabel3 = new JLabel("Durée de l'attraction :");
		userLabel3.setBounds(29, 100, 80, 25);
		this.add(userLabel3);
		
		userText3 = new JTextField(20);
		userText3.setBounds(110, 10, 160, 25);
		this.add(userText3);
		
		userLabel4 = new JLabel("Prix de l'attraction :");
		userLabel4.setBounds(29, 100, 80, 25);
		this.add(userLabel4);
		
		userText4 = new JTextField(20);
		userText4.setBounds(110, 10, 160, 25);
		this.add(userText4);
		
		selectButton = new JButton("Ajouter l'attraction");
		selectButton.setBounds(30, 80, 150, 25);
		this.add(selectButton);
		
		selectButton.addActionListener(this);
		
		setVisible(true);
		
	}
	
	public void victoire() {
		registered = new JLabel("Inscription réussie");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == selectButton) {
			String nom = userText.getText();
			String capacite = userText2.getText();
			//if (Controleur.ajouterAttraction(nom, capacite, duree, prix)) {
			//	victoire();
			//}
			this.revalidate();
		}
	}
}