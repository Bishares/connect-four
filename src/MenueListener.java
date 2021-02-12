/* Diese Klasse behandelt die Aktionen, welche Folgen, wenn man einen der 3
   JButtons des MenuePanels angeclickt hat. */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MenueListener extends JFrame implements MouseListener{

  Menue me;
  Spiel s;
  MenuePanel m;
  Optionen o;
  Ton t;
  JLabel lbl2;
  //Konstruktor der Klasse MenueListener
  public MenueListener(MenuePanel mp){
    m = mp;
  }
  
 /* public void actionPerformed(ActionEvent ae){
   Object ob = ae.getSource();
   for ( int j = 0;j< 3;j++){
     if (ob.equals(m.getLblOp(j))){
       switch(j){
                                   //Wenn Benutzer Start drückt
         case 0:                       me.getInstance().getMp().setVisible(false);
                                       me.getInstance().getS().setVisible(true);
                                       if(ob.equals(me.getInstance().getMp().getLblOp(0))){
                                         me.getInstance().getS().zuruecksetzten();
                                       }
                                       break;

                                   //Wenn Benutzer Optionen drückt
         case 1:                       me.getInstance().getMp().setVisible(false);
                                       me.getInstance().getO().setVisible(true);

                                       break;

                                   //Wenn Benutzer Beenden drückt
         case 2:                       System.exit(0);
                                       break;
       }
     }
   }
  }        */
  
  public void mouseExited(MouseEvent me){
    Object ob = me.getSource();

    for ( int j = 0;j< 3;j++){
     if(ob.equals(m.getLblOp(0))){
       m.getLblOp(0).setIcon(new ImageIcon("src/BtnSs.png"));
     }
     if(ob.equals(m.getLblOp(1))){
       m.getLblOp(1).setIcon(new ImageIcon("src/BtnOpt.png"));
     }
     if(ob.equals(m.getLblOp(2))){
       m.getLblOp(2).setIcon(new ImageIcon("src/BtnBe.png"));
     }
    }
  }
  public void mouseEntered(MouseEvent men){
    Object ob = men.getSource();

    for ( int j = 0;j< 3;j++){
     if(ob.equals(m.getLblOp(0))){
       m.getLblOp(0).setIcon(new ImageIcon("src/BtnSsA.png"));
     }
     if(ob.equals(m.getLblOp(1))){
       m.getLblOp(1).setIcon(new ImageIcon("src/BtnOptA.png"));
     }
     if(ob.equals(m.getLblOp(2))){
       m.getLblOp(2).setIcon(new ImageIcon("src/BtnBeA.png"));
     }
    }
  }
  public void mouseReleased(MouseEvent mr){

  }
  public void mousePressed(MouseEvent mp){
    Object ob = mp.getSource();

    for ( int j = 0;j< 3;j++){
      if (ob.equals(m.getLblOp(j))){
        switch(j){
                                   //Wenn Benutzer Start drückt
         case 0:                       //Spielt ton beim Clicken
                                       me.getInstance().getT().spieleTon();
                                       
                                       me.getInstance().getMp().setVisible(false);
                                       me.getInstance().getS().setVisible(true);
                                       if(ob.equals(me.getInstance().getMp().getLblOp(0))){
                                         me.getInstance().getS().zuruecksetzten();
                                       }
                                       break;

                                   //Wenn Benutzer Optionen drückt
         case 1:                       //Spielt ton beim Clicken
                                       me.getInstance().getT().spieleTon();
                                       me.getInstance().getMp().setVisible(false);
                                       me.getInstance().getO().setVisible(true);

                                       break;

                                   //Wenn Benutzer Beenden drückt
         case 2:                       //Spielt ton beim Clicken
                                       me.getInstance().getT().spieleTon2();
                                       
                                       System.exit(0);
                                       break;
        }
      }
    }
    
    if(ob.equals(m.getRdBtn(0))){
      //Spielt ton beim Clicken
      me.getInstance().getT().spieleTon();
      
      m.setMultiSingle(0);
    }
    if(ob.equals(m.getRdBtn(1))){
      //Spielt ton beim Clicken
      me.getInstance().getT().spieleTon();
      
      m.setMultiSingle(1);
    }
  }
  public void mouseClicked(MouseEvent mc){

  }
}
