package modele;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Super classe de tous les éléments pouvant être affichés sur la map
 * 
 * @author florent
 *
 */
public class ElementAffiche extends PApplet {

	private static final long serialVersionUID = -6275132595153172302L;

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
	public void initialiserImage() {
		// Chargement de l'image adaptée
		if (this instanceof Gentil) {
			setImage(loadImage("mrbean.gif"));
		} else if (this instanceof Mechant) {
			setImage(loadImage("nosferapti.png"));
		} else {
			setImage(loadImage("masterball.png"));
		}
	}

	/**
	 * Afficher l'image de l'élément courant
	 */
	public void afficher() {
		image(pImage, x, y);
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
