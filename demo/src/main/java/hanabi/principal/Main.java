/*
 * Main.java                18/05/2022
 * Info1
 */
package principal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int nbPlayers;
        String[] username;
        Scanner sc = new Scanner(System.in);

        //TOUTES LES VARIABLES CRÉÉES SONT DES RÉINITIALISATIONS

        //Crée Users
        System.out.println("Combien y'a t'il de le Userrr ?");
        nbPlayers = sc.nextInt();
        username = new String[nbPlayers];
        for (int i = 0; i < nbPlayers; i++) {
            System.out.println("Quel est le nom du " + (i + 1) + "eme User ?");
            username[i] = sc.next();
        }
        User Userlist = new User(username);
        for (int i = 0; i < Userlist.getUsernames().length; i++) {
            System.out.println(Userlist.getUsernames()[i]);
        }

        //Crée et initialisé un deck
        Deck deck = new Deck();

        //Crée les mains des joueurs et leurs fournir les cartes du deck
        for (int i = 0; i < Userlist.getUsernames().length; i++) {
            if (Userlist.getUsernames().length >= 4) {
                for (int j = 0; j < 4; j++) {
                    Userlist.getUsernames()[i].setHand(j, deck.getCard());
                }
            } else {
                for (int j = 0; j < 5; j++) {
                    Userlist.getUsernames()[i].setHand(j, deck.getCard());
                }
            }
        }

        //Crée le plateau avec des cartes de valeurs nulles

        //Crée les jetons (initialisation à 8 et 0)

        //Crée la défausse

        /* -----------------------------------
         * Lancement de la partie
         * ----------------------------------- */

        //Joueur 1 joue, donne un indice à joueur 2 -> perte de jeton
        //Joueur 2 joue, il joue la carte -> place la carte et pioche une nouvelle carte
        //Joueur 3 joue, il défausse une carte et pioche une nouvelle carte -> gagne un jeton
        //Joueur 1 joue, il place une carte perdante -> gagne un jeton rouge et reprend une carte
        //Joueur 2 joue, il place une carte perdante -> 2 jetons rouges se sont accumulés
        //Joueur 3 joue, il place une carte perdante -> 3 jetons rouges se sont accumulés -> perte de la partie

        //Afficher les scores des joueurs

        //Retour menu principal

    }

}
