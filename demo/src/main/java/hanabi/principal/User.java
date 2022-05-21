/*
 * principal.java                18/05/2022
 * Info1
 */
package principal;

import principal.Card;

public class User {

    private String[] usernames;

    public User(String[] username) {
        if (username.length > 5 || username.length < 2) {
            throw new IllegalArgumentException("Le nombre d'utilisateurs est trop grand");
        }
        this.usernames = username;
    }

    public String[] getUsernames() {
        return usernames;
    }

    public User setUserHand(int position, Card card) {
        this.usernames = ;
        return this;
    }

}
