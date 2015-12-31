package jeuMenhir.InterfaceGraphique;

import javax.swing.*;

/**
 * Created by morgane on 31/12/15.
 */
public class PanelFin extends JPanel {
    private FenetreFin fenetreFin;
    private JButton fin;
    public PanelFin(FenetreFin f){
        this.fenetreFin = f;
        this.repaint();
        fin = new JButton("FIN");
        fin.addActionListener(this.fenetreFin);
        this.add(fin);
        this.setVisible(true);
    }
}
