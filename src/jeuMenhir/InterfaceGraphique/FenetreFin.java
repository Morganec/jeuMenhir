package jeuMenhir.InterfaceGraphique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by morgane on 04/01/16.
 */
public class FenetreFin extends JFrame implements ActionListener {
    public FenetreFin() {
        this.getContentPane().setLayout(null);


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
