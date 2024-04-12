package model;

public class CalendrierAnnuel {
	
	private Mois[] moisAnnuel;
	
	public CalendrierAnnuel() {
		moisAnnuel = new Mois[12];
		
		moisAnnuel[0] = new Mois("Janvier", 31);
		moisAnnuel[1] = new Mois("Février", 28);
		moisAnnuel[2] = new Mois("Mars", 31);
		moisAnnuel[3] = new Mois("Avril", 30);
		moisAnnuel[4] = new Mois("Mai", 31);
		moisAnnuel[5] = new Mois("Juin", 30);
		moisAnnuel[6] = new Mois("Juillet", 31);
		moisAnnuel[7] = new Mois("Août", 31);
		moisAnnuel[8] = new Mois("Septembre", 30);
		moisAnnuel[9] = new Mois("Octobre", 31);
		moisAnnuel[10] = new Mois("Novembre", 30);
		moisAnnuel[11] = new Mois("Décembre", 31);
	}
	
	public boolean estLibre(int jour, int mois) {
		return this.moisAnnuel[mois-1].estLibre(jour) ;
	}
	
	public boolean reserver(int jour, int mois) {
		if (estLibre(jour, mois)) {
			moisAnnuel[mois-1].reserver(jour);
			return true;
		}
		
		return false;
	}
	
	
	/////////  CLASSE INTERNE MOIS /////////
	
	private static class Mois {
		
		private String nom;
		private boolean[] jours;
		
		public Mois(String nom, int nbJours) {
			this.nom = nom;
			jours = new boolean[nbJours];
		}
		
		public boolean estLibre(int jour) {
			return !jours[jour-1];
		}
		
		public void reserver(int jour) {
			if (estLibre(jour)) {
				jours[jour-1] = true;
			} else {
				throw new IllegalStateException("Je jour demandé est déjà réservé");
			}
		}
		
	}
}
