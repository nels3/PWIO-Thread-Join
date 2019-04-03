package com.nels;

import javax.swing.*;
import java.util.concurrent.RecursiveAction;

public class SideThread extends RecursiveAction {
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
        if (number_of_forks<=1){
            MyRegularComponent MRC = new MyRegularComponent(width);
            frame.add(MRC);
        }
        else {
            if(number_of_forks%2==0){
                invokeAll(new SideThread(width, frame, number_of_forks/2),
                        new SideThread(width, frame, number_of_forks/2));
            }else{
                invokeAll(new SideThread(width, frame, number_of_forks/2+1),
                        new SideThread(width, frame, number_of_forks/2));
            }
        }
    }
}
