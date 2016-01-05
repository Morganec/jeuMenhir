package jeuMenhir.InterfaceGraphique;

import jeuMenhir.jeu.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by morgane on 30/12/15.
 */
public class PanelJeu extends JPanel implements Runnable {


    private Thread monThread;


    private Graphics graphic ;

    boolean estPartieRapide;


    private String imgSaison;

private ArrayList<Joueur> joueurs;

    public PanelJeu(ArrayList<Joueur> j,Boolean estPR){


        this.estPartieRapide = estPR;

        joueurs =j;

        this.imgSaison = null;
        this.setVisible(true);
        this.setBackground(Color.orange);
        this.repaint();
       monThread = new Thread(this);
        monThread.start();


    }




    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.graphic = g;





        BufferedImage imageJoueur = null;

        BufferedImage dosCarte = null;

        try {
            dosCarte = ImageIO.read(new File("Images/dosCarte.png"));

        } catch (IOException ex) {
            System.out.print("non chargé");
        }




        int u=0;
        JLabel prenom;
        for(int i=0;i< joueurs.size();i++){
            Joueur j = joueurs.get(i);
            try {
                imageJoueur = ImageIO.read(j.getImageJoueur());

            } catch (IOException ex) {
                System.out.print("non chargé");
            }
            g.drawImage(imageJoueur,u*100,100,100,100,null);

            g.setColor(Color.red);
            g.drawString( j.getNom(),u*100,100);
            g.drawString("Nbr Menhirs : " + j.getNbMenhir(), u * 100, 220);
            g.drawString("Nbr Graines : " + j.getNbGrain(), u * 100, 240);
            if(!this.estPartieRapide){
                g.drawString("Menhir total: " + j.getNbrMenhirEnTout(), u * 100, 260);
            }
            for(int d = 0 ; d< j.getMain().size(); d++ ){
                g.drawImage(dosCarte, u*100 + d * 10 , 300, 70, 100, null);
            }
            u++;

        }

        if(this.imgSaison != null){
            this.dessinerImageSaison(this.imgSaison);
        }


    }



    public void dessinerImageSaison(String img){
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File("Images/"+img+".png"));

        } catch (IOException ex) {
            System.out.print("non chargé");
        }
        this.graphic.drawImage(image,410,420,400,400,null);

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
    public void setImgSaison(String imgSaison) {
        this.imgSaison = imgSaison;
    }



}
