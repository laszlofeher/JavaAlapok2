/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.szamalk.mvc.model;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author feher.laszlo
 */
public class PartnerModel extends AbstractListModel{
    ArrayList<Partner> partnerList = new ArrayList();
    @Override
    public int getSize() {
        return partnerList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return partnerList.get(index);
    }
    
    public void insertPartner(Partner p){
        this.partnerList.add(p);
        this.fireIntervalAdded(partnerList, 0, this.getSize()-1);
    }
    public void insertPartner(int id, String nev, String cim, ArrayList<String> telefonszamok){
        Partner p = new Partner(id, nev, cim, telefonszamok);
        this.insertPartner(p);
    }
    public void insertPartner(int id, String nev, String cim, String... telefonszamok){
        ArrayList<String> telszamok = new ArrayList();
        for(String s : telefonszamok){
            telszamok.add(s);
        }
        this.insertPartner(id, nev, cim, telszamok);        
    }
    public void deletePartner(int index){
        this.partnerList.remove(index);
        this.fireIntervalRemoved(partnerList, 0, partnerList.size());
    }
    public void deletePartner(Partner partner){
        this.partnerList.remove(partner);
        this.fireIntervalRemoved(partnerList, 0, partnerList.size());
    }
    public void updatePartner(int index, Partner partner){
        this.deletePartner(index);
        this.partnerList.add(index, partner);
        this.fireContentsChanged(listenerList, 0, partnerList.size());
    }
    
    public void updatePartner(int index, int id, String nev, String cim, String... telefonszamok){
        this.deletePartner(index);
        ArrayList<String> telszamok = new ArrayList();
        for(String s : telefonszamok){
            telszamok.add(s);
        }
        Partner partner = new Partner(id, nev, cim, telszamok);
        this.partnerList.add(index,partner );
        this.fireContentsChanged(listenerList, 0, partnerList.size());
    }
    
    public void addAll(ArrayList<Partner> selectAll) {
        for(Partner p : selectAll){
            this.partnerList.add(p);
        }
        //this.partnerList = selectAll;
    }
    
    
}   


