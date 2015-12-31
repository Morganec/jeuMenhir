package jeuMenhir.InterfaceGraphique;

import jeuMenhir.jeu.Partie;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by morgane on 28/12/15.
 */
public class PanelFormulaire extends JPanel {
    private FenetreFormulaire fenetreForm;
    private JComboBox comboNbrJTot;
    private JLabel labelNbrJTot;



    private int nombreJoueurHumain;
    private int nombreJoueurRobot;
    private int nombreJoueurTot;
    private JComboBox comboNbrJOrdi;
    private JLabel labelNbrJOrdi;
    private JButton btnValider;


    public PanelFormulaire(FenetreFormulaire f){
        this.fenetreForm=  f;
        this.repaint();
        nombreJoueurRobot = 0;
        nombreJoueurHumain = 8;
        nombreJoueurTot = 8;
        comboNbrJOrdi=new JComboBox();
        comboNbrJTot = new JComboBox();
        labelNbrJTot = new JLabel("Selectionner le nombre de joueurs au total ");
        comboNbrJTot.setPreferredSize(new Dimension(100, 20));
        labelNbrJOrdi = new JLabel("Selectionner le nombre de joueurs ordinateurs");
        comboNbrJOrdi.setPreferredSize(new Dimension(100, 20));

        String[] tab = {"1", "2", "3", "4","5","6","7","8"};

        comboNbrJTot = new JComboBox(tab);

        comboNbrJTot.setSelectedIndex(7);

        btnValider=new JButton("Valider");
        btnValider.addActionListener(this.fenetreForm);

        this.add(labelNbrJTot);
        this.add(comboNbrJTot);
        this.add(labelNbrJOrdi);
       this.add(comboNbrJOrdi);
        this.add(btnValider);
        comboNbrJOrdi.setVisible(false);
        labelNbrJOrdi.setVisible(false);
        btnValider.setVisible(false);
        comboNbrJTot.addActionListener(new ItemNbrJoueurTot(this));
        comboNbrJOrdi.addActionListener(new ItemNbrJoueurRob(this));

    }

    public void paintComponent(Graphics g){
        BufferedImage menu = null;

       /* try {
            menu = ImageIO.read(new File("Images/imageDebut.jpg"));

        } catch (IOException ex) {
            System.out.print("non chargé");
        }
        g.drawImage(menu,0,0,this.getWidth(),this.getHeight(),null);*/
        int u=0;
        for(int i=0; i<nombreJoueurRobot ; i++){
            try {
                menu = ImageIO.read(new File("Images/robot.png"));

            } catch (IOException ex) {
                System.out.print("non chargé");
            }
            //g.drawImage(menu,i*100,100,100,100,null);
            if(i>5){
                g.drawImage(menu,u*100,200,100,100,null);
                u++;
            }else{
                g.drawImage(menu,i*100,100,100,100,null);
            }

        }
        int j = 0;
        for(int i= 0; i< nombreJoueurHumain; i++){
            try {
                menu = ImageIO.read(new File("Images/humain.png"));

            } catch (IOException ex) {
                System.out.print("non chargé");
            }
            if(i>5){
                g.drawImage(menu,j*100,400,100,100,null);
                j++;
            }else{
                g.drawImage(menu,i*100,300,100,100,null);
            }

        }


    }


    public int getNombreJoueurHumain() {
        return nombreJoueurHumain;
    }

    public int getNombreJoueurRobot() {
        return nombreJoueurRobot;
    }

   class ItemNbrJoueurTot implements ActionListener {
       private JPanel panActu;
        public ItemNbrJoueurTot(JPanel p){
            this.panActu = p;
        }
       public void actionPerformed(ActionEvent e) {

           nombreJoueurTot = Integer.parseInt(comboNbrJTot.getSelectedItem().toString());
           nombreJoueurRobot = 0;
           nombreJoueurHumain = nombreJoueurTot - nombreJoueurRobot;
           System.out.println("événement déclenché sur : " + nombreJoueurHumain);


                comboNbrJOrdi.setModel(new DefaultComboBoxModel());
           for(int i = 0 ; i < nombreJoueurTot; i++ ){
               String chiffre = i+1 + "";
               comboNbrJOrdi.addItem(chiffre);
           }
            labelNbrJOrdi.setVisible(true);
           comboNbrJOrdi.setVisible(true);
           btnValider.setVisible(true);
           this.panActu.repaint();


       }

   }



    class ItemNbrJoueurRob implements ActionListener {
        private JPanel panActu;
        public ItemNbrJoueurRob(JPanel p){
            this.panActu = p;
        }
        public void actionPerformed(ActionEvent e) {

            nombreJoueurRobot = Integer.parseInt(comboNbrJOrdi.getSelectedItem().toString());
            nombreJoueurHumain = nombreJoueurTot - nombreJoueurRobot;

            System.out.println("événement déclenché sur : " + nombreJoueurRobot);

            this.panActu.repaint();


        }

    }

}