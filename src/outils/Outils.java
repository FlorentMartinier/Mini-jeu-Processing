package outils;

import modele.ElementAffiche;

/**
 * Classe contenant toutes les distances d'objets par rapport au gentil
 * 
 * @author florent
 *
 */
public class Outils {

	/**
	 * Calculer la distance entre deux éléments de la map
	 * 
	 * @param element1
	 * @param element2
	 * @return Distance entre deux éléments de la map
	 */
	public static double calculerDistanceMechant(ElementAffiche element1, ElementAffiche element2) {
		return Math.sqrt((element2.getX() - element1.getX()) * (element2.getX() - element1.getX())
				+ (element2.getY() - element1.getY()) * (element2.getY() - element1.getY()));
	}
}
