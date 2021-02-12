/* Diese Klasse behandelt die Aktionen, welche Folgen, wenn man einen der 2
   RadioButtons oder den JButton der Klasse Schwierigkeit angeclickt hat. */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class SchwierigkeitListener implements ActionListener, MouseListener{

  Schwierigkeit s;
  Menue me;
  Sprache sp = new Sprache();
  SpracheListener spl = new SpracheListener(sp);
  
  public SchwierigkeitListener(Schwierigkeit sw){
   s = sw;
  }

  public void actionPerformed(ActionEvent ae){
    Object ob = ae.getSource();
    
    //Spielt ton beim Clicken
      me.getInstance().getT().spieleTon();

    //Radio-Button Management
    //If-Abfragen für verschiedene Sprachen
    if(ob.equals(s.getRBtn(0)) && s.getLbl().getText() == spl.getDe(5)){
      s.getRBtn(0).setText(spl.getDe(6));
      s.setPlatz(0);
    }
    if(ob.equals(s.getRBtn(1)) && s.getLbl().getText() == spl.getDe(5)){
      s.getRBtn(1).setText(spl.getDe(7));
      s.setPlatz(1);
    }
    if(ob.equals(s.getRBtn(0)) && s.getLbl().getText() == spl.getEn(5)){
      s.getRBtn(0).setText(spl.getEn(6));
      s.setPlatz(0);
    }
    if(ob.equals(s.getRBtn(1)) && s.getLbl().getText() == spl.getEn(5)){
      s.getRBtn(1).setText(spl.getEn(7));
      s.setPlatz(1);
    }
    if(ob.equals(s.getRBtn(0)) && s.getLbl().getText() == spl.getFr(5)){
      s.getRBtn(0).setText(spl.getFr(6));
      s.setPlatz(0);
    }
    if(ob.equals(s.getRBtn(1)) && s.getLbl().getText() == spl.getFr(5)){
      s.getRBtn(1).setText(spl.getFr(7));
      s.setPlatz(1);
    }
  }

  public void mousePressed(MouseEvent mp){
    Object ob = mp.getSource();

   if (ob.equals(s.getLblB())){
    //Spielt ton beim Clicken
    me.getInstance().getT().spieleTon2();
      
    me.getInstance().getSw().setVisible(false);
    me.getInstance().getO().setVisible(true);
   }
  }
  public void mouseEntered(MouseEvent men){
   Object ob = men.getSource();

     if(ob.equals(s.getLblB())){
       s.getLblB().setIcon(new ImageIcon("src/ZurückA.png"));

     }
  }
  public void mouseExited(MouseEvent mex){
    Object ob = mex.getSource();

     if(ob.equals(s.getLblB())){
       s.getLblB().setIcon(new ImageIcon("src/Zurück.png"));

     }

  }
  public void mouseClicked(MouseEvent mc){

  }
  public void mouseReleased(MouseEvent mr){

  }

}
