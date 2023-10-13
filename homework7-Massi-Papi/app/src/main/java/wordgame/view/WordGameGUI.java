package wordgame.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import wordgame.WordGameControllerInterface;

public class WordGameGUI implements ActionListener
{
   private JFrame mainFrame;
   private JPanel mainPanel;
   private LetterButtons buttons;

   // user's current guess will be shown here
   private JLabel wordLabel;
   private JLabel guessCounterLabel;

   private WordGameControllerInterface controller;

   public WordGameGUI(WordGameControllerInterface controller, String initialDisplay)
   {

      // hard-coded placeholder word, needs to be replaced with a real word used in the game
      // Make new object for dictionary class 

      this.controller = controller;

      String word = new String(initialDisplay);
      wordLabel = new JLabel(word);
      wordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      String guessStatus = new String("Allowed incorrect guess: " + (5 - controller.getCount()));
      guessCounterLabel = new JLabel(guessStatus);
      guessCounterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      JFrame mainFrame = new JFrame("Word Game");
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      mainPanel = new JPanel();
      mainPanel.setBackground(new Color(171, 229, 245));
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
      mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      mainPanel.add(wordLabel);

      buttons = new LetterButtons(this); // passing 'this' object as the ActionListener

      buttons.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      buttons.setOpaque(false);
      mainPanel.add(buttons);

      mainPanel.add(guessCounterLabel);

      mainFrame.add(mainPanel);

      mainFrame.pack();
      mainFrame.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent event)
   {
      // get the source component that triggered this event
      // and cast it to a JButton
      JButton button = (JButton)event.getSource();
      String text = button.getText();
      button.setEnabled(false);
      char letter = text.charAt(0);
      System.out.println("User selected "+letter);

      // TODO: tell the controller about the user's choice
      boolean result = controller.makeGuess(letter);
      wordLabel.setText(controller.getCurrentGuess());
      guessCounterLabel.setText("Allowed incorrect guess: " + (5 - controller.getCount()));
   }

   public void disable() {
      this.buttons.disableAll();
   }
}
