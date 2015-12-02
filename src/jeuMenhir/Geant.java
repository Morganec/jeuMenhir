package jeuMenhir;

public class Geant {
	private int[] tableauForce;
	public Geant (int a0, int a1, int a2, int a3)
	{
		tableauForce = new int[4];
		tableauForce[0] = a0;
		tableauForce[1] = a1;
		tableauForce[2] = a2;
		tableauForce[3] = a3;
	}
	
	public void donnerGraine(Joueur j,int saison)	//selon puissance ajout nb graine
	{

		int p = this.getValeurForce(saison);//puissance de la carte, nombre de graines � ajouter
		System.out.println(j.getNom() + " gagne  " + p + " graines ! ");
		int nb = j.getNbGrain() + p;				//nouveau nombre de graines
		j.setNbGrain(nb);							//set nouveau nombre de graines
		
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
		return "GEANT :" + tableauForce[0] + ";" + tableauForce[1] + "+;" + tableauForce[2] + ";" + tableauForce[3] + " . ";
	}
	public void faireAction(Joueur j,int saison){
		this.donnerGraine(j,saison);
	}
}
