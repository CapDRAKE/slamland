package slamland;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueConnexion extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText;
	private JButton loginButton;
	private JLabel userLabel, passwordLabel, connected, notConnected;
	private JPasswordField passwordText;
	private Window window;

	public VueConnexion() {

		userLabel = new JLabel("Login");
		userLabel.setBounds(25, 10, 80, 25);
		this.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);

		passwordLabel = new JLabel("Mot de passe");
		passwordLabel.setBounds(25, 40, 80, 25);
		this.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(110, 40, 160, 25);
		this.add(passwordText);
		
		loginButton = new JButton("Se connecter");
		loginButton.setBounds(30, 80, 150, 25);
		this.add(loginButton);
		
		loginButton.addActionListener(this);
		
		setVisible(true);

	}

	public void connected() {
		Window.resultat = Window.resultat +1;
		window = new Window();
    	JOptionPane.showMessageDialog(null, "Connexion réussie");
		this.revalidate();
		this.repaint();
		setVisible(false);
	}

	public void notConnected() {
		notConnected = new JLabel("Compte inconnu");
		notConnected.setBounds(10, 80, 150, 25);
		this.add(notConnected);
		revalidate();
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == loginButton) {
			String login = userText.getText();
			String mdp = passwordText.getText();
			if (Controleur.connexion(login, mdp)) {
				connected();
			} else {
				notConnected();
			}
		}
	}
}