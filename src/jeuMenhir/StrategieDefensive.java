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
    public int getClasse(boolean possedeAllie) {




        if(possedeAllie){
            if(j.getNbGrain() > 6){
                return  3;
            }else {
                if(j.getCarteAllie() instanceof ChienGarde){
                    return 4;
                }else{
                    return 3;
                }

            }
        }else{
            if(j.getNbGrain() > 4){
                return  3;
            }else return 1;
        }
    }

}
