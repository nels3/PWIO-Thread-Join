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

    public MyRegularComponent(int width) {
        this.width = width;
        setPreferredSize(new Dimension(width, width));
        System.out.print("3\n");

    }
    @Override
    public void paintComponent(Graphics g) {

        g.setColor(Color.green);
        g.fillRect(0, 0, width, width);
        g.setColor(Color.black);
    }

}