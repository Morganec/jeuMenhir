package jeuMenhir.jeu;

import javafx.beans.InvalidationListener;
import java.util.Observable;
import java.util.Scanner;

/**
 * Created by morgane on 07/11/15.
 */
public class Joueur extends Observable{

	protected int age;
	protected boolean estFemme;
	protected String nom;


	private CarteAllie carteAllie = null;
	private boolean possedeCarteAllie =false;
	private Scanner sc = new Scanner(System.in);

	private PaquetCarte main;
	private int nbprotege=0;
	private int nbgrain=0;
	private int nbmenhir=0;


	private int nbrMenhirEnTout = 0;
	public Joueur() {
		this.main = new PaquetCarte();
	}
	//liste saisons


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
		this.setChanged();
		this.notifyObservers();
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
		notifyObservers();
	}
	//m�thodes nombre de menhirs � prot�ger
	public int getNbProtege()
	{
		return nbprotege;
	}
	public void setNbProtege(int p)
	{
		nbprotege = p;
		this.notifyObservers();
	}


	public int getAge() {
		return age;
	}
	public String getNom() {
		return nom;
	}

	public boolean isEstFemme() {
		return estFemme;
	}



	public boolean possedeCarteAllie() {
		return possedeCarteAllie;
	}

	public void setPossedeCarteAllie(boolean possedeCarteAllie) {
		this.possedeCarteAllie = possedeCarteAllie;
		this.notifyObservers();
	}

	public PaquetCarte getMain() {
		this.notifyObservers();
		return main;

	}

	public CarteAllie getCarteAllie() {
		return carteAllie;
	}

	public void setCarteAllie(CarteAllie carteAllie) {
		this.carteAllie = carteAllie;
		this.notifyObservers();
	}


	public int getNbrMenhirEnTout() {
		return nbrMenhirEnTout;
	}

	public void setNbrMenhirEnTout(int nbrMenhirEnTout) {
		this.nbrMenhirEnTout = nbrMenhirEnTout;
		this.notifyObservers();
	}


}