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
                if(joueurDeListe instanceof JoueurReel){
                    System.out.println("Le joueur " + joueurDeListe.nom + " joue dans la saison : " + saison);
                    joueurDeListe.getMain().afficherCartes();
                    System.out.println("Entrer le numero de votre choix : ");
                    //Attention verifier si c'est un entier
                    int numChoixCarte = sc.nextInt();
                    System.out.println("La carte selectionne est : " +  joueurDeListe.getMain().afficherUneCarte(numChoixCarte - 1));

                    CarteIngredient carteSelectionne = (CarteIngredient) joueurDeListe.getMain().getCarte(numChoixCarte - 1);


                    System.out.println("Les classes proposés sont : 1- Geant 2-Farfadet 3-Engrais ");
                    System.out.println("Entrer le numero de classe que vous avez choisi : ");
                    //Attention verifier si c'est un entier
                    int numChoixClasse = sc.nextInt();
                    if(numChoixClasse == 1){
                        carteSelectionne.getGeant().donnerGraine(joueurDeListe,saison);
                    }
                    if(numChoixClasse == 2){
                        for(int i = 0 ; i < joueurs.size() ; i++){
                            System.out.println(i + " : " + joueurs.get(i).getNom() + " Nb Graine = " + joueurs.get(i).getNbGrain()  );
                        }
                        System.out.println("Entrer le numero de la personne que vous voulez voler : ");
                        //Attention verifier si c'est un entier
                        int numVole = sc.nextInt();
                        carteSelectionne.getFarfadet().volerGraine(joueurDeListe,joueurs.get(numVole),saison);
                    }
                    if(numChoixClasse == 3){
                        carteSelectionne.getEngrais().pousserGraine(joueurDeListe,saison);
                    }
                    joueurDeListe.getMain().prendreCarteChoisi(carteSelectionne);
                }else{
                    JoueurOrdinateur joueurOrdi = (JoueurOrdinateur)joueurDeListe;

                    System.out.println("ici le joueur robot joue");
                }

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
