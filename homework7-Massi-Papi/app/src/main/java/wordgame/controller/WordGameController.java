package wordgame.controller;

import wordgame.model.SecretWord;
import wordgame.view.WordGameGUI;

import wordgame.WordGameControllerInterface;

public class WordGameController implements WordGameControllerInterface {

    private WordGameGUI wordGameGUI;
    private SecretWord secretWord;
    private int count;
    
    public WordGameController(SecretWord secretWord) {
        this.secretWord = secretWord;
        this.wordGameGUI = new WordGameGUI(this, this.secretWord.getCurrentGuess());
        this.count = 0;
    }

    public boolean makeGuess(char letter) {
        boolean result = this.secretWord.makeGuess(letter);
        if (!result) {
            this.count++;
            System.out.println(this.count);
        }
        return result;
    }

    public String getCurrentGuess() {
        if (this.count < 5) {
            if (!this.secretWord.hasUnopenedLetters()) {
                this.wordGameGUI.disable();
                return "Congratulations, you guessed the word: " + this.secretWord.reveal();
            }
            return this.secretWord.getCurrentGuess();
        } else {
            this.wordGameGUI.disable();
            return "Sorry, you lost. The word was: " + this.secretWord.reveal();
        }
    }

    public int getCount() {
        return this.count;
    }
}
