package jeuMenhir.jeu;

public class CarteIngredient extends Carte{

	public Geant getGeant() {
		return geant;
	}

	public Engrais getEngrais() {
		return engrais;
	}

	public Farfadet getFarfadet() {
		return farfadet;
	}

	private Geant geant;
	private Engrais engrais;
	private Farfadet farfadet;


	public CarteIngredient(Geant geant, Farfadet farfadet, Engrais engrais) {
		this.geant = geant;
		this.farfadet = farfadet;
		this.engrais = engrais;
	}
	public String toString(){
		return " on a geant = " + geant.toString() + " farfadet = " + farfadet.toString() + "engrais = " + engrais.toString() + " ";
	}



}
