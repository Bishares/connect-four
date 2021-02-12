/* Diese Klasse behandelt die Aktionen, welche Folgen, wenn man einen der 4
   JButtons der Klasse Optionen angeclickt hat. */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class OptionenListener implements MouseListener{

  Optionen o;
  Menue me;
  
  //Konstruktor der Klasse OptionenListener
  public OptionenListener(Optionen op){
    o = op;
  }
  
  public void mousePressed(MouseEvent mp){
    Object op = mp.getSource();

   for ( int j = 0;j< 4;j++){
     if (op.equals(o.getLblOp(j))){
       switch(j){
         case 0:                       //Spielt ton beim Clicken
                                       me.getInstance().getT().spieleTon();
                                       
                                       me.getInstance().getO().setVisible(false);
                                       me.getInstance().getT().setVisible(true);
                                       break;

         case 1:                       //Spielt ton beim Clicken
                                       me.getInstance().getT().spieleTon();
                                       
                                       me.getInstance().getO().setVisible(false);
                                       me.getInstance().getSw().setVisible(true);
                                       break;

         case 2:                       //Spielt ton beim Clicken
                                       me.getInstance().getT().spieleTon();
                                       
                                       me.getInstance().getO().setVisible(false);
                                       me.getInstance().getSp().setVisible(true);
                                       break;

         case 3:                       //Spielt ton beim Clicken
                                       me.getInstance().getT().spieleTon2();
                                       
                                       me.getInstance().getO().setVisible(false);
                                       me.getInstance().getMp().setVisible(true);
                                       break;
       }
     }
   }
  }
  public void mouseEntered(MouseEvent me){
   Object ob = me.getSource();
   
     if(ob.equals(o.getLblOp(0))){
       o.getLblOp(0).setIcon(new ImageIcon("src/MusikA.png"));
     }
     
     if(ob.equals(o.getLblOp(1))){
       o.getLblOp(1).setIcon(new ImageIcon("src/SchwierigkeitA.png"));
     }
     
     if(ob.equals(o.getLblOp(2))){
       o.getLblOp(2).setIcon(new ImageIcon("src/SpracheA.png"));
     }
     
     if(ob.equals(o.getLblOp(3))){
       o.getLblOp(3).setIcon(new ImageIcon("src/ZurückA.png"));
     }
  }
  public void mouseExited(MouseEvent mex){
    Object ob = mex.getSource();

    if(ob.equals(o.getLblOp(0))){
       o.getLblOp(0).setIcon(new ImageIcon("src/Musik.png"));
     }

     if(ob.equals(o.getLblOp(1))){
       o.getLblOp(1).setIcon(new ImageIcon("src/Schwierigkeit.png"));
     }

     if(ob.equals(o.getLblOp(2))){
       o.getLblOp(2).setIcon(new ImageIcon("src/Sprache.png"));
     }

     if(ob.equals(o.getLblOp(3))){
       o.getLblOp(3).setIcon(new ImageIcon("src/Zurück.png"));
     }
  }
  public void mouseClicked(MouseEvent mc){

  }
  public void mouseReleased(MouseEvent mr){

  }
}
