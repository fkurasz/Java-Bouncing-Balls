package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends JPanel implements Runnable{

    Main(JFrame frame){
        frame.add(this);
        frame.setSize(1000, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    int SIZE = 50;
    int SPEED = 10;

    Random losowanie = new Random();

    int x = losowanie.nextInt(800)+1;
    int y = losowanie.nextInt(800)+1;
    //int x =0, y =0;
    int angleX = SPEED, angleY = SPEED;

    private void move()
    {
        if (x+angleX < 0)
            angleX = SPEED;
        else if (x + angleX > getWidth() - SIZE)
            angleX = -SPEED;
        else if (y + angleY < 0)
            angleY = SPEED;
        else if (y+angleY>getHeight() - SIZE)
            angleY = -SPEED;

        x = x + angleX;
        y = y + angleY;
    }

    // rysowanie pilki
    @Override
    public void paint(Graphics g)
    {
        // rozmiar pilki
        super.paint(g);
        g.fillOval(x,y,SIZE,SIZE);
    }

    @Override
    public void run() {
        while (true) {
            this.move();
            this.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        JFrame frame = new JFrame("Balls");

        new Thread(new Main(frame)).start();
        System.out.println("thread");

        new Thread(new Main(frame)).start();
        System.out.println("thread2");
    }
}
