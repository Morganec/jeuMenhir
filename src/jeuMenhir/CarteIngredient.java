package jeuMenhir;

public class CarteIngredient extends Carte{

private Geant geant;
	private Engrais engrais;
	private Farfadet farfadet;


	public CarteIngredient(Geant geant, Farfadet farfadet, Engrais engrais) {
		this.geant = geant;
		this.farfadet = farfadet;
		this.engrais = engrais;
	}
	public String toString(){
		return " on a geant = " + geant.toString() + " farfadet = " + farfadet.toString() + "engrais = " + engrais.toString() + " . ";
	}
}
