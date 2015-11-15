package jeuMenhir;

import java.util.Scanner;

/**
 * Created by morgane on 07/11/15.
 */
public class JoueurReel extends Joueur{


    private int age;



    private boolean estFemme;
    private String nom;
    private Scanner sc = new Scanner(System.in);
    public JoueurReel(){
        creerNouveauJoueur();
    }

    private void creerNouveauJoueur() {
        System.out.println("Entrer l'age d'un des joueurs réèls : ");
        //Attention verifier si c'est un entier
        this.age = sc.nextInt();
        System.out.println("Puis entrer son nom : ");
        //Attention verifier si c'est un entier
        this.nom = sc.next();
        System.out.println("Enfin taper 1 si c'est une femme et 0 si c'est un homme");
        //Attention verifier si c'est un entier
       int entierSexe = sc.nextInt();
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

    public int getAge() {
        return age;
    }

    public boolean isEstFemme() {
        return estFemme;
    }
}
