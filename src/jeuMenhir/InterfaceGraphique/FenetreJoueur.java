package jeuMenhir.InterfaceGraphique;

import jeuMenhir.jeu.Joueur;
import jeuMenhir.jeu.JoueurOrdinateur;
import jeuMenhir.jeu.JoueurReel;
import jeuMenhir.jeu.Partie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by morgane on 30/12/15.
 */
public class FenetreJoueur extends JFrame implements ActionListener{
    private PanelJoueurVu panelJoueurVu;



    private int nbjoueurHum;
    private int nbjoueurRob;
    private boolean estPartieRapide;
    private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
    public FenetreJoueur(int nbJH,int nbjR,ArrayList<Joueur> j, boolean estPR){
        this.joueurs =j;
        this.getContentPane().setLayout(null);
        this.estPartieRapide = estPR;
        //p = new PanelJeu(this,null);
        //this.panelJoueurVu = p;
        this.nbjoueurHum = nbJH;
        this.nbjoueurRob = nbjR;
        this.setTitle("Jeux des menhirs ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(610, 630);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.panelJoueurVu = (PanelJoueurVu)this.getContentPane();

        String nom = this.panelJoueurVu.getTbPrenom();
        int age = this.panelJoueurVu.getAge();
        Boolean estF= this.panelJoueurVu.estFemme();

        System.out.println("le prenom " + nom + " age : " +age + " estFemme : " + estF);

        JoueurReel jr = new JoueurReel(age,estF,nom);
        joueurs.add(jr);
        if(joueurs.size() < this.nbjoueurHum){
            this.dispose();
            FenetreJoueur fenetreJoueur = new FenetreJoueur(this.nbjoueurHum,this.nbjoueurRob,joueurs,this.estPartieRapide);
            PanelJoueurVu panelJoueurVu = new PanelJoueurVu(fenetreJoueur);
            fenetreJoueur.setContentPane(panelJoueurVu);
        }else{
            for(int i = 0 ; i<this.nbjoueurRob; i++){
                joueurs.add(new JoueurOrdinateur(i));
            }

            FenetreJeu fenJeu = new FenetreJeu();
            PanelJeu panJeu = new PanelJeu(fenJeu,joueurs,this.estPartieRapide);
            fenJeu.setContentPane(panJeu);
            Partie partie = new Partie(this.estPartieRapide,joueurs);


            this.dispose();
            partie.jouer(fenJeu);


        }


    }
}
