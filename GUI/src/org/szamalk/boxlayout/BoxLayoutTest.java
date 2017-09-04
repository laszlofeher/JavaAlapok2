/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.szamalk.boxlayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Lenovo
 */
public class BoxLayoutTest {

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("BoxLayout Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS); // top to bottom
        frame.setLayout(boxLayout);
        frame.add(new JButton("Button 1"));
        frame.add(new JButton("Button 2"));
        frame.add(new JButton("Button 3"));
        frame.pack();

        frame.setVisible(true);
    }
}
