package modele;

public class Nourriture extends ElementAffiche {

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
