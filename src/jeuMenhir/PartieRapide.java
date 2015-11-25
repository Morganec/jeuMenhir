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
    private Joueur joueurQuijoue;


    public PartieRapide(ArrayList<Joueur> joueurs) {

        this.joueurs = joueurs;
        this.jouer();
    }

    public void jouer(){
        saison = 0;
        joueurQuijoue = this.trouverJoueurCommencant();
        this.joueurs.remove(joueurQuijoue);
        this.joueurs.add(0,joueurQuijoue);
        while (saison<4){
            System.out.println("La saison actuelle est : " + tablSaison[saison]);
            Iterator<Joueur> iter = this.joueurs.iterator();
            while (iter.hasNext()) {
                Joueur joueurDeListe = iter.next();
                joueurDeListe.jouer(saison);
            }
            saison++;
        }

        //joueurs.remove(joueurs.indexOf(joueurQuijoue));
        //joueur.paquetDeCarte.afficherMAin()
    }

    private Joueur trouverJoueurCommencant(){

        int agePersonne=0;
        Joueur jQuiCommence = new Joueur();
        Iterator<Joueur> iter = this.joueurs.iterator();
        while (iter.hasNext()) {
            Joueur joueurDeListe = iter.next();

            if(agePersonne == 0){
                agePersonne = joueurDeListe.getAge();
                jQuiCommence = joueurDeListe;
            }else {
                if(agePersonne > joueurDeListe.getAge()){
                    agePersonne = joueurDeListe.getAge();
                    jQuiCommence = joueurDeListe;
                }else if(agePersonne == joueurDeListe.getAge()){
                    if(joueurDeListe.isEstFemme()){
                        jQuiCommence = joueurDeListe;
                    }
                }

            }

        }
        System.out.println("Le joueur qui commence est : " + jQuiCommence.getNom() );
        return jQuiCommence;
    }
}
