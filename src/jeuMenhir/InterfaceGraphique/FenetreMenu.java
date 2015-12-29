package jeuMenhir.InterfaceGraphique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

/**
 * Created by morgane on 28/12/15.
 */
public class FenetreMenu extends JFrame implements ActionListener {
    PanelMenu p;
    public FenetreMenu(){
        this.getContentPane().setLayout(null);
         p = new PanelMenu(this);
        this.setTitle("Jeux des menhirs ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(610, 630);
        this.setLayout(null);

        this.setContentPane(p);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Jeu monJeu = new Jeu();
        Object  source=e.getSource();

        if  (source==p.getJouerPartiAvance())
            System.out.println("Avan !");
        else if (source==p.getJouerPartiRap())
            System.out.println("rap !");
        else
            System.out.print("Erreur de selection");

       FenetreFormulaire fenetreForm = new FenetreFormulaire(true);
      this.dispose();
    }



}


