package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel{

    int SIZE = 10;
    int SPEED = 5;

    int x =0, y =0;
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

    public static void main(String[] args) throws InterruptedException{

        JFrame frame = new JFrame("Balls");
        Main main_class = new Main();
        frame.add(main_class);
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        while (true)
        {
            main_class.move();
            main_class.repaint();
            Thread.sleep(10);
        }
    }
}
