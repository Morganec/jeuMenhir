package jeuMenhir.InterfaceGraphique;
import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
/**
 * Created by morgane on 28/12/15.
 */
public class FenetreFormulaire extends JFrame  {



private JButton but1,but2;  //les boutons
    private JPanel  pan;
    /** Constructeur de test */
    public FenetreFormulaire() {
        //titre de la fenetre
        super("Formulaire");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(610, 630);
        super.setLayout(null);
        pan = new PanelFormulaire(this);

        this.setContentPane(pan);
        this.setVisible(true);
    }
}