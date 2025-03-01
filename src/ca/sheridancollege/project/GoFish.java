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
 * @author Estefania Melo, 2020
 */
public class GoFish extends Game {

    private final int REQUIRED_PLAYERS = 2;
    private int numOfPlayers;

    private GroupOfCards playerOneHand = new GroupOfCards();
    private GroupOfCards playerTwoHand = new GroupOfCards();

    private GoFishPlayer player1 = new GoFishPlayer();
    private GoFishPlayer player2 = new GoFishPlayer();

    private DeckOfCards deck = new DeckOfCards();

    private int currentPlayer = 0;

    /**
     * One argument constructor
     *
     * @param name : input for name
     */
    public GoFish(String name) {
        super(name);
    }

    /**
     * Gettter for numOfPlayers
     *
     * @return : number of players in game currently
     */
    public int getNumOfPlayers() {
        return this.numOfPlayers;
    }

    /**
     * Setter for numOfPlayers
     *
     * @param numOfPlayers : input for numOfPlayers
     */
    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    /**
     * Getter for playerOneHand
     *
     * @return : player one hand of cards
     */
    public GroupOfCards getPlayerOneHand() {
        return this.playerOneHand;
    }

    /**
     * This method sets the card hand for player 1
     *
     * @param playerOneHand : input for playerOneHand
     */
    public void setPlayerOneHand(GroupOfCards playerOneHand) {
        this.playerOneHand = playerOneHand;
    }

    /**
     * Getter for playerTwoHand
     *
     * @return : player two hand of cards
     */
    public GroupOfCards getPlayerTwoHand() {
        return this.playerTwoHand;
    }

    /**
     * This method sets the card hand for player 2
     *
     * @param playerTwoHand : input for playerTwoHand
     */
    public void setPlayerTwoHand(GroupOfCards playerTwoHand) {
        this.playerTwoHand = playerTwoHand;
    }

    /**
     * The play() method will handle the main game loop. The loop consists of handing each player 7 cards, starting
     * player is chosen randomly. Starting player asks the opponent for a card, if opponent has requested card, they
     * must hand it over. If opponent does not have requested card, player must draw a card. This repeats until 13 books
     * are obtained.
     */
    @Override
    public void play() {
        Scanner sc = new Scanner(System.in);

        do {

            if (currentPlayer == 1) {
                // sort player hand
                playerOneHand.sortCards();

                // player asks for card from opponent
                PlayingCard askingCard = askForCard(player1, playerOneHand);

                // cards from opponent are saved in new ArrayList
                ArrayList givenCards = checkForCard(askingCard, playerTwoHand, player2, player1);

                // cards returned from opponent added to player hand
                playerOneHand.cards.addAll(givenCards);

                // check if player has a book, if they do remove the book and return the remaining cards
                playerOneHand = collectBook(playerOneHand, player1);

                currentPlayer = 2;
            } else if (currentPlayer == 2) {
                // sort player hand
                playerTwoHand.sortCards();

                // player asks for card from opponent
                PlayingCard askingCard = askForCard(player2, playerTwoHand);

                // cards from opponent are saved in new ArrayList
                ArrayList givenCards = checkForCard(askingCard, playerOneHand, player1, player2);

                // cards returned from opponent added to player hand
                playerTwoHand.cards.addAll(givenCards);

                // check if player has a book, if they do remove the book and return the remaining cards
                playerTwoHand = collectBook(playerTwoHand, player2);

                currentPlayer = 1;
            }
        } while ((player1.getNumOfBooks() + player2.getNumOfBooks()) < 13);

        declareWinner();

    }

    /**
     * This method declares a winner based on which player has the greater number of books and prints out a statement to
     * the console based on the winner
     *
     */
    @Override
    public void declareWinner() {
        if (player1.getNumOfBooks() < player2.getNumOfBooks()) {
            System.out.println(player2.getName() + " has won!");
            System.out.println(player2.getName() + "s score was: " + player2.getNumOfBooks());
            player2.setGamesWon(player2.getGamesWon() + 1);
        } else {
            System.out.println(player1.getName() + " has won!");
            System.out.println(player1.getName() + "s score was: " + player1.getNumOfBooks());
            player1.setGamesWon(player1.getGamesWon() + 1);
        }
    }

    /**
     * This method checks a card against every card in the players hand. If a player has the 4 cards needed to collect a
     * book then the book is collected, if they don't have the cards needed, the book is cleared.
     *
     * @param playerHand: input for current players hand.
     * @param player: input for the current player.
     * @return : GroupOfCards, remaining cards after a book is removed, or return input hand.
     */
    public GroupOfCards collectBook(GroupOfCards playerHand, GoFishPlayer player) {

        GroupOfCards tempHand = playerHand;
        ArrayList<PlayingCard> book = new ArrayList<>();

        //The following loops checks each card against every other card in the players hand.
        for (int i = 0; i < playerHand.cards.size(); i++) {
            PlayingCard checkingAgainstCard = playerHand.cards.get(i);

            int count = 0;
            for (int j = 0; j < playerHand.cards.size(); j++) {
                if (checkingAgainstCard.getValue() == playerHand.cards.get(j).getValue()) {
                    if (checkingAgainstCard.getSuits() != playerHand.cards.get(j).getSuits()) {
                        count++;
                        book.add(playerHand.cards.get(j));
                    }
                }
            }

            //if 3 cards with matching values are found, all 4 cards of same value are removed.
            if (count == 3) {
                book.add(checkingAgainstCard);
                playerHand.cards.removeAll(book);
                player.addOneBook();
                System.out.println(player.getName() + " collected a book of " + checkingAgainstCard.getValue() + "s!");
                System.out.println(player.getName() + " has " + player.getNumOfBooks() + " book(s)");
            } else if (count < 3) {
                book.clear();
            }

        }
        System.out.println("");
        return playerHand;
    }

