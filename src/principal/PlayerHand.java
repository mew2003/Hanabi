/*
 * PlayerHand.java                18/05/2022
 * Info1
 */

package principal;

/** 
 * Cr�er un "joueur" avec un nom
 * Ce joueur poss�de un main de cartes
 * Sa main est compos� de 5 cartes si le nombre de joueurs total est < 4
 * sinon il poss�de 4 cartes
 * Le joueur peut jouer une carte, d�fausser une carte ou donner un indice 
 * � un autre joueur
 * Lors de l'utilisation d'un indice, tous les joueurs perdent un jeton bleu,
 * il y en a en tout 8
 * Si un joueur joue une carte incorrecte, tous les joueurs se voit attribuer
 * un jeton rouge, au bout de 3 jetons rouges les joueurs perdent la partie
 * Si un joueur r�ussis � faire un "hanabi", tous les joueurs 
 * gagne un jeton bleu
 * 
 * @author S�bastien, Mewen, Maxime
 *
 */
public class PlayerHand {

	/** Le pseudo du joueur */
    private final String name;

    /** La main du joueur */
    private final Card[] hand;

    /**
     * D�finition d'une main de joueur,
     * Un joueur poss�de un nom et une main de cartes
     * La main du joueur est de 5 cartes si le nombre de joueurs total 
     * est inf�rieur � 4 sinon, la main du joueur est de 4 cartes.
     * @param name	    Nom du joueur
     * @param nbPlayer	Nombre de joueurs total
     * @param deck      La pioche qui sert � initialiser la main du joueur
     * @throws IllegalArgumentException si le nombre de joueurs 
     *         est invalide (inf�rieur � 2 ou sup�rieur � 5)
     */
    public PlayerHand(String name, int nbPlayer, Deck deck) {
        if (nbPlayer < 2) {
            throw new IllegalArgumentException("Le nombre de joueur doit �tre sup�rieur � 1");
        }
        if (nbPlayer > 5) {
            throw new IllegalArgumentException("Le nombre de joueur doit �tre inf�rieur � 6");
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
     * Choisit une carte al�atoirement dans la pioche et la place dans 
     * la main d'un joueur
     * @param position  La position � laquelle placer la carte
     * @param deck  La pioche dans laquelle est pioch� la carte
     */
    public void drawACard(int position, Deck deck) {
        if (position < 0 || position > hand.length) {
            throw new IllegalArgumentException("La position de la carte doit "
                                               + "�tre comprise entre 0 et "
                                               + hand.length);
        }
        
        hand[position] = deck.getCards();
    }

    /** 
     * Joue la carte s�lectionn�e
     * @param position la position de la carte dans la main du joueur
     * @param deck le deck dans lequel il pioche une carte 
     *        apr�s en avoir jouer une
     * @param redToken un jeton rouge est ajout� 
     *                 si la carte jou�e n'�tait pas correcte
     * @param blueToken un jeton bleu est ajout� si le joueur 
     *                  compl�te un "hanabi" (une suite de cartes dans une couleur) 
     * @param placedCard l'endroit o� est plac� la carte jou�e
     * @param discard l'endroit o� la carte invalide est envoy�
     * @return la carte que le joueur a jou�
     */
    public Boolean playACard(int position, Deck deck, Token redToken, Token blueToken, PlacedCard placedCard, Discard discard) {
        if (position < 0 || position > hand.length) {
            throw new IllegalArgumentException("La position de la carte doit �tre comprise entre 0 et " + hand.length);
        }
        boolean isSuccess;
        Card playCard = hand[position];
        isSuccess = placedCard.placeACard(playCard, blueToken);
        if (isSuccess) {
            if (deck.getNbCards() != 0) {
                drawACard(position, deck);
            } else {
                hand[position] = new Card("", 0);
            }
        } else {
            discardACard(position, deck, redToken, discard);
        }

        return isSuccess;
    }

    /** Donne un indice � un joueur sur la couleur de ses cartes
     * @param user le joueur � qui on donne un indice
     * @param token le jeton bleu utilis� pour donn� un indice
     * @param color la couleur donnée comme indice
     * @return la couleur et la position � laquelle est la couleur 
     *         dans la main du joueur � qui on donne l'indice
     */
    public String giveAHint(PlayerHand user, Token token, String color) {


        if (!color.equals("red") && !color.equals("blue") && !color.equals("pink") && !color.equals("yellow") && !color.equals("white")) {
            throw new IllegalArgumentException("La couleur doit �tre red / blue / pink / yellow / white");
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

    /** Donne un indice � un joueur sur la valeur de ses cartes
     * @param user le joueur � qui on donne un indice
     * @param token token le jeton bleu utilis� pour donn� un indice
     * @param value la valeur donn�e comme indice
     * @return la valeur et la position � laquelle est la valeur 
     *         dans la main du joueur � qui on donne l'indice
     */
    public String giveAHint(PlayerHand user, Token token, int value) {

        if (value < 0 || value > 5) {
            throw new IllegalArgumentException("La valeur doit �tre comprise entre 0 et 5");
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
     * D�fausse d'une carte et pioche d'une nouvelle carte � la place
     * @param position  la position de la carte � d�fausser
     * @param deck  la pioche dans laquelle piocher une carte
     * @param token  le jeton qu'il faudra incr�menter (bleu s'il se d�fausse
     *               volontairement, rouge s'il se d�fausse � cause d'une erreur)
     * @param discard  la d�fausse dans laquelle la carte sera plac�e
     * @return le nouvel �tat de la main du joueur
     */
    public Card discardACard(int position, Deck deck, Token token, Discard discard) {

    	Card discardCard = hand[position];

        if (token.getValue() < 8) {
            token.incToken();
        }
        for (int i = 0; i < discard.getCardList().length; i++ ) {
            if (discard.getCardList()[i] == null) {
                discard.getCardList()[i] = discardCard;
                break;
            }
        }
        if (deck.getNbCards() != 0) {
            drawACard(position, deck);
        } else {
            hand[position] = new Card("", 0);
        }

        return discardCard;
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
