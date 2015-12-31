package jeuMenhir.InterfaceGraphique;

import jeuMenhir.jeu.Joueur;
import jeuMenhir.jeu.JoueurReel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by morgane on 30/12/15.
 */
public class FenetreJoueur extends JFrame implements ActionListener{
    private PanelJoueurVu panelJoueurVu;



    private int nbjoueur;
    private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
    public FenetreJoueur(int nbJ,ArrayList<Joueur> j){
        this.joueurs =j;
        this.getContentPane().setLayout(null);
        //p = new PanelJeu(this,null);
        //this.panelJoueurVu = p;
        this.nbjoueur = nbJ;
        this.setTitle("Jeux des menhirs ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(610, 630);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.panelJoueurVu = (PanelJoueurVu)this.getContentPane();
        System.out.println("le prenom " + this.panelJoueurVu.getTbPrenom());
        String nom = this.panelJoueurVu.getTbPrenom();
        int age = 12;
        Boolean estF= true;
        JoueurReel jr = new JoueurReel(age,estF,nom);
        joueurs.add(jr);
        if(joueurs.size() < this.nbjoueur){
            this.dispose();
            FenetreJoueur fenetreJoueur = new FenetreJoueur(this.nbjoueur,joueurs);
            PanelJoueurVu panelJoueurVu = new PanelJoueurVu(fenetreJoueur);
            fenetreJoueur.setContentPane(panelJoueurVu);
        }else{
            this.dispose();
        }


    }
}
