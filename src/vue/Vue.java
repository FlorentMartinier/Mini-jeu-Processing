package vue;

import Outils.Constantes;
import modele.Gentil;
import processing.core.PApplet;

/**
 * Classe gérant tous les affichages graphiques
 * 
 * @author florent
 */
public class Vue {

	/**
	 * Si la master ball touche notre héro, il se fait capturer ! N'oublions pas
	 * que la master ball est unique et capture à tous les coups !
	 */
	public void afficherCapturer(PApplet applet) {
		applet.background(0);
		applet.textSize(50);
		applet.fill(255, 0, 0);
		applet.text(Constantes.Capture, 170, 400);
	}

	/**
	 * Afficher la vie du gentil
	 */
	public void afficherVie(Gentil gentil, PApplet applet) {
		applet.fill(0);
		applet.rect(21, 21, 196, 17);
		applet.fill(255, 0, 0);
		applet.rect(22, 22, gentil.getVie(), 15);
		applet.fill(0);
		applet.textSize(20);
		applet.text(Constantes.Sante, 20, 20);
	}

	/**
	 * Affiche le message de fin du jeu
	 */
	public void afficherGameOver(PApplet applet) {
		applet.background(0);
		applet.textSize(100);
		applet.fill(255, 0, 0);
		applet.text(Constantes.GameOver, 150, 400);
	}

	/**
	 * Afficher les informations concernant les interactions clavier et souris à
	 * l'utilisateur.
	 * 
	 * @param applet
	 */
	public void afficherInformations(PApplet applet) {
		applet.fill(0);
		applet.text(Constantes.ClicEnnemie, 680, 20);
		applet.text(Constantes.ClicNourriture, 659, 40);
		applet.text(Constantes.ClicSurprise, 670, 60);
	}

	/**
	 * Afficher le fond de la map
	 * 
	 * @param applet
	 *            instance de l'application sur laquelle afficher les décors
	 */
	public void afficherDecors(PApplet applet) {
		applet.background(255);
	}
}
