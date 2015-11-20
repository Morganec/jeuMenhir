package jeuMenhir;

public class CarteIngredient extends Carte{

	Geant geant;
	Engrais engrais;
	Farfadet farfadet;


	public CarteIngredient(Geant geant, Farfadet farfadet, Engrais engrais) {
		this.geant = geant;
		this.farfadet = farfadet;
		this.engrais = engrais;
	}
}
