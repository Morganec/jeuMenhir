package jeuMenhir;

public class Engrais {
private int[] tableauForce;
	public Engrais (int a0, int a1, int a2, int a3)
	{
		tableauForce = new int[4];
		tableauForce[0] = a0;
		tableauForce[1] = a1;
		tableauForce[2] = a2;
		tableauForce[3] = a3;
	}
	
	public void pousserGraine(Joueur j, int saison)	//selon puissance supp x nb graine et ajout x nb menhir
	{
		int p = this.getValeurForce(saison);	//puissance de la carte engrais
		//diminuer le nombre de graines
		int g = j.getNbGrain() - p;
		j.setNbGrain(g);
		//augmenter le nombre de menhirs
		int m = j.getNbMenhir() + p;
		j.setNbMenhir(m);
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
