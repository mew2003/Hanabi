package principal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;
        int nbPlayer = 0;
        String playerName;
        boolean validChoice = false;
        PlayerHand[] players;
        PlacedCard placedCard;
        Deck deck;
        Token redToken;
        Token blueToken;
        Discard discard;
        int actualPlayer;
        boolean gameOver;
        int position;
        int selectedPlayer;
        String textChoice;
        String[][] log;

        /* Menu */
        while (!validChoice) {
            System.out.println("Sélectionner une option :"
                    + "\n1. JOUER");
            choice = sc.nextInt();
            if (choice == 1) validChoice = true;
        }

        /* Menu 1 */
        validChoice = false;
        while (!validChoice) {
            System.out.println("Sélectionner une option :"
                    + "\n1. Menu principal"
                    + "\n2. Règles"
                    + "\n3. 2 joueurs"
                    + "\n4. 3 joueurs"
                    + "\n5. 4 joueurs"
                    + "\n6. 5 joueurs");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    /* TODO Implémenter cette méthode */
                    System.out.println("Retour au menu principal");
                    validChoice = true;
                    break;
                case 2:
                    /* TODO Implémenter cette méthode */
                    /* TODO envoyer vers Menu 3*/
                    System.out.println("Règles du jeu");
                    validChoice = true;
                    break;
                case 3:
                    nbPlayer = 2;
                    validChoice = true;
                    break;
                case 4:
                    nbPlayer = 3;
                    validChoice = true;
                    break;
                case 5:
                    nbPlayer = 4;
                    validChoice = true;
                    break;
                case 6:
                    nbPlayer = 5;
                    validChoice = true;
                    break;
                default:
                    System.out.println("Sélection incorrecte");
                    break;
            }
        }

        /* Création des objets permettant le bon fonctionnement du jeu */
        // Créer un deck
        deck = new Deck();

        // Création des joueurs
        players = new PlayerHand[nbPlayer];
        System.out.println("Veuillez saisir le noms des joueurs");
        for (int i = 0; i < nbPlayer; i++) {
            System.out.print("Joueur " + (i + 1) + " : ");
            playerName = sc.next();
            players[i] = new PlayerHand(playerName, nbPlayer, deck);
        }
        System.out.println("Liste des joueurs :" );
        for (int i = 0; i < nbPlayer; i++) {
            System.out.println((i+1) + ". " + players[i].getName());
        }

        // Création du plateau de jeu
        placedCard = new PlacedCard();

        // Création des jetons
        redToken = new Token(0);
        blueToken = new Token(8);

        // Création de la défausse
        discard = new Discard();

        /* Écrans de jeu */
        actualPlayer = 0;
        log = new String[nbPlayer - 1][];
        gameOver = false;
        while (!gameOver) {
            System.out.println("Au tour de " + players[actualPlayer].getName());
            System.out.println("Log : ");
            for (int i = 0; i < log.length; i++) {
                for (int j = 0; j < log[i].length; j++) {
                    System.out.println();
                }
            }
            validChoice = false;
            while (!validChoice) {
                System.out.println("Sélectionner une option :"
                        + "\n1. Jouer une carte"
                        + "\n2. Donner un indice"
                        + "\n3. Se défausser");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Sélectionner la carte à jouer (1 à " + players[actualPlayer].getHand().length + "):");
                        position = sc.nextInt() - 1;
                        System.out.println("Vous avez joué la carte " + players[actualPlayer].getHand()[position].toString());
                        players[actualPlayer].playACard(position, deck, redToken, blueToken, placedCard, discard);
                        validChoice = true;
                        break;
                    case 2:
                        System.out.println("Sélectionner le joueur à qui vous souhaitez donner un indice :");
                        for (int i = 0 ; i < nbPlayer; i++) {
                            if (i != actualPlayer) {
                                System.out.println((i+1) + ". " + players[i].getName());
                            }
                        }
                        selectedPlayer = sc.nextInt() - 1;
                        validChoice = false;
                        while (!validChoice) {
                            System.out.println("Sélectionner l'indice à donner :"
                                    + "\n1. Couleur"
                                    + "\n2. Valeur");
                            choice = sc.nextInt();
                            if (choice == 1) {
                                validChoice = true;
                                System.out.println("Saisissez la couleur :");
                                textChoice = sc.next();
                                log[0] = players[actualPlayer].giveAHint(players[selectedPlayer], blueToken, textChoice);
                            } else if (choice == 2) {
                                validChoice = true;
                                System.out.println("Saisissez la valeur :");
                                choice = sc.nextInt();
                                log[0] = players[actualPlayer].giveAHint(players[selectedPlayer], blueToken, choice);
                            } else {
                                System.out.println("Sélection incorrecte");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Sélectionner la carte à défausser (1 à " + players[actualPlayer].getHand().length + "):");
                        position = sc.nextInt() - 1;
                        System.out.println("Vous avez défaussé la carte " + players[actualPlayer].getHand()[position].toString());
                        players[actualPlayer].discardACard(position, deck, blueToken, discard);
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Sélection incorrecte");
                        break;
                }
            }
            System.out.println("Fin du tour de " + players[actualPlayer].getName());
            if (actualPlayer == nbPlayer - 1) {
                actualPlayer = 0;
            } else {
                actualPlayer++;
            }

            // Vérifier si le jeu est terminé
            if (deck.getNbCards() == 0) {
                // TODO Implémenter cette méthode
            }
            if (redToken.getValue() == 3) {
                gameOver = true;
            }
        }

        /* Écrans de score */

    }
}
