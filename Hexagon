package com.zetcode.fields;

import java.awt.*;

public class Hexagon implements Field{
    @Override
    public void draw(Graphics2D canvas, int windowWidth, int windowHeight, int cellSize, int x, int y){
        int[] xPoints = {
                x * cellSize + (int)(0.5 * windowWidth - (1.25)*cellSize),
                x * cellSize + (int)(0.5 * windowWidth - (0.75)*cellSize),
                (x+1)* cellSize + (int) (0.5 * windowWidth - (1.5) * cellSize),
                x * cellSize + (int)(0.5 * windowWidth - (0.75)*cellSize),
                x * cellSize + (int)(0.5 * windowWidth - (1.25)*cellSize),
                x * cellSize + (int) (0.5 * windowWidth - (1.5) * cellSize),
        };
        int[] yPoints = {
                y*cellSize+ (int) (0.5 * windowHeight - (1.5) * cellSize),
                y*cellSize+ (int) (0.5 * windowHeight - (1.5) * cellSize),
                y*cellSize+ (int) (0.5 * windowHeight -   cellSize),
                (y+1)*cellSize+ (int) (0.5 * windowHeight - (1.5) * cellSize),
                (y+1)*cellSize+ (int) (0.5 * windowHeight - (1.5) * cellSize),
                y*cellSize+ (int) (0.5 * windowHeight -   cellSize)
        };
        int nPoints = 6;
        canvas.drawPolygon(xPoints, yPoints, nPoints);
    }

}
