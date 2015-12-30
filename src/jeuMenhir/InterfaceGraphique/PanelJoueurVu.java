package jeuMenhir.InterfaceGraphique;

import jeuMenhir.jeu.Joueur;

import javax.swing.*;

/**
 * Created by morgane on 30/12/15.
 */
public class PanelJoueurVu extends JPanel {
    private Joueur monJoueur;

    private JLabel lblSexe;
    private JLabel lblPrenom;
    private JLabel lblAge;

    private JTextField tbPrenom;
    private JRadioButton jrFemme;
    private JRadioButton jrHomme;
    private JTextField tbAge;
    public PanelJoueurVu(Joueur j){
        this.monJoueur = j;
        this.repaint();
        lblPrenom = new JLabel("Prenom d'un joueur : ");
        tbPrenom = new JTextField("prenom");
        this.add(lblPrenom);
        this.add(tbPrenom);

    this.setVisible(true);
    }


}
