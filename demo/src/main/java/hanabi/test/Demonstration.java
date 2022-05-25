/*
 * Main.java                18/05/2022
 * Info1
 */
package test;

import principal.*;

import java.util.Scanner;

public class Demonstration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nbPlayer;
        int cardChoice;
        PlayerHand players[];

        //Crée et initialisé un deck
        System.out.println("Création du deck");
        Deck deck = new Deck();
        System.out.println("Le deck a bien été crée");

        //Crée User
        System.out.println("Création des joueurs");
        System.out.println("Entrez le nombre de joueurs");
        nbPlayer = sc.nextInt();
        players = new PlayerHand[nbPlayer];
        for (int i = 0; i < nbPlayer; i++) {
            System.out.println("Entrez le nom du joueur " + (i + 1));
            String name = sc.next();
            players[i] = new PlayerHand(name, nbPlayer, deck);
        }

        // TODO A supprimer, affichage temporaire
        for (int i = 0; i < nbPlayer; i++) {
            System.out.println(players[i].toString());
        }

        //Crée le plateau avec des cartes de valeurs nulles
        PlacedCard placedCard = new PlacedCard();
        for (int i = 0; i < placedCard.getCardList().length; i++) {
            System.out.println(placedCard.getCardList()[i].toString());
        }

        //Crée les jetons (initialisation à 8 et 0)
        Token redToken = new Token(0);
        Token blueToken = new Token(8);
        System.out.println("Le jeton rouge a été initialisé avec la valeur " + redToken.getValue()
                           + " et le jeton bleu a été initialisé avec la valeur " + blueToken.getValue());

        //Crée la défausse
        Discard discard = new Discard();
        System.out.println(discard.toString());

        /* -----------------------------------
         * Lancement de la partie
         * ----------------------------------- */

        //Joueur 1 joue, donne un indice à joueur 2 -> perte de jeton
        System.out.println("Joueur 1 joue et donne un indice à joueur 2");
        Card[] cardHint = players[0].giveAHint(players[1], blueToken, "red");
        System.out.println("Le joueur 1 a donné un indice de couleur rouge à joueur 2");
        for (int i = 0; i < cardHint.length; i++) {
            if (cardHint[i] != null) {
                System.out.println("Carte en position " + (i+1) + " : " + cardHint[i].getColor());
            }
        }
        System.out.println("Le joueur 1 a donné un indice de valeur 3 à joueur 2");
        cardHint = players[0].giveAHint(players[1], blueToken, 3);
        for (int i = 0; i < cardHint.length; i++) {
            if (cardHint[i] != null) {
                System.out.println("Carte en position " + (i+1) + " : " + cardHint[i].getValue());
            }
        }

        //Joueur 2 joue, il joue la carte -> place la carte et pioche une nouvelle carte
        System.out.println("Sélectionner la carte à jouer");
        cardChoice = sc.nextInt();
        players[0].playACard(cardChoice, deck, redToken, blueToken, placedCard, discard);
        for (int i = 0; i < placedCard.getCardList().length; i++) {
            System.out.println(placedCard.getCardList()[i].toString());
        }
        for (int i = 0; i < nbPlayer; i++) {
            System.out.println(players[i].toString());
        }
        //Joueur 3 joue, il défausse une carte et pioche une nouvelle carte -> gagne un jeton
        //Joueur 1 joue, il place une carte perdante -> gagne un jeton rouge et reprend une carte
        //Joueur 2 joue, il place une carte perdante -> 2 jetons rouges se sont accumulés
        //Joueur 3 joue, il place une carte perdante -> 3 jetons rouges se sont accumulés -> perte de la partie

        //Afficher les scores des joueurs

        //Retour menu principal

    }

}
