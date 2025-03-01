/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Kamil Trela, Jun 2020
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    protected ArrayList<PlayingCard> cards;
    private int size;//the size of the grouping
    
    /**
     * no-arg constructor
     */
    public GroupOfCards(){
        
    }

    public GroupOfCards(int size) {
        this.size = size;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    public void shuffle(ArrayList deck) {
        Collections.shuffle(deck);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public void sortCards(){
        Collections.sort(cards);
    }

}//end class
