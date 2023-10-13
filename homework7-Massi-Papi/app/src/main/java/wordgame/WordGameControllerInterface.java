package wordgame;

public interface WordGameControllerInterface {
    public boolean makeGuess(char letter);
    public String getCurrentGuess();
    public int getCount();
}
