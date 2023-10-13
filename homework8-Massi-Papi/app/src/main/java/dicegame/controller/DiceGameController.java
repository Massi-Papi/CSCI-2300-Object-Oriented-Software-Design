package dicegame.controller;

import dicegame.model.Roll;
import dicegame.view.DiceButton;
import dicegame.view.DiceGameGUI;

import dicegame.DiceGameControllerInterface;

public class DiceGameController implements DiceGameControllerInterface {
    private Roll rollModel;
    public DiceGameController() {
        this.rollModel = new Roll();
        DiceGameGUI gameGUI = new DiceGameGUI(this);
    }
    public void rollDice(DiceButton diceButton){
        rollModel.rollDice(diceButton);
    };
    public void rollAllDice(DiceButton[] diceButtons){
        rollModel.rollAllDice(diceButtons);
    }
}
