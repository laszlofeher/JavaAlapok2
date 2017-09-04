/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.szamalk.borderlayout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class Hangman extends JFrame{

    int i = 0;
    static JPanel panel;
    static JPanel panel2;
    static JPanel panel3;

    public Hangman() {
        JButton[] buttons = new JButton[26];

        panel = new JPanel(new FlowLayout());
        panel2 = new JPanel();
        panel3 = new JPanel();

        JButton btnRestart = new JButton("Restart");
        btnRestart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        JButton btnNewWord = new JButton("Add New Word");
        btnNewWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fw = new FileWriter("Words.txt", true);
                    PrintWriter pw = new PrintWriter(fw, true);

                    String word = JOptionPane.showInputDialog("Please enter a word: ");

                    pw.println(word);
                    pw.close();
                } catch (IOException ie) {
                    System.out.println("Error Thrown" + ie.getMessage());
                }
            }

            
            
        });

        JButton btnHelp = new JButton("Help");
        btnHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = "The word to guess is represented by a row "
                        + "of dashes, giving the number of letters and category of "
                        + "the word. \nIf the guessing player suggests a letter "
                        + "which occurs in the word, the other player writes it "
                        + "in all its correct positions. \nIf the suggested "
                        + "letter does not occur in the word, the other player "
                        + "draws one element of the hangman diagram as a tally mark."
                        + "\n"
                        + "\nThe game is over when:"
                        + "\nThe guessing player completes the word, or guesses "
                        + "the whole word correctly"
                        + "\nThe other player completes the diagram";
                JOptionPane.showMessageDialog(null, message, "Help", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        ImageIcon icon = new ImageIcon("D:\\Varsity College\\Prog212Assign1_10-013803\\images\\Hangman1.jpg");
        JLabel label = new JLabel();
        label.setIcon(icon);
        String b[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(b[i]);

            panel.add(buttons[i]);
        }
        panel2.add(label);

        panel3.add(btnRestart);
        panel3.add(btnNewWord);
        panel3.add(btnHelp);
        panel3.add(btnExit);
    }

    public static void main(String[] args) {
        Hangman frame = new Hangman();
        
        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}
