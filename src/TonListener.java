/* Diese Klasse behandelt die Aktionen, welche Folgen, wenn man einen der 2
   RadioButtons oder den JButton der Klasse Ton angeclickt hat.
   Die RadioButtons schalten die Musik entweder an oder aus.*/

import java.awt.event.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;

public class TonListener implements ActionListener,ChangeListener,MouseListener{
  Ton t;
  Menue me;
  int p = 2;
  public TonListener(Ton te){
    t = te;
  }
  
  public void mousePressed(MouseEvent mp){
    Object op = mp.getSource();

   if (op.equals(t.getLblB())){
    //Spielt ton beim Clicken
    me.getInstance().getT().spieleTon2();
    
    me.getInstance().getT().setVisible(false);
    me.getInstance().getO().setVisible(true);
   }
   //Zum Hintergrundmusik anschalten
   if(op.equals(t.getRBtn(0))){
     //Spielt ton beim Clicken
     me.getInstance().getT().spieleTon();
     
     t.getRBtn(0).setEnabled(false);
     t.getRBtn(1).setEnabled(true);
     t.getRBtn(0).setSelected(true);
     me.getInstance().getT().setAnAus(1);
     p = 0;
     me.getInstance().getT().spieleMusik();
   }
   //Zum Hintergrundmusik ausschalten
   if(op.equals(t.getRBtn(1))){
     //Spielt ton beim Clicken
     me.getInstance().getT().spieleTon();
     
     t.getRBtn(1).setEnabled(false);
     t.getRBtn(0).setEnabled(true);
     t.getRBtn(1).setSelected(true);
     me.getInstance().getT().setAnAus(0);
     p = 1;
     me.getInstance().getT().spieleMusik();
   }
  }
  public void mouseEntered(MouseEvent me){
   Object ob = me.getSource();

     if(ob.equals(t.getLblB())){
       t.getLblB().setIcon(new ImageIcon("src/ZurückA.png"));

     }
  }
  public void mouseExited(MouseEvent mex){
    Object ob = mex.getSource();

    for ( int j = 0;j< 3;j++){
     if(ob.equals(t.getLblB())){
       t.getLblB().setIcon(new ImageIcon("src/Zurück.png"));

     }
    }
  }
  public void mouseClicked(MouseEvent mc){

  }
  public void mouseReleased(MouseEvent mr){

  }
  
  public void actionPerformed(ActionEvent ae){
   Object ob = ae.getSource();
   
   if(ob.equals(t.getRBtn(0))){
    // t.musik();
   }
   
   /* if(ob.equals(t.getBtn())){
     me.getInstance().getT().setVisible(false);
     me.getInstance().getO().setVisible(true);
    } */
  }
  public void stateChanged(ChangeEvent ce){
    Object ob = ce.getSource();
    
   for(int i = 0;i < 2;i++){
    if(ob.equals(t.getSl(i))){
     t.getLblS(i).setText(t.getSl(i).getValue()+"");
    }
   }

  }
  
  public int getP(){
    return this.p;
  }
}
