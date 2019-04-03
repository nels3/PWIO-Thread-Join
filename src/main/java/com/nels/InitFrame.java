package com.nels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Init JFrame that user uses when want to start program
 */
public class InitFrame {
    private int number_of_rows = 3;
    private int number_of_cols = 3;
    private int width = 2;
    private boolean start = false;
    private long period_multi_thread;
    private long period_one_thread;
    private JFrame f =new JFrame("Projekt 2 - PWIO");
    private JLabel label_multi = new JLabel();
    private JLabel label_one = new JLabel();

    public InitFrame(){
        //start button
        JButton b=new JButton("Start");
        b.setBounds(110,130,100, 30);
        //labels for data
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        label1.setText("Nb of columns :");
        label1.setBounds(10, 10, 100, 30);
        label2.setText("Nb of rows :");
        label2.setBounds(10, 50, 100, 30);
        label3.setText("Width :");
        label3.setBounds(10, 90, 100, 30);

        label_multi.setBounds(10, 180, 280, 30);
        label_one.setBounds(10, 210, 280, 30);

        //textfield to enter variables
        JTextField textfield_cols= new JTextField();
        textfield_cols.setText(Integer.toString(number_of_cols));
        JTextField textfield_rows= new JTextField();
        textfield_rows.setText(Integer.toString(number_of_rows));
        JTextField textfield_width= new JTextField();
        textfield_width.setText(Integer.toString(width));
        textfield_cols.setBounds(110, 10, 130, 30);
        textfield_rows.setBounds(110, 50, 130, 30);
        textfield_width.setBounds(110, 90, 130, 30);

        //add to frame
        f.add(textfield_cols);
        f.add(textfield_rows);
        f.add(textfield_width);
        f.add(label1);
        f.add(label2);
        f.add(label3);
        f.add(b);
        f.setSize(300,330);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //action listener
        b.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            start = true;
            number_of_rows = Integer.parseInt(textfield_rows.getText());
            number_of_cols = Integer.parseInt(textfield_cols.getText());
            width = Integer.parseInt(textfield_width.getText());
        }
        });
    }

    public boolean getStart(){
        return this.start;
    }

    public int getRows(){
        return this.number_of_rows;
    }

    public int getColumns(){
        return this.number_of_cols;
    }

    public int getWidth(){
        return this.width;
    }

    public void setResults(long period_multi_thread, long period_one_thread){
        this.period_multi_thread = period_multi_thread;
        this.period_one_thread = period_one_thread;
        this.label_multi.setText("Multi thread time: " + this.period_multi_thread);
        this.label_one.setText("One thread time: "+ this.period_one_thread);

        this.f.add(label_multi);
        this.f.add(label_one);
    }

}

