package ca.sheridancollege.project;


import ca.sheridancollege.project.PlayingCard.Suits;
import ca.sheridancollege.project.PlayingCard.Value;
import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author Kamil Trela, Jun 2020
 * @author Estefania Melo, 2020
 */

public class DeckOfCards extends GroupOfCards {

	protected ArrayList<PlayingCard> deckOfCardsList = new ArrayList<PlayingCard>();

	public DeckOfCards() {

	}

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

	public PlayingCard drawACard() {
            PlayingCard temp1 = deckOfCardsList.get(0);
            deckOfCardsList.remove(0);
            
            return temp1;
	}

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