package jeuMenhir;

public class Farfadet {
	
	private int[] tableauForce;
	public Farfadet (int a0, int a1, int a2, int a3)
	{
		tableauForce[0] = a0;
		tableauForce[1] = a1;
		tableauForce[2] = a2;
		tableauForce[3] = a3;
	}
	//méthode qui supprime un nombre f de graine au joueur volé, et ajoute f graines au joueur voleur
	public void volerGraine(Joueur jvoleur, Joueur jvole, int saison)	
	{
		int f = this.getValeurForce(saison);	//nombre de graines à volées
		int p = jvole.getNbProtege();			//nombre de graines à protégées
		int d = f - p;							//nombre de graines à volées - nombre de graines à protégées
		if (d > 0)
		{
			int nbvole = jvole.getNbGrain() - d;		//nombre de graine
			int nbvoleur = jvoleur.getNbGrain() + d;
			jvole.setNbGrain(nbvole);
			jvoleur.setNbGrain(nbvoleur);
		}
		jvole.setNbGrain(0);
	}
	
	public int getValeurForce(int saison)
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
}
