/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.szamalk.graphpanel;

import java.awt.Graphics;
import org.szamalk.turtle.Turtle;

/**
 *
 * @author Lenovo
 */
public class GraphPanel4DragonCurve extends javax.swing.JPanel {
    private double dLong;
    private int countOfRecursion;
    private int startX, startY;
    private int orientation;
    private int type = 1;
    /**
     * Creates new form GraphPanel4DragonCurve
     */
    public GraphPanel4DragonCurve() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

@Override
    public void paint(Graphics g) {
        super.paint(g);
        Turtle t = new Turtle(g, 0,0);
        t.rt(90);
        dragon(g,t,this.countOfRecursion,this.orientation,this.dLong);
    }
    
    public double getdLong() {
        return dLong;
    }

    public void setdLong(double dLong) {
        this.dLong = dLong;
    }

    public int getCountOfRecursion() {
        return countOfRecursion;
    }

    public void setCountOfRecursion(int countOfRecursion) {
        this.countOfRecursion = countOfRecursion;
    }
    
    public void setStartXY(int x, int y){
        this.startX = x/2;
        this.startY = y/2;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
    public void dragon(Graphics g, Turtle t, int step, int orientation, double length){
    if(step>-1&length>1){
      length=length/Math.sqrt(2);
      t.lt(45*orientation);
      dragon(g,t,step-1,+1,length);
      t.lt(-90*orientation);
      dragon(g,t,step-1,-1,length);
      t.lt(45*orientation);
    } else {
      t.fd(g,length);
    }
  }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}