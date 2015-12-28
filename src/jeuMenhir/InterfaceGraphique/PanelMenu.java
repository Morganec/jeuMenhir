package jeuMenhir.InterfaceGraphique;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by morgane on 28/12/15.
 */
public class PanelMenu extends JPanel{
    private FenetreMenu fenetreMenu;

    public PanelMenu(FenetreMenu f){
        this.fenetreMenu=  f;
        this.repaint();

    }

    public void paintComponent(Graphics g){
        BufferedImage menu = null;
        JButton jouer = new JButton("Commencer une partie");
        jouer.addActionListener(this.fenetreMenu);
        jouer.setBounds(200, 240, 200, 50);
        this.add(jouer);
        try {
            menu = ImageIO.read(new File("Images/imageDebut.jpg"));

        } catch (IOException ex) {
            System.out.print("non chargé");
        }
        g.drawImage(menu,0,0,this.getWidth(),this.getHeight(),null);




    }
}
