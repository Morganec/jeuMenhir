package jeuMenhir.InterfaceGraphique;

import jeuMenhir.jeu.Joueur;
import jeuMenhir.jeu.JoueurOrdinateur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by morgane on 31/12/15.
 */
public class PanelFin extends JPanel {
    private FenetreJeu fenetreJeu;
    private JButton fin;
    private Joueur joueurGagnant;
    public PanelFin(FenetreJeu f,Joueur j){
        this.fenetreJeu = f;
        this.joueurGagnant = j;
        fin = new JButton("FIN");
        fin.addActionListener(this.fenetreJeu);
        this.add(fin);
        this.setVisible(true);
        this.repaint();
    }
    public void paintComponent(Graphics g){
        BufferedImage imageJoueur = null;

    if(this.joueurGagnant instanceof JoueurOrdinateur){
        try {
            imageJoueur = ImageIO.read(new File("Images/robot.png"));

        } catch (IOException ex) {
            System.out.print("non chargé");
        }

    }else{
        try {
            imageJoueur = ImageIO.read(new File("Images/humain.png"));

        } catch (IOException ex) {
            System.out.print("non chargé");
        }
    }


        g.setColor(Color.red);
        g.drawString( "LE JOUEUR GAGNANT, avec  : ",300,200);
        g.drawString(this.joueurGagnant.getNbMenhir()+ "  Menhirs et avec  " , 300, 220);
        g.drawString(this.joueurGagnant.getNbGrain() + " Graines est :  "  , 300, 240);
        g.drawString( this.joueurGagnant.getNom(),300,260);
        g.drawImage(imageJoueur,  300, 280, 200, 200, null);

        





    }
}
