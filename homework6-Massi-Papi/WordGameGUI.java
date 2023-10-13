import java.awt.*;
import javax.swing.*;

public class WordGameGUI {

    public WordGameGUI(){
    
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel wordPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Word Game");
        JTextArea HiddenWord = new JTextArea();
        HiddenWord.setText("_ _ _ _ c _ _ a _ _");
        HiddenWord.setEditable(false);
        HiddenWord.setFont(new Font("Lucida Grande", Font.BOLD, 18));
        HiddenWord.setBackground(new Color(173, 216, 230));
        wordPanel.add(HiddenWord);
        wordPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        wordPanel.setBackground(new Color(173, 216, 230));

        
         panel.setBorder(BorderFactory.createEmptyBorder(100, 300, 100, 300));
         panel.setLayout(new GridLayout(3,9));
         panel.setBackground(new Color(173, 216, 230));
    
        

        for (char letter = 'a'; letter <= 'z'; letter++){
            JButton button = new JButton("" + letter);
            button.setPreferredSize(new Dimension(80,25));

            if (letter == 'a' || letter == 'c'){
                button.setEnabled(false);
            }
            
            panel.add(button);

        }
        
        frame.add(panel, BorderLayout.CENTER);
        frame.add(wordPanel, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);

        

    }

    public static void main(String[] args) {
        new WordGameGUI();
    }
}