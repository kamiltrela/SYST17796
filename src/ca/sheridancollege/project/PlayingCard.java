package ca.sheridancollege.project;

/**
 * This is a class that models the PlayingCard. Includes enums for Suit and Values.
 * Code also includes the appropriate getters and setters for the data fields. 
 * @author Kamil Trela, 2020
 * @author Estefania Melo, 2020
 */

public class PlayingCard extends Card implements Comparable<PlayingCard>{

    @Override
    public int compareTo(PlayingCard o) {
        if (value.ordinal() > o.getValue().ordinal())
            return 1;
        else if (value.ordinal() < o.getValue().ordinal())
            return -1;
        else
            return 0;
    }

 

    public enum Suits {
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
    private Suits suits;

   
    /**
     *
     * @param value
     * @param suit
     */
    public PlayingCard(Value value, Suits suits) {
        this.value=value;
        this.suits=suits;
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

    public Suits getSuits() {
        return this.suits;
    }

    /**
     *
     * @param suit
     */
    public void setSuit(Suits suits) {
        this.suits = suits;
    }
    
    
       @Override
    public String toString() {
       return value + " of " + suits;
    }

 

}
