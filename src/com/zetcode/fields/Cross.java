package com.zetcode.fields;

import java.awt.*;

public class Cross implements Field {
    @Override
    public void draw(Graphics2D canvas, int windowWidth, int windowHeight, int cellSize, int x, int y) {
        canvas.drawLine(
                x * cellSize + (int) (0.5 * windowWidth - (1.5) * cellSize),
                y*cellSize+ (int) (0.5 * windowHeight - (1.5) * cellSize),
                (x+1)* cellSize + (int) (0.5 * windowWidth - (1.5) * cellSize),
                (y+1)*cellSize+ (int) (0.5 * windowHeight - (1.5) * cellSize)
        );
        canvas.drawLine(
                x * cellSize + (int) (0.5 * windowWidth - (1.5) * cellSize),
                (y+1)*cellSize+ (int) (0.5 * windowHeight - (1.5) * cellSize),
                (x+1)* cellSize + (int) (0.5 * windowWidth - (1.5) * cellSize),
                y*cellSize+ (int) (0.5 * windowHeight - (1.5) * cellSize)
        );
    }
}