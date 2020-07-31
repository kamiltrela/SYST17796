package ca.sheridancollege.project;

public class PlayingCard extends Card {

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