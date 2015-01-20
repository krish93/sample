/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mhr;

/**
 *
 * @author Elcot
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BackgroundImageJFrame extends JFrame
{
JButton b1;
JLabel l1;
    public BackgroundImageJFrame()
    {
    setTitle("Background Color for JFrame");
    setSize(0,0);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

 //   One way
   // -----------------
    setLayout(new BorderLayout());
    
    JLabel background=new JLabel(new ImageIcon("C:\\Users\\Elcot\\Desktop\\light logo.jpg"));
    
    add(background);
    background.setLayout(new FlowLayout());
    l1=new JLabel("Here is a button");
    b1=new JButton("I am a button");
    b1.setLocation(100,100);
    background.add(l1);
    background.add(b1);
    
// Another way
    /*
    setLayout(new BorderLayout());
    setContentPane(new JLabel(new ImageIcon("C:\\Users\\Elcot\\Desktop\\light logo.jpg")));
    setLayout(new FlowLayout());
    l1=new JLabel("Here is a button");
    b1=new JButton("I am a button");
    b1.setBounds(300, 300, 500, 500);
    add(l1);
    add(b1);
    */
    // Just for refresh :) Not optional!
    //setSize(1000,1000);
    //setSize(900,300);
    
    }
    public static void main(String args[])
    {
    new BackgroundImageJFrame();
    }
} 

