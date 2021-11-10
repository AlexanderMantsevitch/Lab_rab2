package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.text.AttributedCharacterIterator;


public class Calculator extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;



    private JRadioButton mem_1 = new JRadioButton("Переменная 1");
    private JRadioButton mem_2 = new JRadioButton("Переменная 2");
    private JRadioButton mem_3 = new JRadioButton("Переменная 3");
    private JRadioButtonMenuItem func1 = new JRadioButtonMenuItem("Функция 1");
    private JRadioButtonMenuItem func2 = new JRadioButtonMenuItem("Функция 2");
    private JLabel result = new JLabel("Результат: ");
    private JLabel input = new JLabel("0", 10);
    private JTextField mem1_1 = new JTextField("0", 12);
    private JTextField mem2_2 = new JTextField("0", 12);
    private JTextField mem3_3 = new JTextField("0", 12);
    private  JButton M = new JButton("M+");
    private  JButton MC = new JButton("MC");
    private  JButton res = new JButton("Вычислить");
    private ImageIcon ic;





    public Calculator() {

        super("Calculator");

        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();

        setLocation((kit.getScreenSize().width - WIDTH)/2,
                (kit.getScreenSize().height - HEIGHT)/2);

        Container cont = this.getContentPane();
        cont.setLayout( new GridLayout(7, 1, 2,2));

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
        JPanel ic_2 = new JPanel();
       // func1.createToolTip();




        panel2.add (result);
        panel2.add (input);


        ButtonGroup mem = new ButtonGroup();
        mem.add(mem_1);
        mem.add(mem_2);
        mem.add(mem_3);
        mem_1.setSelected(true);

        JPanel mems = new JPanel();
        mems.setLayout(new FlowLayout( FlowLayout.CENTER ));
        mems.add(mem_1);
        mems.add(mem_2);
        mems.add(mem_3);

        JPanel mems_text = new JPanel();
        mems_text.add(mem1_1);
        mems_text.add(mem2_2);
        mems_text.add(mem3_3);
        mems_text.setLayout(new FlowLayout( FlowLayout.CENTER ));

        JPanel Butt = new JPanel();
        Butt.add (M);
        Butt.add (MC);
        Butt.setLayout(new FlowLayout( FlowLayout.CENTER ));


        cont.add (panel1, BorderLayout.CENTER);
        cont.add (ic_2);
       //a1.add (func1);
       //a1.add (func2);

      // cont.add (a1);

        cont.add (mems, BorderLayout.CENTER);
        cont.add (mems_text, BorderLayout.CENTER);
        cont.add (panel2, BorderLayout.CENTER);
        cont.add (Butt,BorderLayout.CENTER);


        cont.add (res,BorderLayout.CENTER );

        func1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //ImageIcon icon1 =new ImageIcon("E:\\Программирование\\Второй курс\\Java\\Lab_rab2\\src\\com\\company\\func1.BMP");;

                ic = new ImageIcon("E:\\Программирование\\Второй курс\\Java\\Lab_rab2\\src\\com\\company\\func1.BMP");
                JLabel ic_3 = new JLabel(ic);
                ic_2.removeAll();
                ic_2.add(ic_3);
                ic_2.setLayout(new FlowLayout( FlowLayout.CENTER ));
                processWindowEvent(update(this));
                cont.removeAll();
                cont.add (panel1, BorderLayout.CENTER);
                cont.add (ic_2);
                //a1.add (func1);
                //a1.add (func2);

                // cont.add (a1);

                cont.add (mems, BorderLayout.CENTER);
                cont.add (mems_text, BorderLayout.CENTER);
                cont.add (panel2, BorderLayout.CENTER);
                cont.add (Butt,BorderLayout.CENTER);


                cont.add (res,BorderLayout.CENTER );


            }
        });
        func2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                ImageIcon icon2 = new ImageIcon("E:\\Программирование\\Второй курс\\Java\\Lab_rab2\\src\\com\\company\\func2.BMP");
                ;

                JLabel ic2 = new JLabel(icon2);
                ic_2.removeAll();

                ic_2.add(ic2);

                ic_2.setLayout(new FlowLayout(FlowLayout.CENTER));



            }
        });
        res.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                   Double x = Double.parseDouble(mem1_1.getText());
                   Double y = Double.parseDouble(mem2_2.getText());
                   Double z = Double.parseDouble(mem3_3.getText());
                   Double resultat;

                   if ( func1.isSelected())
                   {
                       resultat = f1 (x,y,z);

                   }
                   else { resultat = f2 (x,y,x);}
                   input.setText( String.valueOf(resultat));

                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Calculator.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        M.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                if (mem_1.isSelected()) {
                    double resultat = Double.parseDouble( input.getText());
                    double x = Double.parseDouble( mem1_1.getText());
                    x += resultat;
                    input.setText(String.valueOf(x));


                }
                    if (mem_2.isSelected()) {
                        double resultat = Double.parseDouble( input.getText());
                        double y = Double.parseDouble( mem2_2.getText());
                        y += resultat;
                        input.setText(String.valueOf(y));

                    }
                    if (mem_3.isSelected()) {
                        double resultat = Double.parseDouble( input.getText());
                        double z = Double.parseDouble( mem3_3.getText());
                        z += resultat;
                        input.setText(String.valueOf(z));

                    }
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Calculator.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);

                }

            }
        });
        MC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mem_1.isSelected()) {

                    mem1_1.setText("0");


                }
                if (mem_2.isSelected()) {

                    mem2_2.setText("0");

                }
                if (mem_3.isSelected()) {

                    mem3_3.setText("0");

                }
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    double f1 (double x, double y, double z)
    {


        return ( (Math.sin(y) + Math.pow (y,2) + Math.exp( Math.cos(y))) * (Math.pow ((Math.log(z) + Math.sin(Math.PI * x*x)), 0.25)) );

    }
    double f2 (double x, double y, double z)
    {

        return ( Math.pow (y + Math.pow (x,3),  (1/z) ) / Math.log (z)  );

    }

    }



