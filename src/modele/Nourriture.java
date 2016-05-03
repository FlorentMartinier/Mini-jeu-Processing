package modele;

public class Nourriture extends ElementAffiche {

	private static final long serialVersionUID = 6262583263497942923L;
	 
	/* Existence de la nourriture */
	private boolean isExistent;

	public Nourriture(int x, int y, boolean isExistent) {
		super(x, y);
		this.isExistent = isExistent;
	}
	
	public boolean isExistent() {
		return isExistent;
	}

	public void setExistent(boolean isExistent) {
		this.isExistent = isExistent;
	}
}
