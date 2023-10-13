package wordgame;

import java.util.ArrayList;

public class UsedLetters {
    private ArrayList<Character> usedLetters;

    public UsedLetters(){
        this.usedLetters = new ArrayList<Character>();
    }

    public void addLetter(char letter) {
        this.usedLetters.add(Character.toLowerCase(letter));
    }

    public boolean hasBeenUsed(char letter){
        return this.usedLetters.contains(Character.toLowerCase(letter));
    }
}
