package model;

public abstract class EntiteReservable {
	private CalendrierAnnuel calendrier;
	private int numId;
	
	public int getNumId() {
		return numId;
	}
	public void setNumId(int numId) {
		this.numId = numId;
	}
	
	public boolean estLibre() {
		return true;
	}
	
	public abstract boolean compatible();
	
	public abstract void reserver();
}
