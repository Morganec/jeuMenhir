package jeuMenhir;

/**
 * Created by morgane on 07/11/15.
 */
public class Joueur {
	


	public PaquetCarte main;

	public Joueur() {
		this.main = new PaquetCarte();
	}
	//liste saisons

	private int nbprotege;
	private int nbgrain;		
	private int nbmenhir;
	//m�thodes nombre de grains
	public int getNbGrain()
	{
		return nbgrain;
	}
	public void setNbGrain(int nb)	//nb: nouveau nombre de graines
	{
		if(nb<0)
		{
			nbgrain = 0;
		}
		else
		{
			nbgrain =  nb;
		}
	}
	//m�thodes nombre de menhir
	public int getNbMenhir()
	{
		return nbmenhir;
	}
	public void setNbMenhir(int nb)	//nb: nouveau nombre de menhirs
	{
		if(nb<0)
		{
			nbmenhir = 0;
		}
		else
		{
			nbmenhir =  nb;
		}
	}
	//m�thodes nombre de menhirs � prot�ger
	public int getNbProtege()
	{
		return nbprotege;
	}
	public void setNbProtege(int p)
	{
		nbprotege = p;
	}

}