    /**
     * This class will prompt a user if it is their turn, the players hand will be displayed and the user will choose a
     * card by entering a number.
     *
     * @param player: the player whose turn it is.
     * @param hand: input for players hand of cards.
     * @return : PlayingCard, card of value the player asks opponent for.
     */
    public PlayingCard askForCard(GoFishPlayer player, GroupOfCards hand) {
        Scanner sc = new Scanner(System.in);
        boolean validNumber = false;
        PlayingCard askingCard = null;

        if (hand.cards.isEmpty() && !deck.deckOfCardsList.isEmpty()) {
            System.out.println(player.getName() + " has no cards.");
            PlayingCard card = deck.drawACard();
            System.out.println(player.getName() + " draws a " + card);
            hand.cards.add(card);
        }

        System.out.println(player.getName() + ", it is your turn, here are your cards: ");

        //print all the cards in the users hand
        for (int i = 0; i < hand.cards.size(); i++) {
            System.out.println((i + 1) + ": " + hand.cards.get(i));
        }

        while (!validNumber) {
            //if statement check if the playerHand is empty and if the deck is NOT empty
            if (hand.cards.isEmpty() && !deck.deckOfCardsList.isEmpty()) {
                hand.cards.add(deck.drawACard());
            } else if (hand.cards.isEmpty() && deck.deckOfCardsList.isEmpty()) {
                declareWinner();
                break;
            }

            try {
                //get user input to see which card they want to ask for
                System.out.print("Choose a card value to ask for by entering the associated number: ");
                String user = sc.nextLine();
                int userChoice = Integer.parseInt(user) - 1;
                askingCard = hand.cards.get(userChoice);
                validNumber = true;
                System.out.println("\n" + player.getName() + " says: \"give me all of your "
                        + askingCard.getValue() + "s\"");
            } catch (NumberFormatException e1) {
                System.out.println("Enter only integer numbers, don't enter letters or spaces");

            } catch (IndexOutOfBoundsException e2) {
                System.out.println("Choose one of the numbers on the left side of your cards.");
            }
        }

        return askingCard;
    }

    /**
     * This method will check an opponents hand for cards of the same value as the ones the current player is asking
     * for.
     *
     * @param askingCard : card the current player is asking for
     * @param opponentHand : current players opponents card hand
     * @param opponent : input for current players opponent
     * @param player : input for current player
     * @return ArrayList of type PlayingCard : contains all cards of same value as input card
     */
    public ArrayList<PlayingCard> checkForCard(PlayingCard askingCard,
            GroupOfCards opponentHand,
            GoFishPlayer opponent,
            GoFishPlayer player) {
        ArrayList<PlayingCard> cardsToGive = new ArrayList<>();

        if (!opponentHand.cards.isEmpty()) {
            //This loop checks askingCard against opponentHand 
            for (int i = 0; i < opponentHand.cards.size(); i++) {
                PlayingCard temp = opponentHand.cards.get(i);
                if (askingCard.getValue() == temp.getValue()) {
                    System.out.println(opponent.getName() + " hands over a: " + temp);
                    cardsToGive.add(temp);
                }
            }
        }

        // If opponent has no cards to give and the deck is not empty, a card is drawn
        if (cardsToGive.isEmpty() && !deck.deckOfCardsList.isEmpty()) {
            System.out.println(opponent.getName() + " says: \"Go fish!\"");
            PlayingCard drawnCard = deck.drawACard();
            System.out.println(player.getName() + " drew a " + drawnCard);
            cardsToGive.add(drawnCard);
        } else if (deck.deckOfCardsList.isEmpty()) {
            System.out.println("The deck has no cards");
        }
        opponentHand.cards.removeAll(cardsToGive);
        return cardsToGive;
    }

    /**
     * This method sets up the game by asking the player for their name. It also loops until the required number of
     * players are registered.
     */
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
                        } catch (IllegalArgumentException e) {
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
                            if (player2.getName().equals(player1.getName())) {
                                validName = false;
                                System.out.print("Please choose a unique name for player 2: ");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (!validName);
                }

                numOfPlayers++;

            }
        }
        generateDeckAndHand();
        chooseStartPlayer();

    }

    /**
     * This method generates a deck to play with and distributes a hand to each player
     */
    public void generateDeckAndHand() {
        //generate a deck of cards to play with
        deck.generateDeck();

        //hand 7 cards to each player from the deck
        playerOneHand.cards = deck.distributeHand();
        playerTwoHand.cards = deck.distributeHand();

    }

    /**
     * This method randomly decides which player will begin.
     */
    public void chooseStartPlayer() {
        double random = Math.random();
        if (random > 0.5) {
            currentPlayer = 1;
            System.out.println("\n" + player1.getName() + " will start first!" + "\n");
        } else if (random <= 0.5) {
            currentPlayer = 2;
            System.out.println("\n" + player2.getName() + " will start first!" + "\n");
        }
    }

}
