/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.szamalk.mvc.view;

/**
 *
 * @author feher.laszlo
 */
public class PartnerRow extends javax.swing.JPanel {
    /**
     * Creates new form PartnerRow
     */
    public PartnerRow() {
        initComponents();
    }

    public PartnerRow(String nev, String cim, boolean phoneIcon){
        initComponents();
        this.nevLabel.setText(nev);
        this.cimLabel.setText(cim);
        this.phoneLabel.setVisible(phoneIcon);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nevLabel = new javax.swing.JLabel();
        cimLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();

        nevLabel.setText("jLabel1");

        cimLabel.setText("jLabel2");

        phoneLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/szamalk/images/phone-icon.png")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nevLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cimLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(phoneLabel))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(phoneLabel)
                .addComponent(cimLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(nevLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cimLabel;
    private javax.swing.JLabel nevLabel;
    private javax.swing.JLabel phoneLabel;
    // End of variables declaration//GEN-END:variables
}
