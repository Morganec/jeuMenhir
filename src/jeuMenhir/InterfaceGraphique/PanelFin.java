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

    private JButton fin;
    private Boolean estPartieRapide;
    private Joueur joueurGagnant;
    public PanelFin(FenetreFin f,Joueur j, boolean estPR){
        this.estPartieRapide = estPR;

        this.joueurGagnant = j;
        fin = new JButton("FIN");
        fin.addActionListener(f);
        this.add(fin);
        this.setVisible(true);
        this.repaint();
    }
    public void paintComponent(Graphics g){
        BufferedImage imageJoueur = null;

        try {
            imageJoueur = ImageIO.read((this.joueurGagnant).getImageJoueur());

        } catch (IOException ex) {
            System.out.print("non chargé");
        }




        g.setColor(Color.red);
        g.drawString( "LE JOUEUR GAGNANT, avec  : ",300,200);
        if(this.estPartieRapide){
            g.drawString(this.joueurGagnant.getNbMenhir()+ "  Menhirs  " , 300, 220);
        }else{
            g.drawString(this.joueurGagnant.getNbrMenhirEnTout()+ "  Menhirs au total " , 300, 220);
        }

        g.drawString("et avec  " + this.joueurGagnant.getNbGrain() + " Graines est :  "  , 300, 240);
        g.drawString( this.joueurGagnant.getNom(),300,260);
        g.drawImage(imageJoueur,  300, 280, 200, 200, null);


    }
}
