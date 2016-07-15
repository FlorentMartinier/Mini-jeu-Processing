package modele;

import Outils.Constantes;
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
	public void initialiserImageElement(PApplet applet) {

		// Chargement de l'image adaptée
		if (this instanceof Gentil) {
			setImage(applet.loadImage(Constantes.ImageGentil));
		} else if (this instanceof Mechant) {
			setImage(applet.loadImage(Constantes.ImageMechant));
		} else if (this instanceof Ball) {
			setImage(applet.loadImage(Constantes.ImageBall));
		} else {
			setImage(applet.loadImage(Constantes.ImageNourriture));
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
	public boolean toucherElement(ElementAffiche autreElement) {
		if (calculerDistanceElements(this, autreElement) < 25) {
			return true;
		}
		return false;
	}

	/**
	 * Calculer la distance entre deux éléments de la map
	 * 
	 * @param element1
	 * @param element2
	 * @return Distance entre deux éléments de la map
	 */
	public static double calculerDistanceElements(ElementAffiche element1, ElementAffiche element2) {

		// Coordonnées de l'élément 1
		int x1 = element1.getX();
		int y1 = element1.getY();

		// Coordonnées de l'élément 2
		int x2 = element2.getX();
		int y2 = element2.getY();

		// Calcul de distance entre deux positions
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
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
