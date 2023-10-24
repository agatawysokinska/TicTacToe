package com.zetcode;
import javax.swing.*;
import java.awt.*;


public class TicTacToe extends JFrame {

    public TicTacToe() {

        initUI();
    }

    private void initUI() {
        TicTacToeSurface surface = new TicTacToeSurface();
        this.add(surface);
//        this.setTitle("TicTacToe");
        this.setSize(1024, 768);
//        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TicTacToe ex = new TicTacToe();
                ex.setVisible(true);
            }
        });
    }
}
