package slamland;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueSuppAttraction extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText, userText2, userText3;
	private JButton selectButton;
	private JLabel userLabel, userLabel2, registered;
	
	public VueSuppAttraction() {

		userLabel = new JLabel("Nom de l'attraction � supprimer:");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);
		
		selectButton = new JButton("Supprimer");
		selectButton.setBounds(30, 80, 150, 25);
		this.add(selectButton);
		
		selectButton.addActionListener(this);
		
		setVisible(true);
		
	}
	
	public void victoire() {
		registered = new JLabel("Supprim�");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}
	
	public void loupe() {
		registered = new JLabel("Introuvable");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}


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