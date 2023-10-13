package wordgame;

import org.junit.*;
import static org.junit.Assert.*;
public class UsedLettersTest {
    @Test
    public void hasBeenUsedTest(){
        UsedLetters test = new UsedLetters();
        test.addLetter('c');
        test.addLetter('a');
        assertEquals("It has been used", true, test.hasBeenUsed('c'));
    }

    @Test
    public void hasBeenUsedCapitalLetterTest(){
        UsedLetters test = new UsedLetters();
        test.addLetter('C');
        test.addLetter('A');
        assertEquals("It has been used", true, test.hasBeenUsed('a'));
    }
 
}
