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
            System.out.println("SÃ©lectionner une option :"
                    + "\n1. JOUER");
            choice = sc.nextInt();
            if (choice == 1) validChoice = true;
        }

        /* Menu 1 */
        validChoice = false;
        while (!validChoice) {
            System.out.println("""
                    SÃ©lectionner une option :
                    1. Menu principal
                    2. RÃ¨gles
                    3. 2 joueurs
                    4. 3 joueurs
                    5. 4 joueurs
                    6. 5 joueurs""");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    /* TODO ImplÃ©menter cette mÃ©thode */
                    System.out.println("Retour au menu principal");
                    validChoice = true;
                }
                case 2 -> {
                    /* TODO ImplÃ©menter cette mÃ©thode */
                    /* TODO envoyer vers Menu 3*/
                    System.out.println("RÃ¨gles du jeu");
                    validChoice = true;
                }
                case 3 -> {
                    nbPlayer = 2;
                    validChoice = true;
                }
                case 4 -> {
                    nbPlayer = 3;
                    validChoice = true;
                }
                case 5 -> {
                    nbPlayer = 4;
                    validChoice = true;
                }
                case 6 -> {
                    nbPlayer = 5;
                    validChoice = true;
                }
                default -> System.out.println("SÃ©lection incorrecte");
            }
        }

        /* CrÃ©ation des objets permettant le bon fonctionnement du jeu */
        // CrÃ©er un deck
        deck = new Deck();

        // CrÃ©ation des joueurs
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

        // CrÃ©ation du plateau de jeu
        placedCard = new PlacedCard();

        // CrÃ©ation des jetons
        redToken = new Token(0);
        blueToken = new Token(8);

        // CrÃ©ation de la dÃ©fausse
        discard = new Discard();

        /* Ã‰crans de jeu */
        actualPlayer = 0;
        log = new String[nbPlayer - 1];
        gameOver = false;
        while (!gameOver) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Au tour de " + players[actualPlayer].getName());
            System.out.println();
            System.out.println("Log : ");
            for (String s : log) {
                if (s != null) {
                    System.out.println("Pour le joueur " + s);
                }
            }
            System.out.println();
            System.out.println("Affichage de la dÃ©fausse : " + discard);
            System.out.println();
            System.out.println("Jeton bleu : " + blueToken.getValue() + " | Jeton rouge : " + redToken.getValue());
            System.out.println();
            System.out.println("Affichage du plateau de jeu :");
            System.out.println(placedCard);
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
                System.out.println("SÃ©lectionner une option :"
                        + "\n1. Jouer une carte");
                if (blueToken.getValue() > 0) {
                    System.out.println("2. Donner un indice");
                }
                if (blueToken.getValue() != 8) {
                    System.out.println("3. Se dÃ©fausser");
                }
                choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("SÃ©lectionner la carte Ã  jouer (1 Ã  " + players[actualPlayer].getHand().length + "):");
                        position = sc.nextInt() - 1;
                        System.out.println("Vous avez jouÃ© la carte " + players[actualPlayer].getHand()[position].toString());
                        players[actualPlayer].playACard(position, deck, redToken, blueToken, placedCard, discard);
                        validChoice = true;
                    }
                    case 2 -> {
                        System.out.println("SÃ©lectionner le joueur Ã  qui vous souhaitez donner un indice :");
                        for (int i = 0; i < nbPlayer; i++) {
                            if (i != actualPlayer) {
                                System.out.println((i + 1) + ". " + players[i].getName());
                            }
                        }
                        selectedPlayer = sc.nextInt() - 1;
                        while (!validChoice) {
                            System.out.println("""
                                    SÃ©lectionner l'indice Ã  donner :
                                    1. Couleur
                                    2. Valeur""");
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
                                System.out.println("SÃ©lection incorrecte");
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("SÃ©lectionner la carte Ã  dÃ©fausser (1 Ã  " + players[actualPlayer].getHand().length + "):");
                        position = sc.nextInt() - 1;
                        System.out.println("Vous avez dÃ©faussÃ© la carte " + players[actualPlayer].getHand()[position].toString());
                        players[actualPlayer].discardACard(position, deck, blueToken, discard);
                        validChoice = true;
                    }
                    default -> System.out.println("SÃ©lection incorrecte");
                }
            }
            System.out.println("Fin du tour de " + players[actualPlayer].getName());
            if (actualPlayer == nbPlayer - 1) {
                actualPlayer = 0;
            } else {
                actualPlayer++;
            }

            // VÃ©rifier si le jeu est terminÃ©
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

        /* Ã‰crans de score */
        score = 0;
        System.out.println("Fin de la partie");
        System.out.println("Affichage du score :");
        for (int i = 0; i < 5; i++) {
            score += placedCard.getCardList()[i].getValue();
        }
        System.out.println("\nTotal du score : " + score);
        switch (score) {
            case 0, 1, 2, 3, 4, 5 ->
                    System.out.println("\"Sur un cerisier mort, on ne trouve pas de fleurs.\" (æž¯ã‚Œã�Ÿæ¡œã�«ã�¯èŠ±ã�Œã�‚ã‚Šã�¾ã�›ã‚“ã€‚)");
            case 6, 7, 8, 9, 10 ->
                    System.out.println("\"Ceux que l'on ne dit pas sont les fleurs du silence\" (è¨€ã‚�ã�¬ã�ŒèŠ±)");
            case 11, 12, 13, 14, 15 ->
                    System.out.println("\"On ne peut admirer en mÃªme temps la lune, la neige et les fleurs.\" (æœˆã€�é›ªã€�èŠ±ã‚’å�Œæ™‚ã�«è¦‹ã‚‹ã�“ã�¨ã�¯ã�§ã��ã�¾ã�›ã‚“ã€‚)");
            case 16, 17, 18, 19, 20 ->
                    System.out.println("\"MÃªme la pensÃ©e d'une fourmi peut toucher le ciel.\" (èŸ»ã�®æ€�ã�„ã‚‚å¤©ã�«æ˜‡ã‚‹)");
            case 21, 22, 23, 24 -> System.out.println("\"La fleur d'hier est le rÃªve d'aujourd'hui\" (æ˜¨æ—¥ã�®èŠ±ã�¯ä»Šæ—¥ã�®å¤¢)");
            case 25 -> System.out.println("\"Il y a les Ãªtres humains, et il y a vous\" (äººé¡žã�¨ã�‚ã�ªã�Ÿ)");
        }
        sc.close();
    }
}
