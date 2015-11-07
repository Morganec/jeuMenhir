package jeuMenhir;

import java.util.ArrayList;

/**
 * Created by morgane on 07/11/15.
 */
public class Partie {
    private ArrayList<Joueur> joueurs;
    private boolean estPartieRapide;
    public Partie(int nbrJoueurReel, int nbrJoueurOrdi, boolean partieRapide){
       this.remplirTableau(nbrJoueurReel,nbrJoueurOrdi);
    }

    public void remplirTableau(int nbrJoueurReel, int nbrJoueurOrdi){
        for(int i = 0 ; i<nbrJoueurReel ; i++){
            joueurs.add(new JoueurReel());
        }
        for(int i = 0 ; i<nbrJoueurOrdi; i++){
            joueurs.add(new JoueurOrdinateur());
        }
    }

    public void lancerPartieRapide(){

    }

}
