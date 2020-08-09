package ca.sheridancollege.project;


import ca.sheridancollege.project.PlayingCard.Suits;
import ca.sheridancollege.project.PlayingCard.Value;
import java.util.ArrayList;

/**
 * This class handles the functionality of how the deck works through the methods
 * of distributing a hand to the player, allowing the player to draw a card, and 
 * generating a new deck for the game.
 * @author Kamil Trela, Jun 2020
 * @author Estefania Melo, 2020
 */

public class DeckOfCards extends GroupOfCards {

	protected ArrayList<PlayingCard> deckOfCardsList = new ArrayList<PlayingCard>();

	public DeckOfCards() {

	}

        /**
         * This method distributes a hand to each player 
         * @return ArrayList: 7 cards off the top of the deck.
         */
	public ArrayList distributeHand() {
         
            DeckOfCards temp = new DeckOfCards();
            temp.shuffle(deckOfCardsList);
            ArrayList<PlayingCard> handList = new ArrayList<PlayingCard>();
            
            for (int i = 0; i < 7; i++) {
                handList.add(deckOfCardsList.get(i));
                deckOfCardsList.remove(handList.get(i));
                
            }
                      
            return handList;

	}

        /**
         * This method allows a player to draw a card from the deck 
         * @return PlayingCard: one card from the top of the deck.
         */
	public PlayingCard drawACard() {
            PlayingCard temp1 = null;
            if(!deckOfCardsList.isEmpty()){
                temp1 = deckOfCardsList.get(0);
                deckOfCardsList.remove(0);
            } 
   
            return temp1;
	}

        /**
         * This method generates a deck using the enums from the PlayinCard class.
         */
	public void generateDeck() {
            PlayingCard.Suits.values();
            PlayingCard.Value.values();
            
            for(Suits suits: Suits.values()){
                for (Value value: Value.values()){
                    PlayingCard dc = new PlayingCard(value,suits);
                    deckOfCardsList.add(dc);
                }
                
                
            }
            
	}

    @Override
    public String toString() {
        return "DeckOfCards{" + "deckOfCardsList=" + deckOfCardsList + '}';
    }
        
        

}