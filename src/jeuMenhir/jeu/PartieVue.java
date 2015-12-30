package jeuMenhir.jeu;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.Observer;

/**
 * Created by morgane on 29/12/15.
 */
public class PartieVue implements Observer {
    private Partie partieObservee;
    public PartieVue(Partie p){
        this.partieObservee = p;
    }
    @Override
    public void update(java.util.Observable o, Object arg) {
        System.out.print("ICI JE PASSE " + o.getClass());
    }
}
