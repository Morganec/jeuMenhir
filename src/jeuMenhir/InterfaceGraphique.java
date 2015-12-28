package jeuMenhir;

import javax.swing.*;
import java.awt.*;

/**
 * Created by morgane on 15/12/15.
 */
public class InterfaceGraphique extends JFrame {

   // private VueLampe composantLampe;
    //private VueCommutateur composantInterrupteur;
    //private Lampe lampe;
    //private Commutateur commutateur;

    public InterfaceGraphique(){

        // on donne à cette fenêtre un titre
        setTitle("une première fenêtre");
        // création d'objets graphiques (les Vues) associés à la lampe et au commutateur
       // composantLampe = new VueLampe(l);
       // composantInterrupteur= new VueCommutateur(c);

        // on recupère le contenant de la fenêtre.
        // on lui affecte une politique de placement
        Container reservoir = this.getContentPane();
        reservoir.setLayout(new BorderLayout());

        // un premier cadre
        JPanel cadre1 = new JPanel();
        cadre1.setLayout(new BorderLayout());
        //cadre1.add(composantLampe,BorderLayout.NORTH);
        //cadre1.add(composantInterrupteur, BorderLayout.SOUTH);
        reservoir.add(cadre1,BorderLayout.NORTH);


        // un second cadre pour voir....
        JPanel cadre2 = new JPanel();
        cadre2.setLayout(new GridLayout(1,4));
        cadre2.add(new JButton(new ImageIcon("C:\\Users\\langeron\\Pictures\\as_coeur.png")));
        cadre2.add(new JButton(new ImageIcon("C:\\Users\\langeron\\Pictures\\as_carreau.png")));
        cadre2.add(new JButton(new ImageIcon("C:\\Users\\langeron\\Pictures\\as_pique.png")));
        cadre2.add(new JButton(new ImageIcon("C:\\Users\\langeron\\Pictures\\as_trefle.png")));
        reservoir.add(cadre2,BorderLayout.SOUTH);


        //*************************************************************************************
        // le plus compliqué. Rappelez-vous la classe anonyme vue en TD avec la classe Voiture
        // on abonne le commutateur à un écouteur d'événement
    /*    composantInterrupteur.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                commutateur.commuter();
            }
        });*/
        //*************************************************************
    }


}
