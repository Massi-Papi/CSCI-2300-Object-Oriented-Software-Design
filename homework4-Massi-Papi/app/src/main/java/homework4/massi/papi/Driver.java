package homework4.massi.papi;
import java.util.Scanner;

//Print out after incorrect guess: "No such letter. You have (number) incorrect attempts left" and then print out current guess 
//Print out "Guess a letter: " then takes user input. runs user input through the loop of "SecretWord.java"
//Print out after correct guess: "Your current guess is:" with current situation of array.

public class Driver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        User user = new User();

        System.out.println("Welcome to the word guessing game");
        System.out.println("Guess the secret word: _________");
        
        while (!user.isGameOver()) {
            System.out.println("Guess a letter:");
            boolean status = user.checkGuessedCharacter(input.nextLine().charAt(0));
            if (!status) {
                System.out.println("No such letter. You have " + user.getRemainingGuesses() + " incorrect attempts left");
            }
            System.out.println("Your current guess: " + user.getCurrentGuessedWord());
        }
        if (user.didWin()) {
            System.out.println("Congrats! You guessed the secret word");
        } else {
            System.out.println("You lose! The secret code was: chocolate");
        }
        
        input.close();
    }
}
