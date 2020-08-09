package ca.sheridancollege.project;

/**
 * This is the Main class where we call the UserInterface class.
 * The main method only calls one method from the UserInterface class,
 * which handles the Go Fish game from start to finish.
 * 
 * @author Kamil Trela, 2020
 */
public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.playGoFish();

    }
}
