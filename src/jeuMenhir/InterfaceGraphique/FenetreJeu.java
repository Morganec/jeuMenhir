package jeuMenhir.InterfaceGraphique;

import jeuMenhir.jeu.Partie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by morgane on 29/12/15.
 */
public class FenetreJeu extends JFrame implements ActionListener{
    private PanelJeu p;

    public FenetreJeu(){

        this.getContentPane().setLayout(null);
        //p = new PanelJeu(this,null);
        this.setTitle("Jeux des menhirs ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(810, 830);
        this.setLayout(null);
        this.setVisible(true);
        System.out.println("je passe dans fenetre jeu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();

    }
}
