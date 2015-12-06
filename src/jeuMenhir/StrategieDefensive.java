package jeuMenhir;

/**
 * Created by morgane on 07/11/15.
 */
public class StrategieDefensive implements Strategie {
    private Joueur j;
    public StrategieDefensive(JoueurOrdinateur j) {
        this.j = j;

    }

    // On a 1 = geant , 2 = farfadet , 3 = Engrais
    @Override
    public int getClasse(Carte carteSelectionne) {
        if(carteSelectionne instanceof CarteAllie){

                    return 4;

        }else{
            if(j.getNbGrain() > 3){
                return  3;
            }else return 1;
        }
    }

}
