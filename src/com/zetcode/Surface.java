package com.zetcode;

import com.zetcode.fields.*;
import com.zetcode.fields.Circle;
import com.zetcode.fields.Cross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class TicTacToeSurface<function> extends JPanel implements MouseListener {
    private Line line;
    private int x1 = 100;
    private int y1 = 100;
    //    private int x2 = 500;
//    private int y2 = 500;
    private int cell = 150;
    private int cellx;
    private int celly;
    int move = 0;
    boolean win=false;
    boolean button=false;
    Board board = new Board();

    TicTacToeSurface()
    {
        this.addMouseListener(this);
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int windowWidth = this.getBounds().width;
        int windowHeight = this.getBounds().height;
        board.draw(g2d,windowWidth,windowHeight,cell,line);

        if(win)
        {
            Button okButton = new Button("PLAY AGAIN");
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Ok Button clicked.");
                    for(int i=0; i<3; i++)
                    {
                        for(int j=0; j<3; j++) {
                            board.fields[i][j]=null;
                        }
                    }
                    win=false;
                    button=false;
                    move=0;
                    line=null;
                    remove(okButton);
                    repaint();
                }
            });

            if(!button) {
                add(okButton);
                button=true;
                this.revalidate();
            }
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, g2d.getFont().getSize() * 2));
            g2d.setColor(Color.GREEN);
            drawCenteredString(g2d,"YOU WON! ;)", new Rectangle(0,0,windowWidth,windowHeight),g2d.getFont());
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int windowWidth = this.getBounds().width;
        int windowHeight = this.getBounds().height;

        Point click = e.getPoint();

        for (int i = 0; i < 4; i++) {
            if (click.x > (i * cell) +  (int)(0.5*windowWidth-(1.5)*cell) && click.x < ((i + 1) * cell) + (int)(0.5*windowWidth-(1.5)*cell) ) {
                cellx = i;

            }
        }
        for (int i = 0; i < 4; i++) {
            if (click.y > (i * cell)+(int)(0.5*windowHeight-(1.5)*cell)  && click.y < ((i + 1) * cell) + (int)(0.5*windowHeight-(1.5)*cell)) {
                celly = i;

            }
        }
        System.out.println("Kliknieto komorke: " + cellx + "," + celly);
        Field field = move % 2 == 0 ? new Circle() : new Cross();
        boolean contains = board.fields[cellx][celly] != null;

        if(!contains && !win) {
            board.fields[cellx][celly]=field;
            move++;
            System.out.println(move);

            if (board.fields[0][0] != null && board.fields[0][1] != null && board.fields[0][2]!= null) {
                if (board.fields[0][0].getClass() == board.fields[0][1].getClass() && board.fields[0][0].getClass() == board.fields[0][2].getClass()) {
                    System.out.println("wygraleś");
                    win=true;
                    line = new Line(0,0,0,2);
                }
            }
            if(board.fields[1][0] != null && board.fields[1][1] != null && board.fields[1][2]!= null) {
                if (board.fields[1][0].getClass() == board.fields[1][1].getClass() && board.fields[1][0].getClass() == board.fields[1][2].getClass()) {
                    System.out.println("wygraleś");
                    win=true;
                    line = new Line(1,1,0,2);
                }
            }
            if(board.fields[2][0] != null && board.fields[2][1] != null && board.fields[2][2]!= null) {
                if (board.fields[2][0].getClass() == board.fields[2][1].getClass() && board.fields[2][0].getClass() == board.fields[2][2].getClass()) {
                    System.out.println("wygraleś");
                    win=true;
                    line = new Line(2,2,0,2);
                }
            }
            if(board.fields[0][0] != null && board.fields[1][0] != null && board.fields[2][0]!= null) {
                if (board.fields[0][0].getClass() == board.fields[1][0].getClass() && board.fields[1][0].getClass() == board.fields[2][0].getClass()) {
                    System.out.println("wygraleś");
                    win=true;
                    line = new Line(0,2,0,0);
                }
            }
            if(board.fields[0][1] != null && board.fields[1][1] != null && board.fields[2][1]!= null) {
                if (board.fields[0][1].getClass() == board.fields[1][1].getClass() && board.fields[0][1].getClass() == board.fields[2][1].getClass()) {
                    System.out.println("wygraleś");
                    win=true;
                    line = new Line(0,2,1,1);

                }
            }
            if(board.fields[0][2] != null && board.fields[1][2] != null && board.fields[2][2]!= null) {
                if (board.fields[0][2].getClass() == board.fields[1][2].getClass() && board.fields[0][2].getClass() == board.fields[2][2].getClass()) {
                    System.out.println("wygraleś");
                    win=true;
                    line = new Line(0,2,2,2);
                }
            }
            if(board.fields[0][0] != null && board.fields[1][1] != null && board.fields[2][2]!= null) {
                if (board.fields[0][0].getClass() == board.fields[1][1].getClass() && board.fields[0][0].getClass() == board.fields[2][2].getClass()) {
                    System.out.println("wygraleś");
                    win=true;
                    line = new Line(0,2,0,2);
                }
            }
            if(board.fields[0][2] != null && board.fields[1][1] != null && board.fields[2][0]!= null) {
                if (board.fields[0][2].getClass() == board.fields[1][1].getClass() && board.fields[0][2].getClass() == board.fields[2][0].getClass()) {
                    System.out.println("wygraleś");
                    win=true;
                    line = new Line(2,0,0,2);
                }
            }


        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
