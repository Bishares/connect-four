/* Diese Klasse behandelt die Aktionen, welche Folgen, wenn man einen der 4
   JButtons der Klasse Sprache angeclickt hat. */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class SpracheListener implements MouseListener{

  Sprache s;
  Menue me;
  MenuePanel mp;
  Spiel si;
  Optionen o;
  Schwierigkeit sw;
                   //0          1         2         3         4             5            6         7            8         9           10           11           12       13      14            15            16            17                 18                       19                     20
  String[] de = {"Spielen","Optionen","Beenden", "Zurück","Musik",  "Schwierigkeit","Leicht","Schwer",   "Sprache", "Deutsch",  "Englisch","Französisch","Lautstärke",  "AN",  "AUS",    "Neues Spiel", "Spieler 1", "Spieler 2", "Spieler 1 hat gewonnen", "Spieler 2 hat gewonnen", "Unentschieden"};
  String[] en = {"Play",   "Options", "End Game","Back",  "Sound",      "Difficulty",   "Easy",  "Hard",     "Language","German",   "English", "French",     "Volume",  "ON","OFF", "New Game", "Player 1", "Player 2", "Player 1 has won", "Player 2 has won", "Draw"};
  String[] fr = {"Jouer",  "Option",  "Finir",   "Retour","Musique","Difficulté",   "Simple","Difficile","Langue",  "Allemande","Anglais", "Français",   "Volume", "OUI",  "NON", "Nouveau Jeu", "Joueur 1", "Joueur 2", "Joueur 1 a gagné", "Joueur 2 a gagné", "Match nul"};



  //Konstruktor der Klasse OptionenListener
  public SpracheListener(Sprache sp){
    s = sp;
  }

  public void mouseExited(MouseEvent me){
   Object ob = me.getSource();
   
   for ( int j = 0;j< 4;j++){
     if (ob.equals(s.getLblOp(0))){
      s.getLblOp(0).setIcon(new ImageIcon("src/Deutsch.png"));
     }

     if (ob.equals(s.getLblOp(1))){
       s.getLblOp(1).setIcon(new ImageIcon("src/Englisch.png"));
     }

     if (ob.equals(s.getLblOp(2))){
      s.getLblOp(2).setIcon(new ImageIcon("src/Französisch.png"));
     }
     
     if (ob.equals(s.getLblOp(3))){
      s.getLblOp(3).setIcon(new ImageIcon("src/Zurück.png"));
     }
   }
  }
  public void mouseEntered(MouseEvent men){
   Object ob = men.getSource();
   
   if (ob.equals(s.getLblOp(0))){
    s.getLblOp(0).setIcon(new ImageIcon("src/DeutschA.png"));
   }
   
   if (ob.equals(s.getLblOp(1))){
     s.getLblOp(1).setIcon(new ImageIcon("src/EnglischA.png"));
   }
     
   if (ob.equals(s.getLblOp(2))){
    s.getLblOp(2).setIcon(new ImageIcon("src/FranzösischA.png"));
   }
   if (ob.equals(s.getLblOp(3))){
    s.getLblOp(3).setIcon(new ImageIcon("src/ZurückA.png"));
   }
  }
  public void mouseClicked(MouseEvent mc){

  }
  public void mouseReleased(MouseEvent mr){

  }
  public void mousePressed(MouseEvent mp){
    Object ob = mp.getSource();

   for ( int j = 0;j< 4;j++){
     if (ob.equals(s.getLblOp(j))){
       switch(j){
         case 0:                       //Spielt ton beim Clicken
                                       me.getInstance().getT().spieleTon();
                                       
                                       me.getInstance().getS().getLbl().setText(de[3]);
                                       me.getInstance().getS().getLblNeu().setText(de[15]);
                                       me.getInstance().getS().getLblSpieler1().setText(de[16]);
                                       me.getInstance().getS().getLblSpieler2().setText(de[17]);
                                       me.getInstance().getS().getLblGewonnen1().setText(de[18]);
                                       me.getInstance().getS().getLblGewonnen2().setText(de[19]);
                                       me.getInstance().getS().getLblUnentschieden().setText(de[20]);
                                       
                                       me.getInstance().getMp().getLblOp(0).setText(de[0]);
                                       me.getInstance().getMp().getLblOp(1).setText(de[1]);
                                       me.getInstance().getMp().getLblOp(2).setText(de[2]);
                                       
                                       me.getInstance().getO().getLblOp(0).setText(de[4]);
                                       me.getInstance().getO().getLblOp(1).setText(de[5]);
                                       me.getInstance().getO().getLblOp(2).setText(de[8]);
                                       me.getInstance().getO().getLblOp(3).setText(de[3]);
                                       
                                       me.getInstance().getSw().getLbl().setText(de[5]);
                                       me.getInstance().getSw().getLblB().setText(de[3]);
                                       me.getInstance().getSw().getRBtn(0).setText(de[6]);
                                       me.getInstance().getSw().getRBtn(1).setText(de[7]);
                                       
                                       me.getInstance().getSp().getLblOp(0).setText(de[9]);
                                       me.getInstance().getSp().getLblOp(1).setText(de[10]);
                                       me.getInstance().getSp().getLblOp(2).setText(de[11]);
                                       me.getInstance().getSp().getLblOp(3).setText(de[3]);
                                       
                                       me.getInstance().getT().getRBtn(0).setText(de[13]);
                                       me.getInstance().getT().getRBtn(1).setText(de[14]);
                                       me.getInstance().getT().getLblV().setText(de[12]);
                                       me.getInstance().getT().getLbl2().setText(de[4]);
                                       me.getInstance().getT().getLblB().setText(de[3]);

                                       break;

         case 1:                       //Spielt ton beim Clicken
                                       me.getInstance().getT().spieleTon();
                                       
                                       me.getInstance().getS().getLbl().setText(en[3]);
                                       me.getInstance().getS().getLblNeu().setText(en[15]);
                                       me.getInstance().getS().getLblSpieler1().setText(en[16]);
                                       me.getInstance().getS().getLblSpieler2().setText(en[17]);
                                       me.getInstance().getS().getLblGewonnen1().setText(en[18]);
                                       me.getInstance().getS().getLblGewonnen2().setText(en[19]);
                                       me.getInstance().getS().getLblUnentschieden().setText(en[20]);
                                       
                                       me.getInstance().getMp().getLblOp(0).setText(en[0]);
                                       me.getInstance().getMp().getLblOp(1).setText(en[1]);
                                       me.getInstance().getMp().getLblOp(2).setText(en[2]);
                                       
                                       me.getInstance().getO().getLblOp(0).setText(en[4]);
                                       me.getInstance().getO().getLblOp(1).setText(en[5]);
                                       me.getInstance().getO().getLblOp(2).setText(en[8]);
                                       me.getInstance().getO().getLblOp(3).setText(en[3]);
                                       
                                       me.getInstance().getSw().getLbl().setText(en[5]);
                                       me.getInstance().getSw().getLblB().setText(en[3]);
                                       me.getInstance().getSw().getRBtn(0).setText(en[6]);
                                       me.getInstance().getSw().getRBtn(1).setText(en[7]);
                                       
                                       me.getInstance().getSp().getLblOp(0).setText(en[9]);
                                       me.getInstance().getSp().getLblOp(1).setText(en[10]);
                                       me.getInstance().getSp().getLblOp(2).setText(en[11]);
                                       me.getInstance().getSp().getLblOp(3).setText(en[3]);
                                       
                                       me.getInstance().getT().getRBtn(0).setText(en[13]);
                                       me.getInstance().getT().getRBtn(1).setText(en[14]);
                                       me.getInstance().getT().getLblV().setText(en[12]);
                                       me.getInstance().getT().getLbl2().setText(en[4]);
                                       me.getInstance().getT().getLblB().setText(en[3]);
                                       break;

         case 2:                       //Spielt ton beim Clicken
                                       me.getInstance().getT().spieleTon();
                                       
                                       me.getInstance().getS().getLbl().setText(fr[3]);
                                       me.getInstance().getS().getLblNeu().setText(fr[15]);
                                       me.getInstance().getS().getLblSpieler1().setText(fr[16]);
                                       me.getInstance().getS().getLblSpieler2().setText(fr[17]);
                                       me.getInstance().getS().getLblGewonnen1().setText(fr[18]);
                                       me.getInstance().getS().getLblGewonnen2().setText(fr[19]);
                                       me.getInstance().getS().getLblUnentschieden().setText(fr[20]);
                                       
                                       me.getInstance().getMp().getLblOp(0).setText(fr[0]);
                                       me.getInstance().getMp().getLblOp(1).setText(fr[1]);
                                       me.getInstance().getMp().getLblOp(2).setText(fr[2]);
                                       
                                       me.getInstance().getO().getLblOp(0).setText(fr[4]);
                                       me.getInstance().getO().getLblOp(1).setText(fr[5]);
                                       me.getInstance().getO().getLblOp(2).setText(fr[8]);
                                       me.getInstance().getO().getLblOp(3).setText(fr[3]);
                                       
                                       me.getInstance().getSw().getLbl().setText(fr[5]);
                                       me.getInstance().getSw().getLblB().setText(fr[3]);
                                       me.getInstance().getSw().getRBtn(0).setText(fr[6]);
                                       me.getInstance().getSw().getRBtn(1).setText(fr[7]);
                                       
                                       me.getInstance().getSp().getLblOp(0).setText(fr[9]);
                                       me.getInstance().getSp().getLblOp(1).setText(fr[10]);
                                       me.getInstance().getSp().getLblOp(2).setText(fr[11]);
                                       me.getInstance().getSp().getLblOp(3).setText(fr[3]);
                                       
                                       me.getInstance().getT().getRBtn(0).setText(fr[13]);
                                       me.getInstance().getT().getRBtn(1).setText(fr[14]);
                                       me.getInstance().getT().getLblV().setText(fr[12]);
                                       me.getInstance().getT().getLbl2().setText(fr[4]);
                                       me.getInstance().getT().getLblB().setText(fr[3]);
                                       break;

         case 3:                       //Spielt ton beim Clicken
                                       me.getInstance().getT().spieleTon2();
                                       
                                       me.getInstance().getSp().setVisible(false);
                                       me.getInstance().getO().setVisible(true);
                                       break;
       }
     }
   }
  }
  
  public String getDe(int i){
    return this.de[i];
  }
  public String getEn(int i){
    return this.en[i];
  }
  public String getFr(int i){
    return this.fr[i];
  }
  public Sprache getS(){
    return this.s;
  }
}
