package slamland;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueAjouterVisiteurs extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText, userText2;
	private JButton selectButton;
	private JLabel userLabel, userLabel2, registered;

	public VueAjouterVisiteurs() {

		userLabel = new JLabel("Nom du visiteur:");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);
		
		userLabel = new JLabel("Prenom du visiteur :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		userText2 = new JTextField(20);
		userText2.setBounds(110, 10, 160, 25);
		this.add(userText2);
		
		selectButton = new JButton("Ajouter");
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
			String ville = userText.getText();
			String nom = userText2.getText();
			if (Controleur.ajouterParc(nom, ville)) {
				victoire();
			}
			this.revalidate();
		}
	}
}