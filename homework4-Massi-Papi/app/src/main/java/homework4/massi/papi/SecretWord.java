package homework4.massi.papi;
import java.util.ArrayList;

public class SecretWord {

    private final String secretWord = "chocolate";

    // Find a way to add the character to replace the letter in the original array
    public ArrayList<Integer> checkCharacter(Character guessedCharacter) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guessedCharacter) {
                result.add(i);
            }
        }
        return result;
    }
    
}
