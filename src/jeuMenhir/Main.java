package jeuMenhir;

import java.util.Scanner;

/**
 * Created by morgane on 07/11/15.
 */
public class Main{		//variables pour menhir et graine dans le main ou dans cartes????
        public static void main (String[] args){
            Integer nbrJoueur, nbrJoueurOrdi, typePartie, nbrJoueurReel ;
            boolean estPartieRapide ;
            Partie partie;
            Scanner sc = new Scanner(System.in);

            System.out.println("Nombre de joueur participant ? :");
            //Attention verifier ici que le nbr de j est < 8
            nbrJoueur = sc.nextInt();
            System.out.println("Vous avez saisi : " + nbrJoueur);
            // ici on utilise la classe Joueur pour creer le nombre de joueur demandé
            System.out.println("Combien de joueur ordinateur? ");
            //Attention verifier ici que le nbr de joueur ordi est < nbr5Joueur - 1 !
            nbrJoueurOrdi = sc.nextInt();
            nbrJoueurReel = nbrJoueur-nbrJoueurOrdi;
            System.out.println("Cette parti aura donc : " + nbrJoueurOrdi + "joueur ordinateur et " + nbrJoueurReel + " joueur reel ");
            //Ici on déclare avec les classe ordi et joueurReel quel joueur est quoi
            System.out.println("Vous aller maintenant entrer les informations des joueurs Reel");

            System.out.println("Partie Rapide ou complexe ? ");
            System.out.println("taper 1 pour partie Rapide ");
            System.out.println("taper 2 pour partie Complexe ");
            typePartie = sc.nextInt();

            if(typePartie == 1){
               estPartieRapide = true;
            }else{
               estPartieRapide = false;
            }
            partie = new Partie(nbrJoueurReel,nbrJoueurOrdi, estPartieRapide);


        }
}
