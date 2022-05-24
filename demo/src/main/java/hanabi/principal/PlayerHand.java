package principal;

import java.util.Arrays;

public class PlayerHand {

    private String name;

    private Card[] hand;

    /**
     * Définition d'une main de joueur,
     * Un joueur possède un nom et une main de cartes
     * La main du joueur est de 5 cartes si le nombre de joueurs total est inférieur à 4
     * Sinon, la main du joueur est de 4 cartes.
     * @param name Nom du joueur
     * @param nbPlayer Nombre de joueurs total
     * @throws IllegalArgumentException si le nombre de joueurs est invalide (inférieur à 2 ou supérieur à 5)
     */
    public PlayerHand(String name, int nbPlayer, Deck deck) {
        if (nbPlayer < 2) {
            throw new IllegalArgumentException("Le nombre de joueur doit être supérieur à 1");
        }
        if (nbPlayer > 5) {
            throw new IllegalArgumentException("Le nombre de joueur doit être inférieur à 6");
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

    public String getName() {
        return name;
    }

    public Card[] getHand() {
        return hand;
    }

    public Card drawACard(int position, Deck deck) {
        if (position < 0 || position > hand.length) {
            throw new IllegalArgumentException("La position de la carte doit être comprise entre 0 et " + hand.length);
        }
        hand[position] = deck.getCards();
        return null; //Stub
    }

    public Card discardACard(int position) {
        return null; //Stub
    }

    public Card playACard(int position) {
        return null; //Stub
    }

    public PlayerHand giveAHint(PlayerHand user, int position, String color, int value) {
        return null; //Stub
    }

    @Override
    public String toString() {
       String handString;
       handString = "Le joueur " + name + " a la main ";
       for (int i = 0; i < hand.length; i++) {
           handString += hand[i].toString() + " ";
       }
       return handString;
    }
}
