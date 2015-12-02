package jeuMenhir;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/**
 * Created by morgane on 07/11/15.
 */
public class PartieRapide {
    private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
    private int saison;
    private String[] tablSaison = {"hiver", "printemps", "ete","automne"};
    private Joueur joueurQuijoue;

    private Scanner sc = new Scanner(System.in);
    public PartieRapide(ArrayList<Joueur> joueurs) {

        this.joueurs = joueurs;
        this.jouer();
    }

    public void jouer(){
        saison = 0;

        joueurQuijoue = this.trouverJoueurCommencant();
        this.joueurs.remove(joueurQuijoue);
        this.joueurs.add(0,joueurQuijoue);
        int numChoixCarte;
        int numChoixClasse;
        CarteIngredient carteSelectionne;
        Iterator<Joueur> iter = this.joueurs.iterator();
        while (iter.hasNext()) {
            Joueur joueur= iter.next();
            joueur.setNbGrain(2);
        }
            while (saison<4){
            System.out.println("La saison actuelle est : " + tablSaison[saison]);
            Iterator<Joueur> iter2 = this.joueurs.iterator();
            while (iter2.hasNext()) {

                Joueur joueurDeListe = iter2.next();
                System.out.println("Le joueur " + joueurDeListe.nom + " joue dans la saison : " + saison);
                if(joueurDeListe instanceof JoueurReel){
                    joueurDeListe.getMain().afficherCartes();
                    System.out.println("Entrer le numero de votre choix : ");
                    //Attention verifier si c'est un entier
                    numChoixCarte = sc.nextInt();
                    System.out.println("La carte selectionne est : " +  joueurDeListe.getMain().afficherUneCarte(numChoixCarte - 1));
                    carteSelectionne = (CarteIngredient) joueurDeListe.getMain().getCarte(numChoixCarte - 1);


                    System.out.println("Les classes proposés sont : 1- Geant 2-Farfadet 3-Engrais ");
                    System.out.println("Entrer le numero de classe que vous avez choisi : ");
                    //Attention verifier si c'est un entier
                    numChoixClasse = sc.nextInt();

                }else{

                    carteSelectionne = (CarteIngredient) joueurDeListe.getMain().getCarte(0); // je joueur ordinateur prends toujours la premiere carte de sa main
                   JoueurOrdinateur joueurOrdi = (JoueurOrdinateur)joueurDeListe;
                    numChoixClasse = joueurOrdi.getStrategie().getClasse();

                    //System.out.println("ici le joueur robot joue");
                }


                if(numChoixClasse == 1){
                    carteSelectionne.getGeant().donnerGraine(joueurDeListe,saison);
                }
                if(numChoixClasse == 2){
                    int numVole;
                    if(joueurDeListe instanceof JoueurReel){
                        for(int i = 0 ; i < joueurs.size() ; i++){
                            System.out.println(i + " : " + joueurs.get(i).getNom() + " Nb Graine = " + joueurs.get(i).getNbGrain()  );
                        }
                        System.out.println("Entrer le numero de la personne que vous voulez voler : ");
                        //Attention verifier si c'est un entier
                        numVole = sc.nextInt();

                    }else{
                        numVole = this.joueurs.indexOf(joueurDeListe);
                        while(numVole == this.joueurs.indexOf(joueurDeListe)){
                                numVole =(int) (Math.random() * joueurs.size());
                            System.out.println(numVole);
                        }

                    }
                    carteSelectionne.getFarfadet().volerGraine(joueurDeListe,joueurs.get(numVole),saison);
                }
                if(numChoixClasse == 3){
                    carteSelectionne.getEngrais().pousserGraine(joueurDeListe,saison);
                }
                joueurDeListe.getMain().prendreCarteChoisi(carteSelectionne);


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
