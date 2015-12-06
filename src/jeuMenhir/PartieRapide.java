package jeuMenhir;

import java.util.*;


/**
 * Created by morgane on 07/11/15.
 */
public class PartieRapide {
    private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
    private int saison;
    private String[] tablSaison = {"hiver", "printemps", "ete","automne"};
    private Joueur joueurQuijoue;
    private int numeroDeLaManche;
    private boolean estPartieRapide;


    private Scanner sc = new Scanner(System.in);
    public PartieRapide(ArrayList<Joueur> joueurs, int numPartie, boolean estPartieRapide) {
        this.numeroDeLaManche = numPartie;
        this.estPartieRapide = estPartieRapide;
        this.joueurs = joueurs;

    }

    public int jouer(){
        saison = 0;
if(estPartieRapide){
    joueurQuijoue = this.trouverJoueurCommencant();
}else{
    joueurQuijoue = joueurs.get(this.numeroDeLaManche);
}

        this.joueurs.remove(joueurQuijoue);
        this.joueurs.add(0,joueurQuijoue);
        int numChoixCarte;
        int numChoix;
        Carte carteSelectionne;

            while (saison<4){
            System.out.println("La saison actuelle est : " + tablSaison[saison]);
            Iterator<Joueur> iter2 = this.joueurs.iterator();
            while (iter2.hasNext()) {

                Joueur joueurDeListe = iter2.next();
                System.out.println("Le joueur " + joueurDeListe.nom + " joue dans la saison : " + tablSaison[saison]);


                if(joueurDeListe instanceof JoueurReel){

                    joueurDeListe.getMain().afficherCartes();
                    numChoixCarte = FonctionScan.recuperEntierEntrerCla("Entrer le numero de votre choix : ");
                    while (numChoixCarte < 1 || numChoixCarte > joueurDeListe.getMain().size()){
                        joueurDeListe.getMain().afficherCartes();
                        numChoixCarte = FonctionScan.recuperEntierEntrerCla("Entrer le numero de votre choix : ");
                    }
                    System.out.println("La carte selectionne est : " +  joueurDeListe.getMain().afficherUneCarte(numChoixCarte - 1));
                    carteSelectionne =  joueurDeListe.getMain().getCarte(numChoixCarte - 1);

                    if(carteSelectionne instanceof CarteIngredient) {
                        System.out.println("Les choix proposés sont : 1- Geant 2-Farfadet 3-Engrais ");
                        numChoix = FonctionScan.recuperEntierEntrerCla("Entre le numero de votre choix : ");
                        while (!((numChoix == 1) ||numChoix == 2 ||numChoix == 3)){
                            System.out.println("Les choix proposés sont : 1- Geant 2-Farfadet 3-Engrais ");
                            numChoix = FonctionScan.recuperEntierEntrerCla("Entre le numero de votre choix : ");
                        }
                    }else{
                        System.out.println("Plus rien est a choisir car vous avez choisi une carte allie ");
                        numChoix = 4;
                    }



                }else{

                    carteSelectionne = joueurDeListe.getMain().getCarte(0); // je joueur ordinateur prends toujours la premiere carte de sa main
                   JoueurOrdinateur joueurOrdi = (JoueurOrdinateur)joueurDeListe;
                    numChoix = joueurOrdi.getStrategie().getClasse(joueurDeListe.possedeCarteAllie());

                    //System.out.println("ici le joueur robot joue");
                }
                CarteIngredient carteSelec;
                switch (numChoix){
                    case 1 :
                         carteSelec = (CarteIngredient)carteSelectionne;
                        carteSelec.getGeant().donnerGraine(joueurDeListe,saison);
                        break;
                    case 2 :
                        int numVole;
                        if(joueurDeListe instanceof JoueurReel){
                            int numEmplacementJoueurActu = this.joueurs.indexOf(joueurDeListe);
                            ArrayList<Integer> listeNumJoueur = new ArrayList<Integer>();
                            for(int i = 0 ; i < joueurs.size() ; i++){
                                if(i != numEmplacementJoueurActu){
                                    listeNumJoueur.add(i);
                                    System.out.println(i + " : " + joueurs.get(i).getNom() + " Nb Graine = " + joueurs.get(i).getNbGrain()  );
                                }

                            }
                            numVole = FonctionScan.recuperEntierEntrerCla("Entrer le numero de la personne que vous voulez voler : ");
                            while(!listeNumJoueur.contains(numVole)){
                                numVole = FonctionScan.recuperEntierEntrerCla("Entrer le numero de la personne que vous voulez voler : ");
                            }

                        }else{
                            numVole = this.joueurs.indexOf(joueurDeListe);
                            while(numVole == this.joueurs.indexOf(joueurDeListe)){
                                numVole =(int) (Math.random() * joueurs.size());

                            }

                        }
                        carteSelec = (CarteIngredient)carteSelectionne;
                        carteSelec.getFarfadet().volerGraine(joueurDeListe,joueurs.get(numVole),saison);
                        break;
                    case 3 :
                        carteSelec = (CarteIngredient)carteSelectionne;
                        carteSelec.getEngrais().pousserGraine(joueurDeListe,saison);
                        break;
                    default:
                        if(joueurDeListe.getCarteAllie() instanceof TaupeGeante){
                            int numDetruit;
                            if(joueurDeListe instanceof JoueurReel){
                                for(int i = 0 ; i < joueurs.size() ; i++){
                                    System.out.println(i + " : " + joueurs.get(i).getNom() + " Nb Menhir = " + joueurs.get(i).getNbMenhir()  );
                                }
                                System.out.println("Entrer le numero de la personne dont vous voulez detruire les menhir : ");
                                //Attention verifier si c'est un entier
                                numDetruit = sc.nextInt();

                            }else{
                                numDetruit = this.joueurs.indexOf(joueurDeListe);
                                while(numDetruit == this.joueurs.indexOf(joueurDeListe)){
                                    numDetruit =(int) (Math.random() * joueurs.size());
                                }

                            }
                            ((TaupeGeante) joueurDeListe.getCarteAllie()).detruireMenhir(joueurs.get(numDetruit),saison);
                        }else{
                            System.out.println("ICI IL FAUDRA FAIRE L'ACTION DU CHIEN DE GARDE");
                        }
                        break;
                }


                joueurDeListe.getMain().prendreCarteChoisi(carteSelectionne);


            }
            saison++;
        }
        if(!estPartieRapide){
            int maxMenhir = 0;
            int numJoueurGagnant=0;
            for(int i=0 ; i < joueurs.size() ; i++){
                Joueur j = joueurs.get(i);
                if(numeroDeLaManche == 0){
                    if(j.getNbrMenhirEnTout() > maxMenhir){
                        maxMenhir = j.getNbrMenhirEnTout();
                        numJoueurGagnant = i;
                    }
                }else{
                    j.setNbrMenhirEnTout(j.getNbrMenhirEnTout() + j.getNbMenhir());
                    j.setNbMenhir(0);

               }
            }
            if(numeroDeLaManche == 0){
                System.out.println("Le joueur gagnant est : " + joueurs.get(numJoueurGagnant).getNom() + " avec " + maxMenhir + "menhirs");

            }

        }else{
            int maxMenhir = 0;
            int numJoueurGagnant=0;
            for(int i=0 ; i < joueurs.size() ; i++){
                Joueur j = joueurs.get(i);

                    if(j.getNbMenhir() > maxMenhir){
                        maxMenhir = j.getNbMenhir();
                        numJoueurGagnant = i;
                    }

            }
            System.out.println("Le joueur gagnant est : " + joueurs.get(numJoueurGagnant).getNom() + " avec " + maxMenhir + "menhirs");
        }
        this.numeroDeLaManche--;
        return this.numeroDeLaManche;

    }

    private Joueur trouverJoueurCommencant(){

        int agePersonne=0;
        Joueur jQuiCommence = new Joueur();
        Iterator<Joueur> iter = this.joueurs.iterator();
        while (iter.hasNext()) {
            Joueur joueurDeListe = iter.next();

            if(agePersonne == 0){
                agePersonne = joueurDeListe.getAge();
                jQuiCommence = joueurDeListe;
            }else {
                if(agePersonne > joueurDeListe.getAge()){
                    agePersonne = joueurDeListe.getAge();
                    jQuiCommence = joueurDeListe;
                }else if(agePersonne == joueurDeListe.getAge()){
                    if(joueurDeListe.isEstFemme()){
                        jQuiCommence = joueurDeListe;
                    }
                }

            }

        }
        System.out.println("Le joueur qui commence est : " + jQuiCommence.getNom() );
        return jQuiCommence;
    }
}
