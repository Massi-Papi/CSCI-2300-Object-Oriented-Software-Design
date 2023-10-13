package dicegame.model;

import dicegame.view.DiceButton;

import java.util.Random;

public class Roll {
    public void rollDice(DiceButton diceButton) {
        Random random = new Random();
        int diceResult = random.nextInt(6) + 1;
        diceButton.setFaceValue(diceResult);
        diceButton.repaint();
    }
    public void rollAllDice(DiceButton[] diceButtons) {
        for (DiceButton die: diceButtons) {
            rollDice(die);
        }
    }
}
