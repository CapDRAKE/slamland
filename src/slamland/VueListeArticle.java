package slamland;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueListeArticle extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTable listeArticles;
	private int i;
	private JScrollPane scrollpane;

	public VueListeArticle(ArrayList <article> articles) {

		Object [][] lesArticles = new Object[20][2];
		String[] entetes = {"Nom", "Prix"};
		
		int i=0;
		while( i < articles.size()) {
			lesArticles[i][0] = articles.get(i).getNom();
			lesArticles[i][1] = articles.get(i).getPrix() + " €";
			i++;
		}
		listeArticles = new JTable(lesArticles, entetes);
		scrollpane = new JScrollPane(listeArticles);
		
		this.add(scrollpane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}