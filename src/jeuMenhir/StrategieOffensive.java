package jeuMenhir;

/**
 * Created by morgane on 07/11/15.
 */
public class StrategieOffensive implements Strategie {
    private Joueur j;
    public StrategieOffensive(JoueurOrdinateur j) {
        this.j = j;

    }

    // On a 1 = geant , 2 = farfadet , 3 = Engrais 4 = allie
    @Override
    public int getClasse(boolean possedeAllie) {
        if(possedeAllie){
            if(j.getNbGrain() > 6){
                return  3;
            }else {
                if(j.getCarteAllie() instanceof TaupeGeante){
                    return 4;
                }else{
                    return 2;
                }

            }
        }else{
            if(j.getNbGrain() > 4){
                return  3;
            }else return 2;
        }

    }
}
