package com.nels.controller;

import com.nels.MyRegularComponent;
import com.nels.SideThread;

import javax.swing.*;

/**
 * Main Controller of program, it is calling multi treading and printing image from one thread
 */
public class MainController {

    private int number_of_rows;
    private int number_of_columns;
    private int number_of_threads;
    private int width;
    private JFrame frame_multi_tread;
    private JFrame frame_one_tread;

    public MainController(int rows, int columns, int width, JFrame frame_multi_tread, JFrame frame_one_tread){
        this.number_of_rows = rows;
        this.number_of_columns = columns;
        this.number_of_threads = rows*columns;
        this.width = width;
        this.frame_multi_tread = frame_multi_tread;
        this.frame_one_tread = frame_one_tread;
    }

    /**
     * Method that is called when we want to have multi thread to paint single images
     */
    public void startMultiThreading(){
        System.out.print("\nStarted multithreading\n");

        SideThread[] thread = new SideThread[number_of_threads];
        int k = 0;
        for (int i=0; i<number_of_columns; ++i){
            for (int j=0; j<number_of_rows; ++j) {
                thread[k] = new SideThread(width, frame_multi_tread);
                thread[k].start();
                k +=1;
            }
        }
        try {
            for (int i = 0; i < number_of_threads; ++i) {
                thread[i].join();
            }
        }
        catch (InterruptedException ie){}

        System.out.print("\nJoined threads\n");
    }

    /**
     * Method that paint whole image from one thread
     */
    public void startOneThread(){
        System.out.print("\nStarted one thread\n");

        for (int i=0; i<number_of_threads; ++i) {
            MyRegularComponent MRC = new MyRegularComponent(-1, width);
            frame_one_tread.add(MRC);
        }

        System.out.print("\nJoined threads\n");
    }



}


