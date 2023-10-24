package com.zetcode.fields;

import java.awt.*;

public interface Field {
    void draw(Graphics2D canvas, int windowWidth, int windowHeight, int cellSize, int x, int y);
}