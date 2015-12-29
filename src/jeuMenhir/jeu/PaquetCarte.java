package jeuMenhir.jeu;
 
import java.util.ArrayList;
import java.util.Iterator;

public class PaquetCarte {


	private ArrayList <Carte> paquetCarte;	//Cr�ation Paquet de Cartes

	public PaquetCarte() {
		this.paquetCarte = new ArrayList<Carte>();
	}
	//Ajouter Carte dans PaquetCarte

	
	//Ajouter Carte dans PaquetCarte
	//fonction ajouter carte
	public boolean ajouterCarte (Carte c)
	{
		if (paquetCarte.add(c))
		{
			return true;
		}return false;
	}
	
	//melanger carte
	public void melangerCarte ()
	{/*
		int taille = paquetCarte.size();
		while(taille != 0){
			double aleatoire = Math.random() * (taille - 1);
			int a = (int) Math.round(aleatoire);
			PaquetCarte pc = new PaquetCarte();
			pc.paquetCarte.add(this.getCarte(a));
			taille--;
		}*/
	}
	//

	public boolean estVide(){
		return this.paquetCarte.isEmpty();
	}

	public Carte prendreCarteDessus(){

		return this.paquetCarte.remove(0);
	}

	public Carte prendreCarteChoisi(Carte c){

		return this.paquetCarte.remove(this.paquetCarte.indexOf(c));
	}

	public void afficherCartes(){
		Iterator<Carte> iter = this.paquetCarte.iterator();
		int i = 1;
		while (iter.hasNext()) {
		System.out.println(" Choix " +i + " : " + iter.next().toString());
			i++;

		}
	}
	public Carte getCarte(int index){
		return paquetCarte.get(index);
	}

	public String afficherUneCarte(int index){
		return paquetCarte.get(index).toString();
	}

	public int size(){
		return paquetCarte.size();
	}
	
}
