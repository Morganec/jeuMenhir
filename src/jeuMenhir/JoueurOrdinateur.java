package jeuMenhir;

/**
 * Created by morgane on 07/11/15.
 */
public class JoueurOrdinateur extends Joueur{
    public JoueurOrdinateur(int num){
        this.age = 70+num;
        this.nom = "robot"+Integer.toString(num);
        if(num % 2 == 0){
            this.estFemme = true;
        }else{
            this.estFemme = false;
        }
    }
}
