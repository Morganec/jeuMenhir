package jeuMenhir;

/**
 * Created by morgane on 07/11/15.
 */
public class StrategieOffensive implements Strategie {
    private Joueur j;
    public StrategieOffensive(JoueurOrdinateur j) {
        this.j = j;
        j.setNumCarteAllie(1); // 1= Taupe 2 = chien
    }

    // On a 1 = geant , 2 = farfadet , 3 = Engrais
    @Override
    public int getClasse() {
        if(j.getNbGrain() > 4){
            return  3;
        }else return 2;
    }
}
