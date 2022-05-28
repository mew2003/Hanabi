/*
 * PlayerHand.java                18/05/2022
 * Info1
 */

package principal;

/** 
 * TODO Commenter la responsabilité de cette class
 * @author 
 *
 */
public class PlayerHand {

    private final String name;

    private final Card[] hand;

    /**
     * DÃ©finition d'une main de joueur,
     * Un joueur possÃ¨de un nom et une main de cartes
     * La main du joueur est de 5 cartes si le nombre de joueurs total est infÃ©rieur Ã  4
     * Sinon, la main du joueur est de 4 cartes.
     * @param name   Nom du joueur
     * @param nbPlayer   Nombre de joueurs total
     * @param deck   La pioche qui sert à initialisé la main du joueur
     * @throws IllegalArgumentException si le nombre de joueurs est invalide (infÃ©rieur Ã  2 ou supÃ©rieur Ã  5)
     */
    public PlayerHand(String name, int nbPlayer, Deck deck) {
        if (nbPlayer < 2) {
            throw new IllegalArgumentException("Le nombre de joueur doit Ãªtre supÃ©rieur Ã  1");
        }
        if (nbPlayer > 5) {
            throw new IllegalArgumentException("Le nombre de joueur doit Ãªtre infÃ©rieur Ã  6");
        }
        if (nbPlayer < 4) {
            this.hand = new Card[5];
            for (int i = 0; i < 5; i++) {
                drawACard(i, deck);
            }
        } else {
            this.hand = new Card[4];
            for (int i = 0; i < 4; i++) {
                drawACard(i, deck);
            }
        }
        this.name = name;
    }

    /** @return Le nom du joueur */
    public String getName() {
        return name;
    }

    /** @return La main du joueur */
    public Card[] getHand() {
        return hand;
    }

    /** 
     * Choisit une carte aléatoirement dans la pioche et la place dans 
     * la main d'un joueur
     * @param position  La position à laquelle placer la carte
     * @param deck  La pioche dans laquelle est pioché la carte
     * @return rien
     */
    public Card drawACard(int position, Deck deck) {
        if (position < 0 || position > hand.length) {
            throw new IllegalArgumentException("La position de la carte doit "
                                               + "Ãªtre comprise entre 0 et "
                                               + hand.length);
        }
        hand[position] = deck.getCards();
        return null;
    }

    /** 
     * TODO Commenter le rôle (SRP) de cette méthode
     * @param position
     * @param deck
     * @param redToken
     * @param blueToken
     * @param placedCard
     * @param discard
     * @return rien
     */
    public Card playACard(int position, Deck deck, Token redToken, Token blueToken, PlacedCard placedCard, Discard discard) {

        if (position < 0 || position > hand.length) {
            throw new IllegalArgumentException("La position de la carte doit Ãªtre comprise entre 0 et " + hand.length);
        }
        boolean isSuccess;
        isSuccess = placedCard.placeACard(hand[position], blueToken);
        if (isSuccess) {
            System.out.println("La carte a bien Ã©tÃ© posÃ©e");
            if (deck.getNbCards() != 0) {
                drawACard(position, deck);
            }
        } else {
            System.out.println("La carte n'a pas Ã©tÃ© posÃ©e");
            discardACard(position, deck, redToken, discard);
        }

        return null;
    }

    /** TODO Commenter le rôle (SRP) de cette méthode
     * @param user
     * @param token
     * @param color
     * @return rien
     */
    public String giveAHint(PlayerHand user, Token token, String color) {


        if (!color.equals("red") && !color.equals("blue") && !color.equals("pink") && !color.equals("yellow") && !color.equals("white")) {
            throw new IllegalArgumentException("La couleur doit Ãªtre red / blue / pink / yellow / white");
        }

        StringBuilder hintList = new StringBuilder();

        token.decToken();
        for (int i = 0; i < user.hand.length; i++) {
            if (user.hand[i].getColor().equals(color)) {
                hintList.append("\nCarte en position ").append(i + 1).append(" : ").append(user.hand[i].getColor());
            }
        }

        if (hintList.toString().isBlank()) {
            hintList = new StringBuilder("\nAucune carte de couleur " + color);
        }

        return hintList.toString();
    }

    /** TODO Commenter le rôle (SRP) de cette méthode
     * @param user
     * @param token
     * @param value
     * @return rien
     */
    public String giveAHint(PlayerHand user, Token token, int value) {

        if (value < 0 || value > 5) {
            throw new IllegalArgumentException("La valeur doit Ãªtre comprise entre 0 et 5");
        }

        StringBuilder hintList = new StringBuilder();

        token.decToken();
        for (int i = 0; i < user.hand.length; i++) {
            if (user.hand[i].getValue() == value) {
                hintList.append("\nCarte en position ").append(i + 1).append(" : ").append(user.hand[i].getValue());
            }
        }

        if (hintList.toString().isBlank()) {
            hintList = new StringBuilder("\nAucune carte de valeur " + value);
        }

        return hintList.toString();
    }

    /**
     * Défausse d'une carte et pioche d'une nouvelle carte Ã  la place
     * @param position  la position de la carte à défausser
     * @param deck  la pioche dans laquelle repiocher une carte
     * @param token  le jeton qu'il faudra incrémenter (bleu s'il se dÃ©fausse
     *               volontairement, rouge s'il se défausse à cause d'une erreur)
     * @param discard  la défausse dans laquelle la carte sera placée
     * @return  la nouvelle main du joueur
     */
    public Card[] discardACard(int position, Deck deck, Token token, Discard discard) {


        if (token.getValue() < 8) {
            token.incToken();
        }
        for (int i = 0; i < discard.getCardList().length; i++ ) {
            if (discard.getCardList()[i] == null) {
                discard.getCardList()[i] = hand[position];
                break;
            }
        }
        if (deck.getNbCards() != 0) {
            drawACard(position, deck);
        }


        return null;
    }

    @Override
    public String toString() {
       StringBuilder handString;
       handString = new StringBuilder("Le joueur " + name + " a la main ");
        for (Card card : hand) {
            handString.append(card.toString()).append(" ");
        }
       return handString.toString();
    }
}
