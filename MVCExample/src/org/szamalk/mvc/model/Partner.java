/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.szamalk.mvc.model;

import java.util.ArrayList;

/**
 *
 * @author feher.laszlo
 */
public class Partner {
    private int id;
    private String nev;
    private String cim;
    private ArrayList<String> telefonszamok = new ArrayList();

    public Partner(int id, String nev, String cim, ArrayList<String> telefonszamok) {
        this.id = id;
        this.nev = nev;
        this.cim = cim;
        this.telefonszamok = telefonszamok;
    }

    public Partner() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void add(String s){
        if(telefonszamok!= null){
            telefonszamok.add(s);
        }
    }
    
    public void addAll(ArrayList<String> al){
        if(al != null && telefonszamok != null){
            for(String s : al){
                telefonszamok.add(s);
            }
        }
    }
    
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public ArrayList<String> getTelefonszamok() {
        return telefonszamok;
    }

    public void setTelefonszamok(ArrayList<String> telefonszamok) {
        this.telefonszamok = telefonszamok;
    }

    @Override
    public String toString() {
        return "Partner{" + "id=" + id + ", nev=" + nev + ", cim=" + cim + ", telefonszamok=" + telefonszamok.toString() + '}';
    }
    
    
}
