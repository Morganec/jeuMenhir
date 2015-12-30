package jeuMenhir.InterfaceGraphique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by morgane on 30/12/15.
 */
public class FenetreJoueur extends JFrame implements ActionListener{
    private PanelJeu p;

    public int getAgeJoueur() {
        return AgeJoueur;
    }

    private int AgeJoueur;
    public FenetreJoueur(){
        this.getContentPane().setLayout(null);
        //p = new PanelJeu(this,null);
        this.setTitle("Jeux des menhirs ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(610, 630);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
