package dicegame.view;

import javax.swing.*;
import java.awt.*;

public class DiceButton extends JButton {
    private int face;

    public DiceButton(int face) {
        this.face = face;
        setFocusPainted(false);
        setPreferredSize(new Dimension(50, 50));
    }

    public void setFaceValue(int face) {
        this.face = face;
    }

    @Override
    protected void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        drawDice(graphic, face);
    }

    private void drawDice(Graphics graphic, int face) {
        int size = Math.min(getWidth(), getHeight());
        int dotSize = size / 8;

        graphic.setColor(Color.WHITE);
        graphic.fillRoundRect(0, 0, size, size, dotSize * 2, dotSize * 2);

        graphic.setColor(Color.BLACK);
        if (face % 2 == 1) {
            drawDot(graphic, size / 2, size / 2, dotSize);
        }
        if (face > 1) {
            drawDot(graphic, size / 4, size / 4, dotSize);
            drawDot(graphic, size * 3 / 4, size * 3 / 4, dotSize);
        }
        if (face > 3) {
            drawDot(graphic, size * 3 / 4, size / 4, dotSize);
            drawDot(graphic, size / 4, size * 3 / 4, dotSize);
        }
    }

    private void drawDot(Graphics graphic, int x, int y, int dotSize) {
        graphic.fillOval(x - dotSize / 2, y - dotSize / 2, dotSize, dotSize);
    }
}
