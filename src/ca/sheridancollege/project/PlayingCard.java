package ca.sheridancollege.project;

/**
 * This is a class that models the PlayingCard. Includes enums for Suit and Values.
 * Code also includes the appropiate getters and setters for the data fields. 
 * @author Kamil Trela, 2020
 * @author Estefania Melo, 2020
 */

public class PlayingCard extends Card {

    public enum Suit {
        HEARTS,
        CLUBS, 
        SPADES, 
        DIAMONDS
    }

    public enum Value {
        ACE, 
        TWO, 
        THREE, 
        FOUR, 
        FIVE, 
        SIX, 
        SEVEN,
        EIGHT, 
        NINE, 
        TEN, 
        JACK, 
        QUEEN, 
        KING
    }

    private Value value;
    private Suit suit;

    /**
     *
     * @param value
     * @param suit
     */
    public PlayingCard(Value value, Suit suit) {
        // TODO - implement PlayingCard.PlayingCard
        throw new UnsupportedOperationException();
    }

    public Value getValue() {
        return this.value;
    }

    /**
     *
     * @param value
     */
    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    /**
     *
     * @param suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
