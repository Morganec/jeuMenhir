package jeuMenhir.InterfaceGraphique;

import jeuMenhir.jeu.Joueur;
import jeuMenhir.jeu.JoueurReel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by morgane on 30/12/15.
 */
public class PanelJeu extends JPanel {
    private FenetreJeu fenJeu;

    public PanelJeu(FenetreJeu f){
        this.fenJeu = f;
        this.repaint();
    }




    public void paintComponent(Graphics g){
        BufferedImage menu = null;

        try {
            menu = ImageIO.read(new File("Images/imageDebut.jpg"));

        } catch (IOException ex) {
            System.out.print("non chargé");
        }
        g.drawImage(menu,0,0,this.getWidth(),this.getHeight(),null);




    }

}
