package jeu;

import processing.core.PApplet;

/**
 * Classe contenant toutes les distances d'objets par rapport au gentil
 * @author florent
 *
 */
public class Outils extends PApplet{

	private static final long serialVersionUID = 3312664350180331083L;
	
	/**
	 * Calculer la distance entre un gentil et un méchant
	 * @param gentil
	 * @param mechant
	 * @return Distance entre le gentil et le méchant
	 */
	public static float calculerDistanceMechant(Gentil gentil, Mechant mechant){
		return sqrt((mechant.getX() - gentil.getX()) * (mechant.getX() - gentil.getX())
				+ (mechant.getY() - gentil.getY()) * (mechant.getY() - gentil.getY()));
	}
	
	/**
	 * Calculer la distance entre un gentil et une ball
	 * @param gentil
	 * @param mechant
	 * @return Distance entre le gentil et la ball
	 */
	public static float calculerDistanceBall(Gentil gentil, Ball ball){
		return sqrt((ball.getX() - gentil.getX()) * (ball.getX() - gentil.getX())
				+ (ball.getY() - gentil.getY()) * (ball.getY() - gentil.getY()));
	}
	
	/**
	 * Calculer la distance entre un gentil et une nourriture
	 * @param gentil
	 * @param mechant
	 * @return Distance entre le gentil et la nourriture
	 */
	public static float calculerDistanceNourriture(Gentil gentil, Nourriture nourriture){
		return sqrt((nourriture.getX() - gentil.getX()) * (nourriture.getX() - gentil.getX())
				+ (nourriture.getY() - gentil.getY()) * (nourriture.getY() - gentil.getY()));
	}
}
