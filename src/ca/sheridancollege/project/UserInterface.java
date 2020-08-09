/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 * This class creates a new instance of GoFish,
 * it also starts the game by calling the setUpGame() method
 * and calls the play() method which cycles through the game until someone wins.
 *
 * @author Kamil Trela, 2020
 * @author Estefania Melo, 2020
 */
public class UserInterface {
    
    public UserInterface(){
        
    }

    public void playGoFish() {
        GoFish game = new GoFish("Go Fish");
        game.setUpGame();
        game.play();
    }
}
