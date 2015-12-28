package jeuMenhir.jeu;

public class TaupeGeante extends CarteAllie {
	private int[] tableauForce;
	public TaupeGeante (int a0, int a1, int a2, int a3)
	{
		tableauForce = new int[4];
		tableauForce[0] = a0;
		tableauForce[1] = a1;
		tableauForce[2] = a2;
		tableauForce[3] = a3;
	}
	
	public void detruireMenhir(Joueur jdetruit, int saison)	//modification nbmenhir --> supprimer menhirs
	{
		int p = this.getValeurForce(saison);	//p: nb de menhirs du joueur
		int m = jdetruit.getNbMenhir();			//m: nombre de menhirs � d�truire
		int nb = m - p;							//nb: nouveau nombre de menhir
		jdetruit.setNbMenhir(nb);				// set nouveau nombre de menhir
		System.out.println("le joueur " + jdetruit.getNom() + "avait " + m + " menhirs et il en a maintenant : " + nb);
	}
	
	private int getValeurForce(int saison)	//int saison[0=hiver, 1=printemps, 2=ete, 3=automne]
	{
		int valeurForce = 0;
		switch (saison)
		{
		case 0:
			valeurForce = tableauForce[0];
			break;
		case 1:
			valeurForce = tableauForce[1];
			break;
		case 2:
			valeurForce = tableauForce[2];
			break;
		case 3:
			valeurForce = tableauForce[3];
			break;
		}
		return valeurForce;
	}

	public String toString(){
		return "Carte Allie taupe geante : " + tableauForce[0] + ";" + tableauForce[1] + ";" + tableauForce[2] + ";" + tableauForce[3] + " . ";
	}
}
