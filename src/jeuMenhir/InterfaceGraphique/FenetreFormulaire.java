package jeuMenhir.InterfaceGraphique;
import jeuMenhir.jeu.Joueur;
import jeuMenhir.jeu.JoueurOrdinateur;
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
        if(this.p.getNombreJoueurHumain() == 0){
            for(int i = 0 ; i<this.p.getNombreJoueurRobot(); i++){
                joueurs.add(new JoueurOrdinateur(i));
            } FenetreJeu fenJeu = new FenetreJeu();
            PanelJeu panJeu = new PanelJeu(fenJeu,joueurs);
            fenJeu.setContentPane(panJeu);
            panJeu.repaint();
            fenJeu.repaint();
            Partie partie = new Partie(this.estPartieRapide,joueurs);

            partie.jouer(fenJeu);

        }else{

            FenetreJoueur fenetreJoueur = new FenetreJoueur(this.p.getNombreJoueurHumain(),this.p.getNombreJoueurRobot(),joueurs,this.estPartieRapide);
            PanelJoueurVu panelJoueurVu = new PanelJoueurVu(fenetreJoueur);
            fenetreJoueur.setContentPane(panelJoueurVu);

        }


    }
}