package jeuMenhir;

public class CarteChamps {

	private int nbmenhir;
	
	public int getMenhir()				//retourne le nombre de menhirs
	{
		return nbmenhir;
	}
	
	public void setMenhir(int nb)		//ajoute ou supprime le nombre de menhirs
	{
		nbmenhir = nbmenhir + nb;
	}
}
