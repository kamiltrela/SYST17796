package ca.sheridancollege.project;

public class GoFishPlayer extends Player {

	private int gamesWon;
	private int numOfBooks;
        
        /**
         * no-arg constructor
         */
        public GoFishPlayer(){
            
        }

	/**
	 * 
	 * @param name
	 */
	public GoFishPlayer(String name) {
		// TODO - implement GoFishPlayer.GoFishPlayer
		//throw new UnsupportedOperationException();
                super(name);
	}

	public int getGamesWon() {
		return this.gamesWon;
	}

	/**
	 * 
	 * @param gamesWon
	 */
	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	public int getNumOfBooks() {
		return this.numOfBooks;
	}

	/**
	 * 
	 * @param numOfBooks
	 */
	public void setNumOfBooks(int numOfBooks) {
		this.numOfBooks = numOfBooks;
	}

        @Override
	public void play() {
		// TODO - implement GoFishPlayer.play
		throw new UnsupportedOperationException();
	}

}