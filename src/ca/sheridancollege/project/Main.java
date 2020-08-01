package ca.sheridancollege.project;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

//        DeckOfCards deck = new DeckOfCards();
//
//        deck.generateDeck();
//        //System.out.println(deck.deckOfCardsList);
//        deck.shuffle(deck.deckOfCardsList);
//        System.out.println(deck.deckOfCardsList);
//
//        System.out.println(deck.deckOfCardsList.size());
//        ArrayList tempHand = new ArrayList();
//
//        tempHand = deck.distributeHand();
//        System.out.println(tempHand);
//        System.out.println(deck.deckOfCardsList.size());
//
//        System.out.println(deck.drawACard());
//        System.out.println(deck.deckOfCardsList.size());

           GoFish game = new GoFish("Go Fish");
           game.setUpGame();
           game.play();

    }
}
