package com.nels;
import java.awt.*;
import javax.swing.*;

/**
 * Class that is in carge of paining part of image from regular expression
 */
public class MyRegularComponent extends JComponent {
    private int width;

    public MyRegularComponent(int width) {
        this.width = width;
        setPreferredSize(new Dimension(width, width));
    }
    @Override
    public void paintComponent(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(0, 0, width, width);
        g.setColor(Color.black);
        if (true) {

            for(int i=0;i<4;i++){
                g.drawLine(0, i*(width/4), width / 4, ((width / 4)+i*(width/4)));
                g.drawLine((width/4), ((width / 4)+i*(width/4)), width / 2, i*(width/4));
                g.drawLine(width / 2, i*(width/4), (width * 3) / 4, ((width / 4)+i*(width/4)));
                g.drawLine((width * 3) / 4, ((width / 4)+i*(width/4)), width, i*(width/4));
            }

            for(int i=0;i<4;i++){
                g.drawLine(0, ((width / 4)+i*(width/4)), width / 4, i*(width/4));
                g.drawLine(width/4, i*(width/4), width / 2, ((width / 4)+i*(width/4)));
                g.drawLine(width / 2, ((width / 4)+i*(width/4)), (width * 3) / 4, i*(width/4));
                g.drawLine((width * 3) / 4, i*(width/4), width, ((width / 4)+i*(width/4)));
            }
            g.setColor(Color.red);
            for(int x=0;x<5000;x++){
                for (int i = 0; i < 18; i++) {
                    g.fillRect(i * (width / 18), i * (width / 18), width / 18, width / 18);
                }
            }
            int o =18;
            for(int x=0;x<5000;x++){
                for (int i = 0; i < 18; i++) {
                    o--;
                    if(o>=0) {
                        g.fillRect(i * (width / 18), ((width * o) / 18), width / 18, width / 18);
                    }
                }
            }
        }
    }
}
