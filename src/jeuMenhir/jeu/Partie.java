package jeuMenhir.jeu;



import jeuMenhir.InterfaceGraphique.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by morgane on 07/11/15.
 */
public class Partie implements Runnable{
    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    private ArrayList<Joueur> joueurs;
    private boolean estPartieRapide;
    private int saison;
    private PartieRapide partieRapEnCours;
    private PaquetCarte paquetJeu;
    private PaquetCarte paquetAllie;



    private FenetreJeu fenJeu ;
private Thread monThread;
private  Integer nbrJoueurReel;

    private int numeroDelaManche;
    private Scanner sc = new Scanner(System.in);
    public Partie( boolean partieRapide, ArrayList<Joueur> j){
        this.nbrJoueurReel = nbrJoueurReel;
        //this.remplirTableau(nbrJoueurReel,nbrJoueurOrdi);
        this.joueurs = j;

        this.estPartieRapide = partieRapide;
        if(this.estPartieRapide){
            numeroDelaManche = 0;
        }else{
            numeroDelaManche = joueurs.size()-1;
        }

        monThread = new Thread(this);





    }

    public void jouer(FenetreJeu f){

    this.fenJeu = f;

    monThread.start();





    }
    public void remplirTableau(int nbrJoueurReel, int nbrJoueurOrdi){
       joueurs = new ArrayList<Joueur>();

        for(int i = 0 ; i<nbrJoueurReel ; i++){
          joueurs.add(new JoueurReel());
        }
        for(int i = 0 ; i<nbrJoueurOrdi; i++){
            joueurs.add(new JoueurOrdinateur(i));
        }

    }
    public void distribuerCarte(){

        int i = 0;

        while(!paquetJeu.estVide()){
            joueurs.get(i).getMain().ajouterCarte(paquetJeu.prendreCarteDessus());
            if(i< joueurs.size() - 1){
                i++;
            }else{
                if(joueurs.get(i).getMain().size() <= 4 ){
                    i = 0;
                }else{
                    break;
                }

            }
        }

    }
    public void creerPaquetJeu(){
        //PENSER A CREER UNE BOUCLE !!!
     paquetJeu = new PaquetCarte();
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,3,3,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,3,3,1),new Farfadet(1,1,0,1),new Engrais(1,0,2,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,1,0,1),new Farfadet(1,0,2,1),new Engrais(1,3,3,1))));
        paquetJeu.ajouterCarte((Carte)(new CarteIngredient(new Geant(1,0,2,1),new Farfadet(1,3,3,1),new Engrais(1,1,0,1))));

        this.paquetJeu.melangerCarte();
    }

    public void creerPaqueAllie(){
        paquetAllie = new PaquetCarte();

        paquetAllie.ajouterCarte((Carte)(new ChienGarde(1,2,3,4)));
        paquetAllie.ajouterCarte((Carte)(new ChienGarde(1,3,3,4)));
        paquetAllie.ajouterCarte((Carte)(new ChienGarde(1,2,3,1)));

        paquetAllie.ajouterCarte((Carte)(new TaupeGeante(1,2,3,4)));
        paquetAllie.ajouterCarte((Carte)(new TaupeGeante(1,3,3,4)));
        paquetAllie.ajouterCarte((Carte)(new TaupeGeante(1,1,3,4)));
        this.paquetAllie.melangerCarte();
    }
    public void lancerPartieRapide(FenetreJeu f){
            this.partieRapEnCours = new PartieRapide(this.joueurs,numeroDelaManche,estPartieRapide, f);
        f.getContentPane().repaint();
        this.numeroDelaManche = this.partieRapEnCours.jouer();

    }

    public void demanderGraineOuAllier(){
        Iterator<Joueur> iter = this.joueurs.iterator();
        int choixDujoueur;
        while (iter.hasNext()) {
            Joueur joueur= iter.next();
            if(joueur instanceof JoueurReel){
                System.out.println("joueur : " + joueur.getNom() + " tape 1 : pour obtenir deux graines et tape 2 : pour piocher une carte allie");
                //Attention verifier si c'est un entier
                choixDujoueur = sc.nextInt();
            }else{
                choixDujoueur = (int) ((Math.random()*2) + 1);
            }
            if(choixDujoueur == 1 ){
                joueur.setNbGrain(2);
                System.out.println("joueur : " + joueur.getNom() + " a obtenu 2 graines");
            }else{
                if(paquetAllie.estVide()){
                    joueur.setNbGrain(2);
                    System.out.println("joueur : " + joueur.getNom() + " a obtenu 2 graines car il n'y a plus de carte allie");
                }else{
                    joueur.setCarteAllie((CarteAllie)paquetAllie.prendreCarteDessus());
                    joueur.getMain().ajouterCarte(joueur.getCarteAllie());
                    joueur.setPossedeCarteAllie(true);
                    joueur.setNbGrain(0);

                    System.out.println("joueur : " + joueur.getNom() + " a obtenu une carte allie et sa carte est :  " + joueur.getCarteAllie().toString() );
                }

            }


        }
    }




    public int getNumeroDelaManche() {
        return numeroDelaManche;
    }

    public void setNumeroDelaManche(int numeroDelaManche) {
        this.numeroDelaManche = numeroDelaManche;
    }


    @Override
    public void run() {
        while(this.numeroDelaManche >= 0){


            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Iterator<Joueur> iter = this.joueurs.iterator();
            while (iter.hasNext()) {
                Joueur joueur = iter.next();
                joueur.setNbGrain(2);
                joueur.setNbMenhir(0);
                joueur.setPossedeCarteAllie(false);
                joueur.setNbProtege(0);
            }

            if(!this.estPartieRapide){
                this.creerPaqueAllie();
                this.demanderGraineOuAllier();
                // this.demanderGraineOuAllierGraph();

            }


            this.creerPaquetJeu();
            this.distribuerCarte();
            this.lancerPartieRapide(this.fenJeu);


            //FIN DE MANCHE
            for(int j = 0; j<joueurs.size();j++){
                joueurs.get(j).setMain(new PaquetCarte());
                joueurs.get(j).setPossedeCarteAllie(false);
                joueurs.get(j).setCarteAllie(null);
            }


        }
    }
}
