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
        String[] log;
        int score;
        int lastTurn = 0;

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
        log = new String[nbPlayer - 1];
        gameOver = false;
        while (!gameOver) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Au tour de " + players[actualPlayer].getName());
            System.out.println();
            System.out.println("Log : ");
            for (int i = 0; i < log.length; i++) {
                if (log[i] != null) {
                    System.out.println("Pour le joueur " + log[i]);
                }
            }
            System.out.println();
            System.out.println("Jeton bleu : " + blueToken.getValue() + " | Jeton rouge : " + redToken.getValue());
            System.out.println();
            System.out.println("Affichage du plateau de jeu :");
            System.out.println(placedCard.toString());
            System.out.println();
            System.out.println("Cartes des autres joueurs :");
            for (int i = 0; i < nbPlayer; i++) {
                if (i != actualPlayer) {
                    System.out.println(players[i].toString());
                }
            }
            System.out.println();
            validChoice = false;
            while (!validChoice) {
                System.out.println("Sélectionner une option :"
                        + "\n1. Jouer une carte");
                if (blueToken.getValue() > 0) {
                    System.out.println("2. Donner un indice");
                }
                if (blueToken.getValue() != 8) {
                    System.out.println("3. Se défausser");
                }
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
                                System.arraycopy(log, 1, log, 0, log.length - 1);
                                log[log.length - 1] = players[selectedPlayer].getName() + ", Cartes en position : "
                                                      + players[actualPlayer].giveAHint(players[selectedPlayer], blueToken, textChoice);
                            } else if (choice == 2) {
                                validChoice = true;
                                System.out.println("Saisissez la valeur :");
                                choice = sc.nextInt();
                                System.arraycopy(log, 1, log, 0, log.length - 1);
                                log[log.length - 1] = players[selectedPlayer].getName() + ", Cartes en position : "
                                                      + players[actualPlayer].giveAHint(players[selectedPlayer], blueToken, choice);
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
                lastTurn++;
                if (lastTurn == nbPlayer + 1) {
                    gameOver = true;
                }
            }
            if (redToken.getValue() == 3) {
                gameOver = true;
            }
        }

        /* Écrans de score */
        score = 0;
        System.out.println("Fin de la partie");
        System.out.println("Affichage du score :");
        for (int i = 0; i < 5; i++) {
            score += placedCard.getCardList()[i].getValue();
        }
        System.out.println("\nTotal du score : " + score);
        switch (score) {
            case 0, 1, 2, 3, 4, 5:
                System.out.println("\"Sur un cerisier mort, on ne trouve pas de fleurs.\" (枯れた桜には花がありません。)");
                break;
            case 6, 7, 8, 9, 10:
                System.out.println("\"Ceux que l'on ne dit pas sont les fleurs du silence\" (言わぬが花)");
                break;
            case 11, 12, 13, 14, 15:
                System.out.println("\"On ne peut admirer en même temps la lune, la neige et les fleurs.\" (月、雪、花を同時に見ることはできません。)");
                break;
            case 16, 17, 18, 19, 20:
                System.out.println("\"Même la pensée d'une fourmi peut toucher le ciel.\" (蟻の思いも天に昇る)");
                break;
            case 21, 22, 23, 24:
                System.out.println("\"La fleur d'hier est le rêve d'aujourd'hui\" (昨日の花は今日の夢)");
                break;
            case 25:
                System.out.println("\"Il y a les êtres humains, et il y a vous\" (人類とあなた)");
                break;
        }
    }
}
