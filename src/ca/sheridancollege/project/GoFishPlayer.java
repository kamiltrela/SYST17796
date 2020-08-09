package ca.sheridancollege.project;

/**
 * This class models the GoFish players. Its responsible for keeping tracks of games won. 
 * It also keeps track of the number of books each player has.
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
        //intentionally left blank
    }

    /**
     * Constructor that takes in the name of the player. 
     * @param name: input for player name.
     */
    public GoFishPlayer(String name) {
        super(name);
    }

    /**
     * Getter for gamesWon.
     * @return int: number of games won by a player. 
     */
    public int getGamesWon() {
        return this.gamesWon;
    }

    /**
     * Setter for gamesWon.
     * @param gamesWon: input for number of games won.
     */
    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    /**
     * Getter for numOfBooks
     * @return int: the number of books a player has.
     */
    public int getNumOfBooks() {
        return this.numOfBooks;
    }

    /**
     * Setter for numOfBooks 
     * @param numOfBooks: input for the number of books a player has.
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
        //intentionally left blank
    }

}
