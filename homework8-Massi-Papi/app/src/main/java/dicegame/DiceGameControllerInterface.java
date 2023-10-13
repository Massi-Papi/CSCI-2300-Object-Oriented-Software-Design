package dicegame;

import dicegame.view.DiceButton;

public interface DiceGameControllerInterface {
    public void rollDice(DiceButton diceButton);
    public void rollAllDice(DiceButton[] diceButtons);
}
