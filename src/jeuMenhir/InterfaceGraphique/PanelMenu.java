package jeuMenhir.InterfaceGraphique;

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
public class PanelMenu extends JPanel{
    private FenetreMenu fenetreMenu;
    private JButton jouerPartiRap;
    private JButton jouerPartiAvance;



    public PanelMenu(FenetreMenu f){
        this.fenetreMenu=  f;
        this.repaint();
        jouerPartiRap = new JButton("Commencer une partie rapide ");
        jouerPartiAvance = new JButton("Commencer une partie avancée");
        jouerPartiRap.addActionListener(this.fenetreMenu);

        this.add(jouerPartiRap);

        jouerPartiAvance.addActionListener(this.fenetreMenu);

        this.add(jouerPartiAvance);

    }

    public void paintComponent(Graphics g){
        BufferedImage menu = null;
        jouerPartiRap.setBounds(200, 200, 250, 50);
        jouerPartiAvance.setBounds(200, 240, 250, 50);
        try {
            menu = ImageIO.read(new File("Images/imageDebut.jpg"));

        } catch (IOException ex) {
            System.out.print("non chargé");
        }
        g.drawImage(menu,0,0,this.getWidth(),this.getHeight(),null);




    }

    public JButton getJouerPartiRap() {
        return jouerPartiRap;
    }

    public JButton getJouerPartiAvance() {
        return jouerPartiAvance;
    }
}






