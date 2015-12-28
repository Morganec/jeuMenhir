package jeuMenhir.InterfaceGraphique;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
/**
 * Created by morgane on 28/12/15.
 */
public class PanelFormulaire extends JPanel implements ActionListener{
private JButton but1;
    private JButton but2;
    private FenetreFormulaire fenetreForm;
    public PanelFormulaire(FenetreFormulaire f){
        this.fenetreForm=  f;
        this.repaint();
        but1 =new JButton("Ici !");
        but1.addActionListener(this);
        this.add(but1, BorderLayout.CENTER);
        but2=new JButton("2eme !");
        but2.addActionListener(this);
        this.add(but2, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public  void actionPerformed(ActionEvent e)
    {
        Object  source=e.getSource();

        if  (source==but1)
            System.out.println("Ici !");
        else if (source==but2)
            System.out.println("2eme !");
        else
            System.out.print("nope");
    }
}