package jeuMenhir.InterfaceGraphique;
import jeuMenhir.jeu.Partie;

import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
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
        this.estPartieRapide =estPRapide;
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
        this.partie = new Partie(this.p.getNombreJoueurHumain(),this.p.getNombreJoueurRobot(),this.estPartieRapide);
    }
}