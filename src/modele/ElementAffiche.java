package modele;

import outils.Outils;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Super classe de tous les éléments pouvant être affichés sur la map
 * 
 * @author florent
 *
 */
public class ElementAffiche {

	/** Coordonnées de l'élément */
	private int x, y;

	private PImage pImage;

	public ElementAffiche(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Initialiser l'image d'un élément
	 */
	public void initialiserImage(PApplet applet) {
		// Chargement de l'image adaptée
		if (this instanceof Gentil) {
			setImage(applet.loadImage("mrbean.gif"));
		} else if (this instanceof Mechant) {
			setImage(applet.loadImage("nosferapti.png"));
		} else if (this instanceof Ball) {
			setImage(applet.loadImage("masterball.png"));
		} else {
			setImage(applet.loadImage("273.png"));
		}
	}

	/**
	 * Déterminer si deux éléments de la map se touchent
	 * 
	 * @param autreElement
	 *            Element dont on veut savoir s'il touche l'instance actuelle
	 * @return Vrai si l'instance actuelle et l'autre élément en paramètre se
	 *         touchent
	 */
	public boolean toucher(ElementAffiche autreElement) {
		if (Outils.calculerDistanceMechant(this, autreElement) < 25) {
			return true;
		}
		return false;
	}

	/**
	 * Afficher l'image de l'élément courant
	 */
	public void afficher(PApplet applet) {
		applet.image(pImage, x, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public PImage getImage() {
		return pImage;
	}

	public void setImage(PImage image) {
		this.pImage = image;
	}
}
