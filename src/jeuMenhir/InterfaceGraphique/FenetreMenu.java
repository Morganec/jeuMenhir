package jeuMenhir.InterfaceGraphique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by morgane on 28/12/15.
 */
public class FenetreMenu extends JFrame implements ActionListener {
    public FenetreMenu(){
        this.getContentPane().setLayout(null);
        PanelMenu p = new PanelMenu(this);
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
        this.dispose();
    }
}
