package jeuMenhir;
 
import java.util.ArrayList;
import java.util.Collections;

public class PaquetCarte {

	ArrayList <Carte> paquetCarte;	//Cr�ation Paquet de Cartes

	public PaquetCarte() {
		this.paquetCarte = new ArrayList<Carte>();
	}
	//Ajouter Carte dans PaquetCarte
	
	//fonction ajouter carte
	public boolean ajouterCarte (Carte c)
	{
		if (paquetCarte.add(c))
		{
			return true;
		}
		else return false;
	}
	
	//m�langer carte
	public void melangerCarte ()
	{
		
	}
	//

	public boolean estVide(){
		return this.paquetCarte.isEmpty();
	}

	public Carte prendreCarteDessus(){

		return this.paquetCarte.remove(0);
	}
}
