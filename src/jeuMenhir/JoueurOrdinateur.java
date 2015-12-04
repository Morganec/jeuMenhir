package jeuMenhir;

/**
 * Created by morgane on 07/11/15.
 */
public class JoueurOrdinateur extends Joueur{

    public int getNumCarteAllie() {
        return numCarteAllie;
    }

    public void setNumCarteAllie(int numCarteAllie) {
        this.numCarteAllie = numCarteAllie;
    }

    private int numCarteAllie;  // 1= Taupe 2 = chien
    public Strategie getStrategie() {
        return strategie;
    }

    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }

    private Strategie strategie;
    public JoueurOrdinateur(int num){
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
