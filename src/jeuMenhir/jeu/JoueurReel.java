package jeuMenhir.jeu;

import java.util.Scanner;

/**
 * Created by morgane on 07/11/15.
 */
public class JoueurReel extends Joueur{







    private Scanner sc = new Scanner(System.in);
    public JoueurReel(){
        creerNouveauJoueur();
    }

    private void creerNouveauJoueur() {
        this.age = FonctionScan.recuperEntierEntrerCla("Entrer l'age d'un des joueurs réèls : ");
        System.out.println("Puis entrer son nom : ");
        this.nom = sc.next();
        int entierSexe = FonctionScan.recuperEntierEntrerCla("Enfin taper 1 si c'est une femme et 0 si c'est un homme");
        while (!(entierSexe==1 || entierSexe ==0)){
            entierSexe= FonctionScan.recuperEntierEntrerCla("taper 1 ou 0 ( 1 si c'est une femme et 0 si c'est un homme )");
        }
        if(entierSexe == 1){
            this.estFemme = true;
        }else{
            this.estFemme = false;
        }
    }

    public JoueurReel(int a, boolean estf, String nom){
        this.age = a;
        this.estFemme = estf;
        this.nom= nom;

    }


}
