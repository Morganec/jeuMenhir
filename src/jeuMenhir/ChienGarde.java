package jeuMenhir;

public class ChienGarde extends CarteAllie{
	private int[] tableauForce;
	public ChienGarde (int a0, int a1, int a2, int a3)
	{
		tableauForce = new int[4];
		tableauForce[0] = a0;
		tableauForce[1] = a1;
		tableauForce[2] = a2;
		tableauForce[3] = a3;
	}

	
	public void contrerFarfadet(Joueur j, int saison)	//pr�server nb graines (modification: grainespreserv�es-grainesvol�es)

	{
		int p = this.getValeurForce(saison);	//nombre de graines � prot�ger du farfadet
		j.setNbProtege(p); 						//set le nombre de graines � prot�ger
		System.out.println("le joueur " + j.getNom() + " protege maintenant pour cette partie : " + p + " graines");
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
		return "Carte Allie chien de Garde : " + tableauForce[0] + ";" + tableauForce[1] + ";" + tableauForce[2] + ";" + tableauForce[3] + " . ";
	}
}
