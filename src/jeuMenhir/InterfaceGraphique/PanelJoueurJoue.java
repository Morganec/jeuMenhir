package jeuMenhir.InterfaceGraphique;

import jeuMenhir.jeu.Carte;
import jeuMenhir.jeu.Joueur;
import jeuMenhir.jeu.PartieRapide;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by morgane on 02/01/16.
 */
public class PanelJoueurJoue extends JPanel implements Runnable {
   private Joueur joueurQuiJoue;


    private Thread monThread;
    private int numChoixCarte;
    private int numChoix;
    private Carte carteSelectionne;

    public PanelJoueurJoue(Joueur j,PartieRapide p){

           this.joueurQuiJoue = j;


            JButton valider = new JButton("FERMER");
            valider.addActionListener(p);

        this.add(new JLabel("le joueur : " + j.getNom() + " doit jouer dans la console ! "), BorderLayout.NORTH);

        for(int i =0 ; i < j.getMain().size() ; i++){
            this.add(new JLabel(j.getMain().getCarte(i).toString()), BorderLayout.CENTER);
        }

        this.add(valider, BorderLayout.SOUTH);

       //monThread = new Thread(this);
       // monThread.start();

        this.repaint();

    }
    public void paintComponent(Graphics g){

        BufferedImage imageJoueur = null;
        try {
            imageJoueur = ImageIO.read(joueurQuiJoue.getImageJoueur());

        } catch (IOException ex) {
            System.out.print("non chargé");
        }
        g.drawImage(imageJoueur, 900, 20, 100, 100, null);
        g.setColor(Color.red);
        g.drawString(joueurQuiJoue.getNom(), 900, 20);
        int q = 10;
        for(int d = 0 ; d< joueurQuiJoue.getMain().size(); d++ ){
            g.drawString(joueurQuiJoue.getMain().afficherUneCarte(d), 900, 150 + q);
        }
        q =  q +10;
    }

    public int getNumChoixCarte() {
        //return numChoixCarte;
        return 0;
    }

    public int getNumChoix() {
        //return numChoix;
        return 0;
    }

    public Carte getCarteSelectionne() {
        return carteSelectionne;
    }

    @Override
    public void run() {
        while (true){
            this.pause();
        }

    }

    public void pause(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("DEUXIEME BOUCLE");
        this.repaint();
    }
}
