package homework4.massi.papi;
import java.util.ArrayList;

public class User {
    private int remainingGuesses;
    private SecretWord secretWord;
    private String currentGuessedWord;
    private ArrayList<Character> alreadyGuessedCharacterList;

    public User() {
        this.remainingGuesses = 5;
        this.secretWord = new SecretWord();
        this.alreadyGuessedCharacterList = new ArrayList<Character>();
        this.currentGuessedWord = "_________";
    }

    public boolean checkGuessedCharacter(Character guessedCharacter) {
        ArrayList<Integer> result = secretWord.checkCharacter(guessedCharacter);
        if (this.alreadyGuessedCharacter(guessedCharacter) || result.size() == 0) {
            this.remainingGuesses--;
            return false;
        } else {
            this.alreadyGuessedCharacterList.add(guessedCharacter);
            for (int index: result) {
                currentGuessedWord = currentGuessedWord.substring(0, index) + guessedCharacter + currentGuessedWord.substring(index + 1);
            }
            return true;
        }
    }

    public boolean alreadyGuessedCharacter(Character guessedCharacter){
        for (int i = 0; i < this.alreadyGuessedCharacterList.size(); i++) {
            if (this.alreadyGuessedCharacterList.get(i) == guessedCharacter) {
                return true;
            }
        }
        return false;
    }
    public boolean isGameOver(){
        if (remainingGuesses == 0 || this.didWin()){
            return true;
        }
        return false;
    }

    public boolean didWin() {
        return this.currentGuessedWord.equals("chocolate");
    }

    public String getCurrentGuessedWord() {
        return this.currentGuessedWord;
    }

    public int getRemainingGuesses() {
        return this.remainingGuesses;
    }
}
