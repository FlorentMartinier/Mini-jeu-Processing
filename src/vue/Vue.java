package vue;

import modele.Creature;
import modele.ElementAffiche;
import modele.Gentil;
import modele.Mechant;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Classe gérant tous les affichages graphiques
 * 
 * @author florent
 */
public class Vue extends PApplet {

	private static final long serialVersionUID = 1742406531380778781L;

	/**
	 * Si la master ball touche notre héro, il se fait capturer ! N'oublions pas
	 * que la master ball est unique et capture à tous les coups !
	 */
	public void capturer() {
		background(0);
		textSize(50);
		fill(255, 0, 0);
		text("vous êtes capturé !", 170, 400);
	}

	/**
	 * Afficher la vie du gentil
	 */
	public void afficherVie(Gentil gentil) {
		fill(0);
		rect(21, 21, 196, 17);
		fill(255, 0, 0);
		rect(22, 22, gentil.getVie(), 15);
		fill(0);
		textSize(20);
		text("Santé", 20, 20);
	}

	/**
	 * Affiche le message de fin du jeu
	 */
	public void gameOver() {
		background(0);
		textSize(100);
		fill(255, 0, 0);
		text("Game Over", 150, 400);
	}
	
	/**
	 * Afficher une creature sur la map
	 */
	public void afficher(ElementAffiche creature) {
		PImage image;

		// Chargement de l'image adaptée
		if (creature instanceof Gentil) {
			image = loadImage("mrbean.gif");
		} else if (creature instanceof Mechant) {
			image = loadImage("nosferapti.png");
		} else {
			image = loadImage("masterball.png");
		}

		// Affichage de l'image aux coordonnées de la créature
		image(image, creature.getX(), creature.getY());
		noStroke();
	}
	
	/**
	 * Définir les tailles de la fenêtre à afficher
	 * @param longueur Longueur de la fenêtre
	 * @param largeur Largeur de la fenêtre
	 */
	public void definirFenetre(int longueur, int largeur){
		size(longueur, largeur);
	}
}
