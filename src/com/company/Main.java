package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends JPanel implements Runnable {

    public static int WIDTH = 1400;
    public static int HEIGHT = 800;
    int SPEED = 1;

    Main(JFrame frame, Color col) {
        frame.setResizable(false);
        this.setLayout(null);
        this.setOpaque(false);
        frame.add(this);
        frame.setVisible(true);
        color = col;
    }

    Random lossize = new Random();
    public int SIZE = lossize.nextInt(40)+40;

    Random losowanie = new Random();

    public int x = losowanie.nextInt(WIDTH - 200) + 100;
    public int y = losowanie.nextInt(HEIGHT - 200) + 100;
    //int x =0, y =0;
    int angleX = SPEED, angleY = SPEED;

    private void move() {
        if (x + angleX < 0)
            angleX = SPEED;
        //else if (x + angleX > WIDTH - 1.25*SIZE)
        else if (x + angleX > getWidth() - SIZE)
            angleX = -SPEED;
        else if (y + angleY < 0)
            angleY = SPEED;
        //else if (y + angleY > HEIGHT - 1.75*SIZE)
        else if (y + angleY > getHeight() - SIZE)
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
        frame.setSize(WIDTH, HEIGHT);
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

        Thread ball7 = new Thread(new Main(frame, Color.GRAY));
        ball7.start();

        Thread ball8 = new Thread(new Main(frame, Color.pink));
        ball8.start();

        Thread ball9 = new Thread(new Main(frame, Color.darkGray));
        ball9.start();

        Thread ball10 = new Thread(new Main(frame, Color.black));
        ball10.start();

        while(true)
        {
            frame.repaint();
            Thread.sleep(1);
        }

    }
}
