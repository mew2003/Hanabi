/*
 * Discard.java                18/05/2022
 * Info1
 */
package java;


/**
 * TODO le commentaire
 *
 */
public class Discard {

    private Card[] discard = new Card[50];

    // Pour éviter l'instanciation inutile
    private Discard() {}

    // Ajoute une carte à la défausse
    public Discard addCard(Card[] card) {
        return this; //stub
    }
}
