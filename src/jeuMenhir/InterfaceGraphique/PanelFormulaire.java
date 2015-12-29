package jeuMenhir.InterfaceGraphique;

import javax.imageio.ImageIO;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by morgane on 28/12/15.
 */
public class PanelFormulaire extends JPanel {
    private FenetreFormulaire fenetreForm;
    private JButton jouerPartiRap;
    private JButton jouerPartiAvance;


    public PanelFormulaire(FenetreFormulaire f){
        this.fenetreForm=  f;
        this.repaint();
        jouerPartiRap = new JButton("Commencer une partie rapide ");
        jouerPartiAvance = new JButton("Commencer une partie avancée");
        jouerPartiRap.addActionListener(this.fenetreForm);

        this.add(jouerPartiRap);

        jouerPartiAvance.addActionListener(this.fenetreForm);

        this.add(jouerPartiAvance);
    }


}