package jeuMenhir.InterfaceGraphique;
import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
/**
 * Created by morgane on 28/12/15.
 */
public class FenetreFormulaire extends JFrame implements ActionListener  {



private JButton but1,but2;  //les boutons
    private PanelFormulaire p;
    /** Constructeur de test */
    public FenetreFormulaire() {
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

    }
}