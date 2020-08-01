package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class will handle Go Fish game functionality. This class will first store the number of players, the game can
 * begin once two players have registered. Each players hand will be stored in this class. Common game functionality
 * like starting the game, asking for cards, collecting books and declaring a winner, will also be handled by this
 * class.
 *
 * @author Kamil Trela, 2020
 */
public class GoFish extends Game {

    private int REQUIRED_PLAYERS = 2;
    private int numOfPlayers;
    private GroupOfCards playerOneHand = new GroupOfCards();
    private GroupOfCards playerTwoHand = new GroupOfCards();
    private GoFishPlayer player1 = new GoFishPlayer();
    private GoFishPlayer player2 = new GoFishPlayer();

    private DeckOfCards deck = new DeckOfCards();

    private int currentPlayer = 0;

    /**
     * One argument
     *
     * @param name
     */
    public GoFish(String name) {
        // TODO - implement GoFish.GoFish
        //throw new UnsupportedOperationException();
        super(name);
    }

    public int getNumOfPlayers() {
        return this.numOfPlayers;
    }

    /**
     * Setter for numOfPlayers
     *
     * @param numOfPlayers
     */
    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
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

    /**
     * The play() method will handle the main game loop. The loop consists of handing each player 7 cards, starting
     * player is chosen randomly. Starting player asks the opponent for a card, if opponent has requested card, they
     * must hand it over. If opponent does not have requested card, player must draw a card.
     */
    @Override
    public void play() {
        Scanner sc = new Scanner(System.in);

        if (currentPlayer == 1) {
            PlayingCard askingCard = askForCard(player1, playerOneHand);
            checkForCard(askingCard, playerTwoHand);
        } else if (currentPlayer == 2) {
            PlayingCard askingCard = askForCard(player2, playerTwoHand);
            checkForCard(askingCard, playerOneHand);
        }

    }

    @Override
    public void declareWinner() {
        // TODO - implement GoFish.declareWinner
        throw new UnsupportedOperationException();
    }

    public void collectBook() {
        // TODO - implement GoFish.collectBook
        throw new UnsupportedOperationException();
    }

    /**
     * This class will prompt a user if it is their turn,
     * the players hand will be displayed and the user will choose a card
     * by entering a number.
     * @param player
     * @param hand 
     */
    public PlayingCard askForCard(GoFishPlayer player, GroupOfCards hand) {
        Scanner sc = new Scanner(System.in);

        System.out.println(player.getName() + ", it is your turn, here are your cards: \n");

        //print all the cards in the users hand
        for (int i = 0; i < hand.cards.size(); i++) {
            System.out.println((i + 1) + ": " + hand.cards.get(i));
        }

        //get user input to see which card they want to ask for
        System.out.print("Choose a card to ask for by entering the associated number: ");
        int userChoice = sc.nextInt() - 1;
        PlayingCard askingCard = (PlayingCard) hand.cards.get(userChoice);
        System.out.println(player.getName() + " says: \"give me all of your "
                + askingCard.getValue() + "s\"");
        
        return askingCard;
    }
    /**
     * This method will check an opponents hand for cards of the same value as 
     * the ones the current player is asking for.
     * @param askingCard : card the current player is asking for
     * @param opponentHand : current players opponents card hand
     * @return ArrayList of type PlayingCard : contains all cards of same value as input card 
     */
    public ArrayList<PlayingCard> checkForCard(PlayingCard askingCard, GroupOfCards opponentHand){
        ArrayList<PlayingCard> cardsToGive = new ArrayList<>();
        
        for (int i = 0; i < opponentHand.cards.size(); i++) {
           PlayingCard temp = (PlayingCard) opponentHand.cards.get(i); 
           if(askingCard.getValue() == temp.getValue()){
               System.out.println("found a match!");
               System.out.println(temp);
               cardsToGive.add(temp);
               opponentHand.cards.remove(temp);
           }
        }
        
        if(cardsToGive.isEmpty()){
            System.out.println("Go fish!");
        }
        return cardsToGive;
    }

    public void setUpGame() {
        System.out.println("Welcome to Go Fish!");
        System.out.println("2 Players are required to play the game");

        /**
         * The following block of code adds each users username to their respective GoFishPlayer object.
         */
        Scanner sc = new Scanner(System.in);
        while (numOfPlayers < REQUIRED_PLAYERS) {
            for (int i = 0; i < REQUIRED_PLAYERS; i++) {
                System.out.print("Player " + (i + 1) + " enter your name: ");

                boolean validName = false;
                
                //set player1 name
                if (numOfPlayers == 0) {
                    do {
                        try {
                            player1.setName(sc.nextLine());
                            validName = true;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } while (!validName);
                }

                //set player2 name
                if (numOfPlayers == 1) {
                    do {
                        try {
                            player2.setName(sc.nextLine());
                            validName = true;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } while (!validName);
                }

                numOfPlayers++;

            }
        }

        //generate a deck of cards to play with
        deck.generateDeck();

        //hand 7 cards to each player from the deck
        playerOneHand.cards = deck.distributeHand();
        playerTwoHand.cards = deck.distributeHand();

        //choose the starting player randomly
        if (Math.random() != 0.5) {
            currentPlayer = 1;
            System.out.println(player1.getName() + " will start first!");
        }
        else if(Math.random() == 0.5){
            currentPlayer = 2;
            System.out.println(player2.getName() + " will start first!");
        }

    }

}
