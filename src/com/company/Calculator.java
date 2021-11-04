package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.text.AttributedCharacterIterator;

public class Calculator extends JFrame {
    private double mem1= 0;
    private double mem2= 0;
    private double mem3= 0;
    private JRadioButton mem_1 = new JRadioButton("Переменная 1");
    private JRadioButton mem_2 = new JRadioButton("Переменная 2");
    private JRadioButton mem_3 = new JRadioButton("Переменная 3");
    private JRadioButton func1 = new JRadioButton("Функция 1");
    private JRadioButton func2 = new JRadioButton("Функция 2");
    private JLabel result = new JLabel("Результат: ");
    private JTextField input = new JTextField("", 10);



    public Calculator() {

        super("Calculator");
        this.setBounds(100, 100, 100,100);
        Container cont = this.getContentPane();
        cont.setLayout( new GridLayout(2, 1, 2,2));
      //  BorderLayout myLayout = new BorderLayout(5, 5);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout( FlowLayout.CENTER ));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout( FlowLayout.CENTER ));
        ButtonGroup func = new ButtonGroup();
        func.add(func1);
        func.add(func2);
        panel1.add(func1);
        func1.setSelected(true);
        panel1.add (func2);
        panel2.add (input);


        panel2.add (result);
        cont.add (panel1, BorderLayout.CENTER);
        cont.add (panel2, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



}
