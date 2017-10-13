package org.szamalk.turtle;
// Turtle Grafiken
import java.awt.*;

public class Turtle{
//a teknős kezdő koordinátái 
  private double x;
  private double y;
//a teknős iránya:
  private double alpha;

// Konstruktor:
  public Turtle (Graphics g, double x, double y){
    g.setColor(Color.black);
    this.x=x;
    this.y=y;
    alpha=0;
  }
  
//  Set + Get-Metódusok:
  public void setX(double x){
    this.x=x;
  }
  
  public double getX(){
    return x;
  }
  
  public void setY(double y){
    this.y=y;
  }
  
    public double getY(){
    return y;
  }
  
    public void setAlpha(double joko){
    alpha=joko;
  }
  
  public double getAlpha(double haga){
    return alpha;
  }
  
// FONTOS METÓDUSOK: Menj előre:

// forward = előre
// Graphics g = Amivel rajzolni lehet
// double dLong = Hossz
   public void fd(Graphics g, double dLong){
//  Átszámítás szögből radiánba:
    double aa=alpha*Math.PI/180;
//  A hosszból a dx, dy kiszámítása
//  pitagorasz tétellel :

//    dx, dy
//    |\
//    | \
//    |  \
//    |   \
//    |.)__\x,y


    double dx= dLong*Math.cos(aa);
    double dy= dLong*Math.sin(aa);
    
// Ki rajzolja a vonalat.,mindent integerré alakít, 
// hiszen a koordináták csak egész számok lehetnek
    g.drawLine((int)x,(int)y,(int)(x+dx),(int)(y+dy));
//  a végpont lesz az új kezdőpont:
    x=x+dx;
    y=y+dy;
   }
// backward
   public void bk(Graphics g, double strecke){
     fd(g,-strecke);
   }
   
// jobbra fordulás
   public void rt(double angle){
    alpha= alpha+angle;

   }
   
//Balra fordulás
  public void lt(double angle){
   alpha=alpha-angle;
  }
}