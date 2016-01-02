package jeuMenhir.jeu;

import jeuMenhir.InterfaceGraphique.FenetreJeu;
import jeuMenhir.InterfaceGraphique.FenetreJoueur;
import jeuMenhir.InterfaceGraphique.PanelJoueurVu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

/**
 * Created by morgane on 07/11/15.
 */
public class JoueurReel extends Joueur {

private FenetreJoueur fenetreJoueur;
    private PanelJoueurVu panelJoueurVu;
    private Scanner sc = new Scanner(System.in);
    private Integer nbrJoueurReel;




    public JoueurReel(){
        super.setImageJoueur(new File("Images/humain.png"));


        creerNouveauJoueur();

    }

    public JoueurReel(int a, boolean estf, String nom){
        super.setImageJoueur(new File("Images/humain.png"));

        this.age = a;
        this.estFemme = estf;
        this.nom= nom;

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





}
