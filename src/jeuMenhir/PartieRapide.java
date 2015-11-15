package jeuMenhir;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by morgane on 07/11/15.
 */
public class PartieRapide {
    private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
    private int saison;
    private String[] tablSaison = {"hiver", "printemps", "ete","automne"};


    public PartieRapide(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public void jouer(){
        saison = 0;
        this.trouverJoueurCommencant();
    }

    private Joueur trouverJoueurCommencant(){
        int agePersonne=0;
        Joueur jQuiCommence = new Joueur();
        Iterator<Joueur> iter = this.joueurs.iterator();
        while (iter.hasNext()) {
            Joueur joueurDeListe = iter.next();
            if(joueurDeListe instanceof JoueurReel){
                JoueurReel jReel= (JoueurReel)joueurDeListe;
                if(agePersonne == 0){
                    agePersonne = jReel.getAge();
                    jQuiCommence = jReel;
                }else {
                    if(agePersonne > jReel.getAge()){
                        agePersonne = jReel.getAge();
                        jQuiCommence = jReel;
                    }else if(agePersonne == jReel.getAge()){
                        if(jReel.isEstFemme()){
                            jQuiCommence = jReel;
                        }
                    }
                }
            }

        }
        return jQuiCommence;
    }
}
