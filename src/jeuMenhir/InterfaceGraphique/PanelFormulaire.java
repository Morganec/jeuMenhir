package jeuMenhir.InterfaceGraphique;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

    private JComboBox comboNbrJOrdi;
    private JLabel labelNbrJOrdi;


    public PanelFormulaire(FenetreFormulaire f){
        this.fenetreForm=  f;
        this.repaint();

        labelNbrJTot = new JLabel("Selectionner le nombre de joueurs au total ");
        comboNbrJTot = new JComboBox();
        comboNbrJTot.setPreferredSize(new Dimension(100, 20));
        String[] tab = {"1", "2", "3", "4","5","6","7","8"};

        comboNbrJTot = new JComboBox(tab);
        this.add(labelNbrJTot);
        this.add(comboNbrJTot);
        comboNbrJTot.addItemListener(new ItemState());

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

   class ItemState implements ItemListener {

       public void itemStateChanged(ItemEvent e) {

           System.out.println("événement déclenché sur : " + e.getItem());
       }

   }
}