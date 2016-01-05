package jeuMenhir.jeu;



import jeuMenhir.InterfaceGraphique.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


/**
 * Created by morgane on 07/11/15.
 */
public class PartieRapide extends Observable implements ActionListener{
    private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
    private int saison;
    private String[] tablSaison = {"hiver", "printemps", "ete","automne"};


    private Joueur joueurQuijoue;
    private int numeroDeLaManche;
    private boolean estPartieRapide;
    private FenetreJeu fenJeu ;


    private int numChoixCarte;
    private int numChoix;
    private Carte carteSelectionne;
    private  boolean monBoleenJeu;
    private FenetreFin fenetreFin;
    private FenetreJoueurJoue fenetreJoueurJoue;
    private Scanner sc = new Scanner(System.in);
    public PartieRapide(ArrayList<Joueur> joueurs, int numPartie, boolean estPartieRapide, FenetreJeu fenetreJeu) {
        this.numeroDeLaManche = numPartie;
        this.estPartieRapide = estPartieRapide;
        this.joueurs = joueurs;
        this.fenJeu = fenetreJeu;

        this.addObserver(this.fenJeu);

    }

    public int jouer(){
        this.fenetreJoueurJoue = new FenetreJoueurJoue();
        saison = 0;
        if(estPartieRapide){
            joueurQuijoue = this.trouverJoueurCommencant();
        }else{
            joueurQuijoue = joueurs.get(this.numeroDeLaManche);
        }

        this.joueurs.remove(joueurQuijoue);
        this.joueurs.add(0,joueurQuijoue);



        while (saison<4){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("La saison actuelle est : " + tablSaison[saison]);
            PanelJeu p =(PanelJeu) this.fenJeu.getContentPane();
            p.setImgSaison(tablSaison[saison]);
            Iterator<Joueur> iter2 = this.joueurs.iterator();
            while (iter2.hasNext()) {

                Joueur joueurDeListe = iter2.next();


                System.out.println("Le joueur " + joueurDeListe.nom + " joue dans la saison : " + tablSaison[saison]);


                if(joueurDeListe instanceof JoueurReel){
                    joueurDeListe.getMain().afficherCartes();

                    this.fenetreJoueurJoue.setContentPane(new PanelJoueurJoue(joueurDeListe,this));
                this.fenetreJoueurJoue.setVisible(true);

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

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
                    numChoix = joueurOrdi.getStrategie().getClasse(carteSelectionne);

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
                            ArrayList<Integer> listeNumJoueur = new ArrayList<Integer>();
                            int numEmplacementJoueurActu = this.joueurs.indexOf(joueurDeListe);
                            if(joueurDeListe instanceof JoueurReel){
                                for(int i = 0 ; i < joueurs.size() ; i++){
                                    if(i != numEmplacementJoueurActu){
                                        System.out.println(i + " : " + joueurs.get(i).getNom() + " Nb Menhir = " + joueurs.get(i).getNbMenhir()  );
                                        listeNumJoueur.add(i);
                                    }
                                }
                                numDetruit = FonctionScan.recuperEntierEntrerCla("Entrer le numero de la personne dont vous voulez detruire les menhir : ");
                                while(!listeNumJoueur.contains(numDetruit)){
                                    numDetruit = FonctionScan.recuperEntierEntrerCla("Entrer le numero de la personne dont vous voulez detruire les menhir : ");
                                }


                            }else{
                                numDetruit = this.joueurs.indexOf(joueurDeListe);
                                while(numDetruit == this.joueurs.indexOf(joueurDeListe)){
                                    numDetruit =(int) (Math.random() * joueurs.size());
                                }

                            }
                            ((TaupeGeante) joueurDeListe.getCarteAllie()).detruireMenhir(joueurs.get(numDetruit),saison);
                        }else{
                            ((ChienGarde)joueurDeListe.getCarteAllie()).contrerFarfadet(joueurDeListe,saison);
                        }
                        break;
                }

                joueurDeListe.getMain().prendreCarteChoisi(carteSelectionne);
                this.fenetreJoueurJoue.setVisible(false);


            }
            saison++;
        }

       if(!estPartieRapide){
            int maxMenhir = 0;
            int numJoueurGagnant=0;
            for(int i=0 ; i < joueurs.size() ; i++){
                Joueur j = joueurs.get(i);
                if(numeroDeLaManche == 0){
                    j.setNbrMenhirEnTout(j.getNbrMenhirEnTout() + j.getNbMenhir());
                    j.setNbMenhir(0);
                    if(j.getNbrMenhirEnTout() > maxMenhir){
                        maxMenhir = j.getNbrMenhirEnTout();
                        numJoueurGagnant = i;
                    }
                }else{
                    j.setNbrMenhirEnTout(j.getNbrMenhirEnTout() + j.getNbMenhir());
                    j.setNbMenhir(0);

                }
            }
            for(int i = 0 ; i < joueurs.size() ; i++){
                System.out.println(" Nous avons : " + joueurs.get(i).getNom() + " avec " + joueurs.get(i).getNbMenhir() + " menhirs , "   + joueurs.get(i).getNbGrain() + " Graines et " +joueurs.get(i).getNbrMenhirEnTout() + " Menhirs en tout ! ");

            }

            if(numeroDeLaManche == 0){
                System.out.println("Fin de la derniere manche" );
                System.out.println("Le joueur gagnant est : " + joueurs.get(numJoueurGagnant).getNom() + " avec " + maxMenhir + " menhirs  ¸♬·¯·♩¸¸♪·¯·♫¸¸༼ つ ◕_◕ ༽つ ¸¸♬·¯·♩¸¸♪·¯·♫¸¸ ");
                this.fenetreFin = new FenetreFin();
                this.fenetreFin.setContentPane(new PanelFin(this.fenetreFin,joueurs.get(numJoueurGagnant),this.estPartieRapide));
                //this.fenJeu.setContentPane(new PanelFin(this.fenJeu,joueurs.get(numJoueurGagnant)));
            }else{
                System.out.println("Fin de la manche numero " + numeroDeLaManche );
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
            for(int i = 0 ; i < joueurs.size() ; i++){
                System.out.println(" Nous avons : " + joueurs.get(i).getNom() + " avec " + joueurs.get(i).getNbMenhir() + " menhirs et " + joueurs.get(i).getNbGrain() + " Graines");
            }
            System.out.println("Le joueur gagnant est : " + joueurs.get(numJoueurGagnant).getNom() + " avec " + maxMenhir + "menhirs  ¸♬·¯·♩¸¸♪·¯·♫¸¸༼ つ ◕_◕ ༽つ ¸¸♬·¯·♩¸¸♪·¯·♫¸¸ ");
           this.fenetreFin = new FenetreFin();
           this.fenetreFin.setContentPane(new PanelFin(this.fenetreFin, joueurs.get(numJoueurGagnant),this.estPartieRapide));
            //this.fenJeu.setContentPane(new PanelFin(this.fenJeu,joueurs.get(numJoueurGagnant)));
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

    @Override
    public void actionPerformed(ActionEvent e) {
  /*      numChoixCarte = this.panJoueur.getNumChoixCarte();
        numChoix = this.panJoueur.getNumChoix();
        this.fenJeu.setContentPane(this.panJeu);*/
        //carteSelectionne =  this.panJoueur.getCarteSelectionne();
        this.fenetreJoueurJoue.dispose();
    }


}
