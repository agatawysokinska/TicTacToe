package com.zetcode;

import com.zetcode.fields.Field;

import java.awt.*;

public class Board {
    public Field[][] fields;

    Board(){
        this.fields=new Field[3][3];
    }

    public void draw(Graphics2D canvas, int windowWidth, int windowHeight, int cellSize, Line line)
    {
        for (int i = 0; i < 4; i++) {
            canvas.drawLine(
                    (int) (0.5 * windowWidth - (1.5) * cellSize),
                    (int) ((0.5 * windowHeight - (1.5) * cellSize) + i * cellSize),
                    (int) (0.5 * windowWidth + (1.5) * cellSize),
                    (int) ((0.5 * windowHeight - (1.5) * cellSize) + i * cellSize)
            );

            canvas.drawLine(
                    (int) ((0.5 * windowWidth - (1.5) * cellSize) + i * cellSize),
                    (int) ((0.5 * windowHeight - (1.5) * cellSize)),
                    (int) ((0.5 * windowWidth - (1.5) * cellSize) + i * cellSize),
                    (int) ((0.5 * windowHeight + (1.5) * cellSize))
            );
        }

        for(int x=0; x<3; x++) {
            for(int y=0; y<3; y++) {
                Field field = fields[x][y];
                if (field != null) {
                    field.draw(canvas,windowWidth, windowHeight,cellSize,x,y);
                }
            }
        }
        if(line!=null){
            if(line.y1==line.y2) {
                canvas.setColor(Color.RED);
                canvas.drawLine(
                        (int)(0.5*windowWidth-(1.5)*cellSize),
                        (int)((0.5*windowHeight+cellSize*(line.y1-1))),
                        (int)(0.5*windowWidth+(1.5)*cellSize),
                        (int)((0.5*windowHeight+cellSize*(line.y1-1))));
                canvas.setColor(Color.BLACK);
            }
            else if(line.x1==line.x2) {
                canvas.setColor(Color.RED);
                canvas.drawLine(
                        (int)(0.5*windowWidth+cellSize*(line.x1-1)),
                        (int)((0.5*windowHeight-(1.5)*cellSize)),
                        (int)(0.5*windowWidth+cellSize*(line.x1-1)),
                        (int)((0.5*windowHeight+(1.5)*cellSize))) ;
                canvas.setColor(Color.BLACK);
            }
            else if(line.x1==0 && line.y1==0)
            {
                canvas.setColor(Color.RED);
                canvas.drawLine(
                        (int)(0.5*windowWidth-(1.5)*cellSize),
                        (int)((0.5*windowHeight-(1.5)*cellSize)),
                        (int)(0.5*windowWidth+(1.5)*cellSize),
                        (int)((0.5*windowHeight+(1.5)*cellSize)));
                canvas.setColor(Color.BLACK);
            }
            else
            {
                canvas.setColor(Color.RED);
                canvas.drawLine(
                        (int)(0.5*windowWidth-(1.5)*cellSize),
                        (int)((0.5*windowHeight+(1.5)*cellSize)),
                        (int)(0.5*windowWidth+(1.5)*cellSize),
                        (int)((0.5*windowHeight-(1.5)*cellSize)));
                canvas.setColor(Color.BLACK);
            }
        }
    }
}