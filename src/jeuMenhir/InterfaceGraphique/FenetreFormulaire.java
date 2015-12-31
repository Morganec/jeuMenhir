package jeuMenhir.InterfaceGraphique;
import jeuMenhir.jeu.Joueur;
import jeuMenhir.jeu.JoueurReel;
import jeuMenhir.jeu.Partie;

import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by morgane on 28/12/15.
 */
public class FenetreFormulaire extends JFrame  implements ActionListener {



private JButton but1,but2;  //les boutons
    private PanelFormulaire p;
    private boolean estPartieRapide;
    private Partie partie;

    /** Constructeur de test */
    public FenetreFormulaire(boolean estPRapide) {
        this.estPartieRapide = estPRapide;
        this.getContentPane().setLayout(null);
        p = new PanelFormulaire(this);
        this.setTitle("Jeux des menhirs ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(610, 630);

        this.setLayout(null);

        this.setContentPane(p);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        FenetreJoueur fenetreJoueur = new FenetreJoueur(this.p.getNombreJoueurHumain(),joueurs);
        PanelJoueurVu panelJoueurVu = new PanelJoueurVu(fenetreJoueur);
        fenetreJoueur.setContentPane(panelJoueurVu);
        //this.partie = new Partie(this.p.getNombreJoueurHumain(),this.p.getNombreJoueurRobot(),this.estPartieRapide);

    }
}