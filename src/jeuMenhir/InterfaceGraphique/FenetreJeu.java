package jeuMenhir.InterfaceGraphique;

import javax.swing.*;

/**
 * Created by morgane on 29/12/15.
 */
public class FenetreJeu extends JFrame {
    private PanelJeu p;
    public FenetreJeu(){
        this.getContentPane().setLayout(null);
        //p = new PanelJeu(this,null);
        this.setTitle("Jeux des menhirs ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(610, 630);
        this.setLayout(null);
        this.setVisible(true);
    }
}
