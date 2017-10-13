/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.szamalk.mvc.view;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import org.szamalk.mvc.model.Partner;

/**
 *
 * @author feher.laszlo
 */
public class PartnerView implements ListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(value instanceof Partner){
            PartnerRow  pr = new PartnerRow(((Partner)value).getNev(), ((Partner)value).getCim(), ((Partner)value).getTelefonszamok().size()==0 ? false : true );
            if(isSelected){
                pr.setBackground(list.getSelectionBackground());
                pr.setForeground(list.getSelectionForeground());
                
            }
            return pr;
        }
        return null;
    }
    
}
