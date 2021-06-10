package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends JPanel implements Runnable {


    Main(JFrame frame, Color col) {
        this.setLayout(null);
        this.setOpaque(false);
        frame.add(this);
        frame.setVisible(true);
        color = col;
    }

    public int SIZE = 50;
    int SPEED = 1;

    Random losowanie = new Random();

    public int x = losowanie.nextInt(800) + 100;
    public int y = losowanie.nextInt(600) + 100;
    //int x =0, y =0;
    int angleX = SPEED, angleY = SPEED;

    private void move() {
        if (x + angleX < 0)
            angleX = SPEED;
        else if (x + angleX > 987.5 - SIZE)
            angleX = -SPEED;
        else if (y + angleY < 0)
            angleY = SPEED;
        else if (y + angleY > 770 - SIZE)
            angleY = -SPEED;

        x = x + angleX;
        y = y + angleY;

        //System.out.println(color.toString() + " ");
        //System.out.print(x + " ");
        //System.out.print(y + " ");
    }

    @Override
    public void run() {
        while (true) {
            this.move();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Color color;

    @Override
    public void paint(Graphics g) {
        // rozmiar pilki
        super.paint(g);

        g.setColor(color);
        g.fillOval(x, y, SIZE, SIZE);
    }

    public static void main(String[] args) throws InterruptedException
    {
        JFrame frame = new JFrame("Balls");
        //JPanel panel = new Panel;
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Thread displ = new Thread(DisBall(frame));
        //displ.start();

        Thread ball1 = new Thread(new Main(frame, Color.red));
        ball1.start();

        Thread ball2 = new Thread(new Main(frame, Color.blue));
        ball2.start();

        Thread ball3 = new Thread(new Main(frame, Color.green));
        ball3.start();

        Thread ball4 = new Thread(new Main(frame, Color.CYAN));
        ball4.start();

        Thread ball5 = new Thread(new Main(frame, Color.yellow));
        ball5.start();

        Thread ball6 = new Thread(new Main(frame, Color.magenta));
        ball6.start();

        while(true)
        {
            frame.repaint();
            Thread.sleep(1);
        }

    }
}
