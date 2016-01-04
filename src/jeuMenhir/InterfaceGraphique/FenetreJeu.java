package jeuMenhir.InterfaceGraphique;

import jeuMenhir.jeu.Joueur;
import jeuMenhir.jeu.Partie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by morgane on 29/12/15.
 */
public class FenetreJeu extends JFrame implements Observer {
    private PanelJeu p;
    private ArrayList<Joueur> joueurs;
    private Boolean estPartieRapide;
    public FenetreJeu(ArrayList<Joueur> j, boolean estPR){
    this.joueurs = j;
        this.estPartieRapide = estPR;
        for(int i=0;i<this.joueurs.size();i++){
            this.joueurs.get(i).addObserver(this);

        }
        this.getContentPane().setLayout(null);
        //p = new PanelJeu(this,null);
        this.setTitle("Jeux des menhirs ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500, 830);
        this.setLayout(null);
        this.setVisible(true);
        System.out.println("je passe dans fenetre jeu");
    }

 /*   @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();

    }*/


    @Override
    public void update(Observable o, Object arg) {


     /*   this.getContentPane().setLayout(null);
        PanelJeu p = new PanelJeu(this.joueurs,this.estPartieRapide);
        this.setTitle("Jeux des menhirs ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500, 830);
        this.setLayout(null);

        this.setContentPane(p);

        this.setVisible(true);
        p.setVisible(true);*/

        this.getContentPane().repaint();




    }
}
