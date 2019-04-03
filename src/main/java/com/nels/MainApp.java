package com.nels;

import com.nels.controller.MainController;
import com.nels.InitFrame;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * Class that i creating frames for thread to paint on. It is main method of program.
 */
public class MainApp {
    static JTextField textfield1, textfield2, textfield3;

    public static void main(String[] arguments) {

        int number_of_rows = 2;
        int number_of_columns = 2;
        int width = 200;

        JFrame.setDefaultLookAndFeelDecorated(true);

        //create buttons for start threading
        JFrame start_frame = new JFrame("Projekt 2 - PWIO");

        InitFrame InitFrame = new InitFrame();
        while(!InitFrame.getStart()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException ie){}
        }
        number_of_rows = InitFrame.getRows();
        number_of_columns = InitFrame.getColumns();
        width = InitFrame.getWidth();
        System.out.println("mam: " + number_of_columns+number_of_rows+width);

        // create a basic JFrame for multi thread image and one thread image
        JFrame frame_multi_thread = new JFrame("Multi threads");
        JFrame frame_one_thread = new JFrame("One threads");
        frame_multi_thread.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_one_thread.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame_multi_thread.setLayout(new GridLayout(number_of_rows, number_of_columns,1, 1));
        frame_multi_thread.setSize(number_of_columns*width,number_of_rows*width);
        frame_one_thread.setLayout(new GridLayout(number_of_rows, number_of_columns,1, 1));
        frame_one_thread.setSize(number_of_columns*width,number_of_rows*width);

        //creating main controller for program
        MainController MC = new MainController(number_of_rows,number_of_columns,width,frame_multi_thread, frame_one_thread);

        //method that start paining images from threads
        long multi_thread_start_time= System.currentTimeMillis();
        MC.startMultiThreading();
        long multi_thread_stop_time= System.currentTimeMillis();
        //method that start paining all image from one thread
        long one_thread_start_time= System.currentTimeMillis();
        MC.startOneThread();
        long one_thread_stop_time= System.currentTimeMillis();

        InitFrame.setResults(multi_thread_stop_time-multi_thread_start_time,one_thread_stop_time-one_thread_start_time);

        frame_multi_thread.setVisible(true);
        frame_one_thread.setVisible(true);
    }
}
