package slamland;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Déclaration des pages

	private VueAjouterVisiteurs pageAjouterVisiteurs = new VueAjouterVisiteurs();
	
	private VueListeXML pageXML = new VueListeXML();
	private VueConnexion pageConnexion = new VueConnexion();
	private VueAjouterParc pageAjouterParc = new VueAjouterParc();
	private VueAjouterVisiteurs pageAjoutVisiteur = new VueAjouterVisiteurs();
	private VueSupprimerVisiteur pageSupprimerVisiteur = new VueSupprimerVisiteur();
	private VueListeMagasin pageListeMagasin = new VueListeMagasin(Controleur.getLesMagasins());
	private VueListeRestaurant pageListeRestaurant = new VueListeRestaurant(Controleur.getLesRestaurants());
	private VueListeVisiteurs pageListeVisiteurs = new VueListeVisiteurs(Controleur.getLesVisiteurs());
	private VueParc pageParc = new VueParc(Controleur.getLesParcs());
	private VueListeAttraction pageAttraction = new VueListeAttraction(Controleur.getLesAttractions());
	protected static int resultat = 0;
	private JMenuBar barre;
	private JMenu menu, menu2, menu3;
	private JMenuItem parc, parc2, attraction, attraction2, attractionxml, visiteur, ajoutVisiteur, supprimerVisiteur, restaurants, commerces, article, article1;
	private JPanel panel;
    private JMenuItem menuQuitter1 = new JMenuItem("Quitter");
	
	//Paramètres des pages
	public Window() {
		//Titre du projet
		this.setTitle("SlamLand");
		this.setResizable(false);
		//Taille de la fenêtre
		this.setSize(650,650);
		//Permet de fermer la page
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Affiche la page de connexion tant que le joueur n'est pas co
		if(resultat == 0) {
			this.setContentPane(pageConnexion);
		}
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		// permet de centrer la frame au milieu de l'écran
		
		//S'affiche dés lors que l'utilisateur s'est connecté 
		if(resultat == 1) {
			panel = new JPanel();
			//connected = new JLabel("Connexion réussie");
			//connected.setBounds(10, 80, 150, 25);
			//this.add(connected);
			
			//Menu pour les parcs
			barre = new JMenuBar();
			//Menu principal
			menu = new JMenu("Parcs");
			
			//Sous-menu
			parc = new JMenuItem("Liste des Parcs");
			parc2 = new JMenuItem("Ajouter un Parc");
			attraction = new JMenuItem("Liste des attractions");
			attractionxml = new JMenuItem("Liste des attractions format XML");
			
			//Les adds
			menu.add(parc);
			menu.add(parc2);
			menu.add(attraction);
			menu.add(attractionxml);
			
			//les actions
			parc.addActionListener(new ActionParc());
			parc2.addActionListener(new ActionAjouterParc());
			attraction.addActionListener(new ActionListeAttraction());
			attractionxml.addActionListener(new ActionListeXML());
			
			
			//Menu pour la gestion des visiteurs
			//Menu principal
			menu2 = new JMenu("Visiteurs");
			
			//Sous-menu
			visiteur = new JMenuItem("Liste des visiteurs");
			ajoutVisiteur = new JMenuItem("Ajouter des visiteurs");
			supprimerVisiteur = new JMenuItem("Supprimer des visiteurs");
			
			
			//Les adds
			menu2.add(visiteur);
			menu2.add(ajoutVisiteur);
			menu2.add(supprimerVisiteur);
			
			//Les actions
			visiteur.addActionListener(new ActionListeVisiteurs());
			ajoutVisiteur.addActionListener(new ActionAjouterVisiteurs());
			supprimerVisiteur.addActionListener(new ActionSupprimerVisiteurs());
			
			
			
			menu3 = new JMenu("Commerces");
			restaurants = new JMenuItem("Liste des restaurants");
			commerces = new JMenuItem("Liste des commerces");
			article = new JMenuItem("Liste des articles");
			article1 = new JMenuItem("Ajouter des articles");
			restaurants.addActionListener(new ActionListeRestaurant());
			commerces.addActionListener(new ActionListeMagasins());
			
			menu3.add(restaurants);
			menu3.add(commerces);
			
			menuQuitter1.addActionListener(new ActionQuitte());
			
			
			//On add les menus
			barre.add(menu);
			barre.add(menu2);
			barre.add(menu3);
			barre.add(menuQuitter1);
	
			panel = new JPanel();
			panel.add(barre);
			this.setJMenuBar(barre);

			this.getContentPane().add(panel);
		}

		//Affiche la fenêtre
		this.setVisible(true);

		}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//L'action pour afficher les parcs
	class ActionParc implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if ( e.getSource() == parc) {
				pageParc = new VueParc(Controleur.getLesParcs());
				setContentPane(pageParc);
			}
			revalidate();
		}
	}
	
	//Action pour ajouter un parc
	class ActionAjouterParc implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if ( e.getSource() == parc2) {
				pageAjouterParc = new VueAjouterParc();
				setContentPane(pageAjouterParc);
			}
			revalidate();
		}
	}
	
	//Action pour afficher les attractions
	class ActionListeAttraction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if ( e.getSource() == attraction) {
				pageAttraction = new VueListeAttraction(Controleur.getLesAttractions());
				setContentPane(pageAttraction);
			}
			revalidate();
		}
	}
	
	//Action pour afficher la lises des visiteurs
	class ActionListeVisiteurs implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if ( e.getSource() == visiteur) {
				pageListeVisiteurs = new VueListeVisiteurs(Controleur.getLesVisiteurs());
				setContentPane(pageListeVisiteurs);
			}
			revalidate();
		}
	}
	
	//Action pour ajouter un visiteur
	class ActionAjouterVisiteurs implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pageAjouterVisiteurs = new VueAjouterVisiteurs();
			setContentPane(pageAjouterVisiteurs);
			revalidate();
		}
	}
	
	//Action pour supprimer un visiteur
	class ActionSupprimerVisiteurs implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pageSupprimerVisiteur = new VueSupprimerVisiteur();
			setContentPane(pageSupprimerVisiteur);
			revalidate();
		}
	}
	
	//Action pour afficher la liste des restaurants
	class ActionListeRestaurant implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pageListeRestaurant = new VueListeRestaurant(Controleur.getLesRestaurants());
			setContentPane(pageListeRestaurant);
			revalidate();
		}
	}
	
	//Action pour afficher la liste des magasins
	class ActionListeMagasins implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pageListeMagasin = new VueListeMagasin(Controleur.getLesMagasins());
			setContentPane(pageListeMagasin);
			revalidate();
		}
	}
	
	//Action pour afficher la liste d'attraction au format XML
	class ActionListeXML implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			pageXML = new VueListeXML();
			setContentPane(pageXML);
			revalidate();
		}
	}
	
	//Action pour quitter l'application
	class ActionQuitte implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if ( e.getSource() == menuQuitter1 ) { 
            	System.exit(1);
			}
		}
	}
}