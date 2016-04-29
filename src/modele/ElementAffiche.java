package modele;

import vue.Vue;

/** 
 * Super classe de tous les éléments pouvant être affichés sur la map
 * @author florent
 *
 */
public class ElementAffiche {
	
	/** Coordonnées de l'élément */
	private int x, y;
	
	public ElementAffiche(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	/**
	 * Afficher l'élément sur la map
	 * @param vue Vue sur laquelle afficher la créature
	 */
	public void afficher (Vue vue){
		vue.afficher(this);
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
}
