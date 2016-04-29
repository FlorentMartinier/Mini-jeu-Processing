package outils;

import modele.Creature;
import processing.core.PApplet;

/**
 * Classe contenant toutes les distances d'objets par rapport au gentil
 * @author florent
 *
 */
public class Outils extends PApplet{

	private static final long serialVersionUID = 3312664350180331083L;
	
	/**
	 * Calculer la distance entre deux creatures
	 * @param creature1
	 * @param creature2
	 * @return Distance entre le gentil et le méchant
	 */
	public static float calculerDistanceMechant(Creature creature1, Creature creature2){
		return sqrt((creature2.getX() - creature1.getX()) * (creature2.getX() - creature1.getX())
				+ (creature2.getY() - creature1.getY()) * (creature2.getY() - creature1.getY()));
	}	
}
