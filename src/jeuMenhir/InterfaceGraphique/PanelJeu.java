package jeuMenhir.InterfaceGraphique;

import jeuMenhir.jeu.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by morgane on 30/12/15.
 */
public class PanelJeu extends JPanel implements Observer {
    private FenetreJeu fenJeu;
    private JButton btnValider;

    private boolean interFaceJeuDessine = false;
    private boolean dessinerJoueur = false;
    private Joueur joueurQuiJoue;
    private PartieRapide partieEnCours;
    private boolean premierRepaint=true;
    private Graphics graphic ;

private ArrayList<Joueur> joueurs;

    public PanelJeu(FenetreJeu f,ArrayList<Joueur> j){

        this.fenJeu = f;

       // this.setLayout(null);
        btnValider=new JButton("Fermer");
        btnValider.addActionListener(this.fenJeu);
        this.add(btnValider);

        for(int i=0;i<j.size();i++){
            Joueur ji = j.get(i);
            ji.addObserver(this);
            j.set(i, ji);
        }
        joueurs =j;
        this.repaint();


    }




    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.graphic = g;
        System.out.println("JE ME REPAINT");

       /* if(premierRepaint){
            premierRepaint = false;
        }else{*/
             try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //}


        if(!interFaceJeuDessine){
            this.dessinerInterfaceJeu();
        }
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
            for(int d = 0 ; d< j.getMain().size(); d++ ){
                g.drawImage(dosCarte, u*100 + d * 10 , 300, 70, 100, null);
            }
            u++;

        }




    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();

    }

    public void dessinerInterfaceJeu(){
        this.graphic.setColor(Color.blue);
        this.graphic.drawRect(850, 10, 350, 700);
        interFaceJeuDessine = true;
    }



}
