package jeuMenhir;

import java.util.ArrayList;

/**
 * Created by morgane on 07/11/15.
 */
public class Partie {
    private ArrayList<Joueur> joueurs;
    private boolean estPartieRapide;
    private int saison;
    private PartieRapide partieRapEnCours;
    private PaquetCarte paquetJeu;
    public Partie(int nbrJoueurReel, int nbrJoueurOrdi, boolean partieRapide){
       this.remplirTableau(nbrJoueurReel,nbrJoueurOrdi);
        this.estPartieRapide = partieRapide;
    }

    public void remplirTableau(int nbrJoueurReel, int nbrJoueurOrdi){
       joueurs = new ArrayList<Joueur>();
        for(int i = 0 ; i<nbrJoueurReel ; i++){
            joueurs.add(new JoueurReel());
        }
        for(int i = 0 ; i<nbrJoueurOrdi; i++){
            joueurs.add(new JoueurOrdinateur(i));
        }
        this.creerPaquetJeu();
        this.distribuerCarte();
        this.lancerPartieRapide();
    }
    public void distribuerCarte(){
        int i = 0;
        while(!paquetJeu.estVide()){
            joueurs.get(i).getMain().ajouterCarte(paquetJeu.prendreCarteDessus());
            if(i< joueurs.size() - 1){
                i++;
            }else{
                i = 0;
            }
        }

    }
    public void creerPaquetJeu(){
     paquetJeu = new PaquetCarte();
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
    }
    public void lancerPartieRapide(){
            this.partieRapEnCours = new PartieRapide(this.joueurs);
    }

}
