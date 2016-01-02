package jeuMenhir.jeu;

import java.io.File;

/**
 * Created by morgane on 07/11/15.
 */
public class JoueurOrdinateur extends Joueur{





    public Strategie getStrategie() {
        return strategie;
    }

    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }

    private Strategie strategie;
    public JoueurOrdinateur(int num){
        super.setImageJoueur(new File("Images/robot.png"));
        this.age = 70+num;
        this.nom = "robot"+Integer.toString(num);
        if(num % 2 == 0){
            this.estFemme = true;
            this.strategie = new StrategieDefensive(this);
        }else{
            this.estFemme = false;
            this.strategie = new StrategieOffensive(this);
        }

    }


}
