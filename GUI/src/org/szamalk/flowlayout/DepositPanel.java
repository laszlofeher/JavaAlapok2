/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.szamalk.flowlayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class DepositPanel {

    private JLabel cashL, checksL;
    private JTextField cashTF, checksTF;
    private JButton ok, cancel;
    private JPanel depositP;
    
    
    DepositPanel() {
        depositP = new JPanel();
        depositP.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
        depositP.setPreferredSize(new Dimension(250, 85));

        JTextField cashTF   = new JTextField(22);
        JTextField checksTF = new JTextField(22);

        JLabel cashL = new JLabel("Cash:");
        JLabel checksL = new JLabel("Checks:");

        ok = new JButton("OK");
        cancel = new JButton("CANCEL");

        depositP.add(cashL);
        depositP.add(cashTF);
        depositP.add(checksL);
        depositP.add(checksTF);
        depositP.add(ok);
        depositP.add(cancel);
        
        JFrame jFrame = new JFrame();
        jFrame.add(depositP);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        DepositPanel dp = new DepositPanel();
    }
}