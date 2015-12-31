package jeuMenhir.jeu;

import jeuMenhir.InterfaceGraphique.FenetreJeu;
import jeuMenhir.InterfaceGraphique.FenetreJoueur;
import jeuMenhir.InterfaceGraphique.PanelJoueurVu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Created by morgane on 07/11/15.
 */
public class JoueurReel extends Joueur implements ActionListener{

private FenetreJoueur fenetreJoueur;
    private PanelJoueurVu panelJoueurVu;
    private Scanner sc = new Scanner(System.in);
    private boolean monBooleen;
    private Integer nbrJoueurReel;
    public JoueurReel(Integer nbrJReel){
        this.nbrJoueurReel = nbrJReel;
        this.monBooleen = true;
     this.fenetreJoueur = new FenetreJoueur();
        this.panelJoueurVu = new PanelJoueurVu(this,this.fenetreJoueur);

      this.fenetreJoueur.setContentPane(this.panelJoueurVu);
        creerNouveauJoueur();

    }

    private void creerNouveauJoueur() {
       /* this.age = FonctionScan.recuperEntierEntrerCla("Entrer l'age d'un des joueurs réèls : ");
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
*/




        this.nom="much";
        this.age=12;
        this.estFemme = true;

    }

    public JoueurReel(int a, boolean estf, String nom){
        this.age = a;
        this.estFemme = estf;
        this.nom= nom;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
       // this.nbrJoueurReel.notify();
        //this.age = this.panelJoueurVu.getTbPrenom();

    }


}
