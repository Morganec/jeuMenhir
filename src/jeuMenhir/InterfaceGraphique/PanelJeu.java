package jeuMenhir.InterfaceGraphique;

import jeuMenhir.jeu.Joueur;
import jeuMenhir.jeu.JoueurOrdinateur;
import jeuMenhir.jeu.JoueurReel;
import jeuMenhir.jeu.Partie;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by morgane on 30/12/15.
 */
public class PanelJeu extends JPanel implements Observer {
    private FenetreJeu fenJeu;
    private JButton btnValider;
    Partie partie;
    public PanelJeu(FenetreJeu f,Partie p){
        this.partie = p;
        this.fenJeu = f;
        this.repaint();
       // this.setLayout(null);
        btnValider=new JButton("Valider");
        btnValider.addActionListener(this.fenJeu);
        this.add(btnValider);
        this.setBackground(Color.red);
        for(int i=0;i<partie.getJoueurs().size();i++){
            Joueur j = partie.getJoueurs().get(i);
            j.addObserver(this);
            System.out.print("ajout observer");
            partie.getJoueurs().set(i,j);
        }

    }




    public void paintComponent(Graphics g){
        System.out.println("je passe dans paint compo");


        BufferedImage robot = null;
        BufferedImage humain = null;
        BufferedImage dosCarte = null;

        try {
            dosCarte = ImageIO.read(new File("Images/dosCarte.png"));

        } catch (IOException ex) {
            System.out.print("non chargé");
        }

        try {
            robot = ImageIO.read(new File("Images/robot.png"));

        } catch (IOException ex) {
            System.out.print("non chargé");
        }

        try {
            humain = ImageIO.read(new File("Images/humain.png"));

        } catch (IOException ex) {
            System.out.print("non chargé");
        }

        int u=0;
        JLabel prenom;
        for(int i=0;i<partie.getJoueurs().size();i++){
            Joueur j = partie.getJoueurs().get(i);

                if(j instanceof JoueurOrdinateur) {
                    g.drawImage(robot,u*100,100,100,100,null);
                }else {
                    g.drawImage(humain, u * 100, 100, 100, 100, null);
                }
            g.setColor(Color.red);
            g.drawString( j.getNom(),u*100,100);
            g.drawString("Nbr Menhirs : " + j.getNbMenhir(), u * 100, 220);
            g.drawString("Nbr Graines : " + j.getNbGrain(), u * 100, 240);
            for(int d = 0 ; d< j.getMain().size(); d++ ){
                g.drawImage(dosCarte, u*100 + d * 10 , 300, 70, 100, null);
            }
            u++;

        }


    }

    @Override
    public void update(Observable o, Object arg) {
        this.setBackground(Color.blue);
        this.repaint();
    }
}
