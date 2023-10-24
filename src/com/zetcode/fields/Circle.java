package com.zetcode.fields;

import java.awt.*;

public class Circle implements Field {
    @Override
    public void draw(Graphics2D canvas, int windowWidth, int windowHeight, int cellSize, int x, int y){
        canvas.fillOval(
                x * cellSize + (int) (0.5 * windowWidth - (1.25) * cellSize),
                y * cellSize + (int) (0.5 * windowHeight - (1.25) * cellSize),
                (int) (0.5 * cellSize - 1),
                (int) (0.5 * cellSize - 1)
        );

    }
}
