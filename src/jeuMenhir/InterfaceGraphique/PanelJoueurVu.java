package jeuMenhir.InterfaceGraphique;


import jeuMenhir.jeu.JoueurReel;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Created by morgane on 30/12/15.
 */
public class PanelJoueurVu extends JPanel {
    private JoueurReel monJoueur;

    private JLabel lblSexe;
    private JLabel lblPrenom;
    private JLabel lblAge;

    private FenetreJoueur fenJoueur;



    private JTextField tbPrenom;
    private JRadioButton jrFemme;
    private JRadioButton jrHomme;
    private JFormattedTextField tbAge;

    private JButton valider;
    public PanelJoueurVu(FenetreJoueur f){
        //this.monJoueur = j;
        this.fenJoueur=f;
        this.repaint();

        lblPrenom = new JLabel("Prenom d'un joueur : ");
        tbPrenom = new JTextField("prenom");
        this.add(lblPrenom);
        this.add(tbPrenom);

        lblAge = new JLabel("age : ");

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1);
        formatter.setMaximum(99);
        formatter.setCommitsOnValidEdit(true);

        tbAge = new JFormattedTextField(formatter);
        tbAge.setText("12");


        this.add(lblAge);
        this.add(tbAge);

        jrFemme = new JRadioButton("Femme");
        jrFemme.addActionListener(new jrFemmeClique());
        jrHomme = new JRadioButton("Homme");
        jrHomme.addActionListener(new jrHommeClique());
    jrFemme.setSelected(true);
        this.add(jrFemme);
        this.add(jrHomme);

        valider = new JButton("Valider");
        valider.addActionListener(this.fenJoueur);

        this.add(valider);
        this.setVisible(true);
    }
    public String getTbPrenom() {
        return tbPrenom.getText();
    }

    public int getAge(){
        return Integer.parseInt(tbAge.getText());
    }

    public boolean estFemme(){
        if(jrFemme.isSelected()){
            return true;
        }else{
            return false;
        }
    }

    class jrFemmeClique implements ActionListener {
        private JPanel panActu;
        public jrFemmeClique(){

        }
        public void actionPerformed(ActionEvent e) {
           if(jrHomme.isSelected()) {
               jrHomme.setSelected(false);
           }



        }

    }

    class jrHommeClique implements ActionListener {
        private JPanel panActu;
        public jrHommeClique(){

        }
        public void actionPerformed(ActionEvent e) {

            if(jrFemme.isSelected()){
                jrFemme.setSelected(false);
            }

        }

    }
}
