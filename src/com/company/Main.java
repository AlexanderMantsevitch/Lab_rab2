package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Main {

    public static void main(String[] args) {

        Calculator add = new Calculator();

        add.setVisible(true);
        add.pack();
        System.out.println( add.getSize());


        add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
