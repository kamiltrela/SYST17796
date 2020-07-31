package ca.sheridancollege.project;

public class GoFish extends Game {

	private int REQUIRED_PLAYERS;
	private int currentPlayers;
	private GroupOfCards playerOneHand;
	private GroupOfCards playerTwoHand;

	public GoFish(String name) {
		// TODO - implement GoFish.GoFish
		//throw new UnsupportedOperationException();
                super(name);
	}

	public int getCurrentPlayers() {
		return this.currentPlayers;
	}

	/**
	 * 
	 * @param currentPlayers
	 */
	public void setCurrentPlayers(int currentPlayers) {
		this.currentPlayers = currentPlayers;
	}

	public GroupOfCards getPlayerOneHand() {
		return this.playerOneHand;
	}

	/**
	 * 
	 * @param playerOneHand
	 */
	public void setPlayerOneHand(GroupOfCards playerOneHand) {
		this.playerOneHand = playerOneHand;
	}

	public GroupOfCards getPlayerTwoHand() {
		return this.playerTwoHand;
	}

	/**
	 * 
	 * @param playerTwoHand
	 */
	public void setPlayerTwoHand(GroupOfCards playerTwoHand) {
		this.playerTwoHand = playerTwoHand;
	}

	public void play() {
		// TODO - implement GoFish.play
		throw new UnsupportedOperationException();
	}

	public void declareWinner() {
		// TODO - implement GoFish.declareWinner
		throw new UnsupportedOperationException();
	}

	public void collectBook() {
		// TODO - implement GoFish.collectBook
		throw new UnsupportedOperationException();
	}

	public void askForCard() {
		// TODO - implement GoFish.askForCard
		throw new UnsupportedOperationException();
	}

	public void setUpGame() {
		// TODO - implement GoFish.setUpGame
		throw new UnsupportedOperationException();
	}

}