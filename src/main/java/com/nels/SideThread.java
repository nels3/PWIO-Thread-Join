package com.nels;
import java.util.concurrent.*;
import javax.swing.*;

public class SideThread extends RecursiveAction{
    private int width;
    private JFrame frame;
    private int number_of_forks;

    public SideThread(int w, JFrame f, int nb_of_forks) {
        width = w;
        frame = f;
        number_of_forks = nb_of_forks;
    }
    @Override
    protected void compute() {
        //System.out.print("Thread is running." +number_of_forks +"\n");
        SideThread ST = new SideThread(width,frame,number_of_forks/2);
        if (number_of_forks>1) {
            ST.fork();
        }
        else{

            return;
        }

        ST.compute();
        MyRegularComponent MRC = new MyRegularComponent(width);
        frame.add(MRC);

        ST.join();
    }

}
