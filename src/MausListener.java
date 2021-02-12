//orange ist spieler 1
//grün ist spieler 2
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
public class MausListener implements MouseListener{

   Spiel s;
   Menue me;
   
   private int zahl = 1;
   private int spalte = 0;
   private int zeile = 0;
   private int spieler = 0;
   private int spielArt;
   private boolean gesetzt = false;
   private boolean gewonnen = false;
   private boolean voll = false;
   //cmd.ai.Main2 mai;

   public MausListener(Spiel sp){
     s = sp;
   }
   
   public void actionPerformed(ActionEvent ae){

   }

   public void mouseExited(MouseEvent mex){
    Object ob = mex.getSource();

    if(ob.equals(s.getLbl())){
      s.getLbl().setIcon(new ImageIcon("src/IngameButtonZurück.png"));
    }
    if(ob.equals(s.getLblNeu())){
      s.getLblNeu().setIcon(new ImageIcon("src/IngameButtonNeuesSpiel.png"));
    }
   }
   public void mouseEntered(MouseEvent men){
    Object ob = men.getSource();
    
    if(ob.equals(s.getLbl())){
      s.getLbl().setIcon(new ImageIcon("src/IngameButtonZurückA.png"));
    }
    if(ob.equals(s.getLblNeu())){
      s.getLblNeu().setIcon(new ImageIcon("src/IngameButtonNeuesSpielA.png"));
    }
   }
   public void mouseReleased(MouseEvent mr){

   }
   public void mousePressed(MouseEvent mp){

      Object ob = mp.getSource();
      
      spielArt = me.getInstance().getSpielArt();
      
      //Spielt ton beim Clicken
      if(!ob.equals(s.getLblNeu()) && !ob.equals(s.getLbl())){
         me.getInstance().getT().spieleTon3();
      }


      if(spielArt == 1){
        for(int i = 0; i<6; i++){
          for(int j = 0; j<7; j++){
             if(ob.equals(s.getLblFeld(i,j)) && s.getBelegt(i,j) == false && gewonnen == false && voll == false){
               spalte = j;
               for(int k = 0; k<6; k++){
                  if(s.getBelegt(k, spalte) == false && gesetzt == false){
                     zeile = k;
                     if(zahl % 2 == 0){
                       spieler = 2;
                       s.setLblFeld(zeile,spalte,spieler);
                       s.setLblSpieler1(true);
                       s.setLblSpieler2(false);
                     }else{
                       spieler = 1;
                       s.setLblFeld(zeile,spalte,spieler);
                       s.setLblSpieler1(false);
                       s.setLblSpieler2(true);
                     }
                     gesetzt = true;
                  }
               }
               s.setBelegt(zeile,spalte);
               zahl = zahl + 1;
             }

          }
        }

        s.setSpieler(zeile, spalte, spieler);

        gesetzt = false;

        gewonnen = s.gewinner1();
        gewonnen = s.senkrecht1();

        gewonnen = s.gewinner2();
        gewonnen = s.senkrecht2();

        for(int i = 0; i<3; i++){
          for(int j = 0; j<4; j++){
             gewonnen = s.diagonal1(i,j);
             gewonnen = s.diagonal2(i,j);
          }
        }

        for(int i = 0; i<3; i++){
          for(int j = 3; j<7; j++){
             gewonnen = s.diagonal3(i,j);
             gewonnen = s.diagonal4(i,j);
          }
        }

        if(gewonnen == true){
          //Spielt ton beim Sieg
          if(!ob.equals(s.getLblNeu()) && !ob.equals(s.getLbl())){
           me.getInstance().getT().spieleTon4();
          }

          
          s.gewonnen(spieler);
          s.setLblSpieler1(false);
          s.setLblSpieler2(false);
          if(spieler == 1){
            s.setLblGewonnen1(true);
          }else{
            s.setLblGewonnen2(true);
          }
        }
      }

      if(spielArt == 0){
       Logik l = new Logik();
       //System.out.println(m.getZeile());
       for(int i = 0; i<6; i++){
          for(int j = 0; j<7; j++){
             if(ob.equals(s.getLblFeld(i,j)) && s.getBelegt(i,j) == false && gewonnen == false && voll == false){
               spalte = j;
               for(int k = 0; k<6; k++){
                  if(s.getBelegt(k, spalte) == false && gesetzt == false){
                     zeile = k;
                     //Computer
//                     if(zahl % 2 == 0){
                       spieler = 2;
                       s.setLblFeld(l.getZeile(),l.getSpalte(),spieler);
                       s.setBelegt(l.getZeile(),l.getSpalte());
                       s.setLblSpieler1(true);
                       s.setLblSpieler2(false);
                       System.out.println("computer");
//                     }else{
                       spieler = 1;
                       s.setLblFeld(zeile,spalte,spieler);
                       s.setLblSpieler1(false);
                       s.setLblSpieler2(true);
//                     }
                     gesetzt = true;
                  }
               }
               s.setBelegt(zeile,spalte);
               zahl = zahl + 1;
             }

          }
        }
        if(spieler == 1){
         s.setSpieler(zeile, spalte, spieler);
        }else{
         s.setSpieler(l.getZeile(),l.getSpalte(),spieler);
        }


        gesetzt = false;

        gewonnen = s.gewinner1();
        gewonnen = s.senkrecht1();

        gewonnen = s.gewinner2();
        gewonnen = s.senkrecht2();

        for(int i = 0; i<3; i++){
          for(int j = 0; j<4; j++){
             gewonnen = s.diagonal1(i,j);
             gewonnen = s.diagonal2(i,j);
          }
        }

        for(int i = 0; i<3; i++){
          for(int j = 3; j<7; j++){
             gewonnen = s.diagonal3(i,j);
             gewonnen = s.diagonal4(i,j);
          }
        }

        if(gewonnen == true){
          //Spielt ton beim Sieg
          if(!ob.equals(s.getLblNeu()) && !ob.equals(s.getLbl())){
           me.getInstance().getT().spieleTon4();
          }
          
          s.gewonnen(spieler);
          s.setLblSpieler1(false);
          s.setLblSpieler2(false);
          if(spieler == 1){
            s.setLblGewonnen1(true);
          }else{
            s.setLblGewonnen2(true);
          }
        }
      }
      
      if(ob.equals(s.getLblNeu())){
        //Spielt ton beim Clicken
        me.getInstance().getT().spieleTon();

        s.zuruecksetzten();
        gewonnen = false;
        gesetzt = false;
        if(spieler == 1){
          s.setLblSpieler1(false);
          s.setLblSpieler2(true);
        }else{
          s.setLblSpieler1(true);
          s.setLblSpieler2(false);
        }

        voll = false;
        s.setLblUnentschieden(false);
      }

      if(s.vollesFeld() == true){
        s.setLblSpieler1(false);
        s.setLblSpieler2(false);
        voll = true;
        s.setLblUnentschieden(true);
      }

     if(ob.equals(s.getLbl())){
       //Spielt ton beim Clicken
       me.getInstance().getT().spieleTon2();
       
       s.setLblSpieler1(true);
       s.setLblSpieler2(false);
       me.getInstance().getS().setVisible(false);
       me.getInstance().getMp().setVisible(true);
     }
   }
   public void mouseClicked(MouseEvent mev){

   }
   
   public int getSpalte(){
     return this.spalte;
   }
}
