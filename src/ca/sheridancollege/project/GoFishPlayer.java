package ca.sheridancollege.project;

/**
 * This class models the GoFish players. Its responsible for keeping tracks of games won. It also keeps track of the
 * number of books each player has.
 *
 * @author Kamil Trela, 2020
 * @author Estefania Melo, 2020
 */
public class GoFishPlayer extends Player {

    private int gamesWon;
    private int numOfBooks;

    /**
     * no-arg constructor
     */
    public GoFishPlayer() {

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

    /**
     * This method just adds one book to the players current book count
     */
    public void addOneBook() {
        this.numOfBooks++;
    }

    @Override
    public void play() {
//		// TODO - implement GoFishPlayer.play
//		throw new UnsupportedOperationException();
    }

}
