package com.nels;
import java.awt.*;
import javax.swing.*;

/**
 * Class that is in carge of paining part of image from regular expression
 */
public class MyRegularComponent extends JComponent {
    private int thread_id;
    //width of one small image
    private int width;

    public MyRegularComponent(int id, int width) {
        thread_id = id;
        this.width = width;
        setPreferredSize(new Dimension(width, width));

    }
    @Override
    public void paintComponent(Graphics g) {

        g.setColor(Color.green);
        g.fillRect(0, 0, width, width);
        g.setColor(Color.black);
        if (thread_id!=-1) {
            g.drawString("Thread " + thread_id, width / 3, width / 2);
        }
    }

}