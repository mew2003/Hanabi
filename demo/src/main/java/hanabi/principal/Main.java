/*
 * Main.java                18/05/2022
 * Info1
 */
package principal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int nbPlayers;
        User[] players;
        Scanner sc = new Scanner(System.in);

        //TOUTES LES VARIABLES CRÉÉES SONT DES RÉINITIALISATIONS

        //Crée Users
        System.out.println("Combien y'a t'il de le Userrr ?");
        nbPlayers = sc.nextInt();
        players = new User[nbPlayers];
        for (int i = 0; i < nbPlayers; i++) {
            System.out.println("Quel est le nom de l'User " + (i + 1) + " ?");
            String username = sc.next();
            players[i] = new User(username);
        }
        for (int i = 0; i < nbPlayers; i++) {
            System.out.println("nom de l'utilisateur " + (i+1) + " : " + players[i].getUsername());
        }

        //Crée et initialisé un deck

        //Crée les mains des joueurs et leurs fournir les cartes du deck

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
