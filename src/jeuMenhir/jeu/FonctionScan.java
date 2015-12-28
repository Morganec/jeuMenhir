package jeuMenhir.jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by morgane on 06/12/15.
 */
public class FonctionScan {

    public static int recuperEntierEntrerCla(String phraseADemander){
        int monEntier= 0;
        boolean isEntier;
        Scanner sc;
        do{
            isEntier = true;
            System.out.println(phraseADemander);
            sc =   new Scanner(System.in);
            try{
                monEntier = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Ceci n'est pas un chiffre");
                isEntier = false;
            }
        }while (isEntier == false);

        return monEntier;
    };
}
