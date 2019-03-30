package com.nels;

import javax.swing.*;

public class SideThread extends Thread{
    private int width;
    private JFrame frame;

    public SideThread(int w, JFrame f) {
        width = w;
        frame = f;
    }

    @Override
    public void run() {
        System.out.print("Thread id: "+ getId()+" is running.\n");
        MyRegularComponent MRC = new MyRegularComponent((int)getId(),width);
        frame.add(MRC);
    }

}
