package dicegame.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import dicegame.DiceGameControllerInterface;

public class DiceGameGUI
{
   private JFrame frame;
   private DiceButton diceButton1;
   private DiceButton diceButton2;
   private DiceButton diceButton3;
   private JButton rollAllButton;
   private DiceGameControllerInterface controller;

   public DiceGameGUI(DiceGameControllerInterface controller)
   {
      this.controller = controller;
      frame = new JFrame("Dice Game");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 300);
      frame.getContentPane().setLayout(new BorderLayout());

      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new FlowLayout());

      diceButton1 = createDiceButton();
      diceButton2 = createDiceButton();
      diceButton3 = createDiceButton();

      buttonPanel.add(diceButton1);
      buttonPanel.add(diceButton2);
      buttonPanel.add(diceButton3);

      frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

      rollAllButton = new JButton("Roll All Dice");
      rollAllButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            DiceButton[] diceButtons = {diceButton1, diceButton2, diceButton3};
            controller.rollAllDice(diceButtons);
          }
      });

      frame.getContentPane().add(rollAllButton, BorderLayout.SOUTH);

      frame.pack();
      frame.setVisible(true);
   }

   private DiceButton createDiceButton() {
      Random random = new Random();
      int faceValue = random.nextInt(6) + 1;
      DiceButton diceButton = new DiceButton(faceValue);
      diceButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            controller.rollDice(diceButton);
         }
     });
      return diceButton;
  }
}
