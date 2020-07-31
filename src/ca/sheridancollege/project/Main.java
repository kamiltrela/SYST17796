package ca.sheridancollege.project;

public class Main {
    
    public static void main(String[] args){
        
        DeckOfCards deck = new DeckOfCards();
        deck.generateDeck();
        //System.out.println(deck.deckOfCardsList);
        deck.shuffle(deck.deckOfCardsList);
        System.out.println(deck.deckOfCardsList);
    }
}