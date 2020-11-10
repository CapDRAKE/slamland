package slamland;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueParc extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText;
	private JButton selectButton;
	private JLabel userLabel;

	public VueParc() {

		userLabel = new JLabel("Saisir ville :");
		userLabel.setBounds(29, 100, 80, 25);
		this.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);
		
		selectButton = new JButton("Selectionner");
		selectButton.setBounds(30, 80, 150, 25);
		this.add(selectButton);
		
		selectButton.addActionListener(this);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == selectButton) {
			String ville = userText.getText();
			JScrollPane scrollpane = null;
			JTable tableau = null;
			String[] entetes = {"Ville", "Nom du parc"};
			tableau = new JTable(Controleur.getLesParcs(ville), entetes);
			scrollpane = new JScrollPane(tableau);
			this.add(scrollpane);
			this.revalidate();
		}
	}
}