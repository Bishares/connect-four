//blau ist spieler 1
//grün ist spieler 2
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class Spiel extends JPanel{

   private JLabel[][] lblFeld = new JLabel[6][7];
   private boolean[][] belegt = new boolean[6][7];
   private JLabel lblGewonnen1, lblGewonnen2, lblSpieler1, lblSpieler2, lblUnentschieden;
   private JLabel lbl, lblNeu;
   private Font f1;
   
   ImageIcon b = new ImageIcon("src/Feldgrün3.png");
   ImageIcon c = new ImageIcon("src/Feldblau3.png");
   
   ImageIcon d = new ImageIcon("src/Feldleer3.png");
   
   Icon g = new ImageIcon("src/FeldblauWin3.gif");
   Icon f = new ImageIcon("src/FeldgrünWin3.gif");

   BufferedImage img = null;

   private int[][] spieler = new int[6][7];
   Menue me;
   
   MausListener myM = new MausListener(this);
   
   private int x = 12;
   private int y = 472;
   private int richtige = 1;
   private boolean voll = false;
   private boolean vier = false;
   private int[][] gewinner1 = new int[6][7];
   private int[][] gewinner2 = new int[6][7];
   


   public Spiel(int nix){
     System.out.println(nix);
   }

   public Spiel(){
      this.setLayout(null);
      this.setBounds(0,0,515,555);
      this.setBackground(Color.white);
      
      f1 = new Font("Impact",Font.TRUETYPE_FONT,14);

      for(int i = 0; i<6; i++){
        for(int j = 0; j<7; j++){
           lblFeld[i][j] = new JLabel("");
           lblFeld[i][j].setBounds(x,y, 70, 70);
           this.add(lblFeld[i][j]);
           x = x + 70;
           lblFeld[i][j].setIcon(d);
           lblFeld[i][j].addMouseListener(myM);
        }
        x = 12;
        y = y - 70;
      }

      lbl = new JLabel(new ImageIcon("src/IngameButtonZurück.png"));
      lbl.setText("Zurück");
      lbl.setFont(f1);
      lbl.setHorizontalTextPosition(lbl.getX());
      lbl.setBounds(8, 24, 210, 30);
      lbl.addMouseListener(myM);
      this.add(lbl);
      
      lblNeu = new JLabel(new ImageIcon("src/IngameButtonNeuesSpiel.png"));
      lblNeu.setText("Neues Spiel");
      lblNeu.setFont(f1);
      lblNeu.setHorizontalTextPosition(lblNeu.getX());
      lblNeu.setBounds(291, 24, 220, 30);
      lblNeu.addMouseListener(myM);
      this.add(lblNeu);
      
      lblGewonnen1 = new JLabel("Spieler 1 hat gewonnen");
      lblGewonnen1.setBounds(14, 45, 200, 50);
      lblGewonnen1.setForeground(new Color(109, 232, 231));
      lblGewonnen1.setFont(new Font("Dialog", Font.BOLD , 14));
      //lblGewonnen1.setHorizontalAlignment(SwingConstants.CENTER);
      lblGewonnen1.addMouseListener(myM);
      lblGewonnen1.setVisible(false);
      this.add(lblGewonnen1);
      
      lblGewonnen2 = new JLabel("Spieler 2 hat gewonnen");
      lblGewonnen2.setBounds(337, 45, 200, 50);
      lblGewonnen2.setForeground(new Color(118, 232, 109));
      lblGewonnen2.setFont(new Font("Dialog", Font.BOLD , 14));
      //lblGewonnen2.setHorizontalAlignment(SwingConstants.CENTER);
      lblGewonnen2.addMouseListener(myM);
      lblGewonnen2.setVisible(false);
      this.add(lblGewonnen2);
      
      lblUnentschieden = new JLabel("Unentschieden");
      lblUnentschieden.setBounds(5, 70, 515, 50);
      lblUnentschieden.setForeground(Color.yellow);
      lblUnentschieden.setFont(new Font("Dialog", Font.BOLD , 20));
      lblUnentschieden.setHorizontalAlignment(SwingConstants.CENTER);
      lblUnentschieden.addMouseListener(myM);
      lblUnentschieden.setVisible(false);
      this.add(lblUnentschieden);
      
      lblSpieler1 = new JLabel("Spieler 1");
      lblSpieler1.setBounds(110, 45, 70, 50);
      lblSpieler1.setForeground(new Color(109, 232, 231));
      lblSpieler1.setFont(new Font("Dialog", Font.BOLD, 15));
      lblSpieler1.addMouseListener(myM);
      this.add(lblSpieler1);
      
      lblSpieler2 = new JLabel("Spieler 2");
      lblSpieler2.setBounds(350, 45, 70, 50);
      lblSpieler2.setForeground(new Color(118, 232, 109));
      lblSpieler2.setFont(new Font("Dialog", Font.BOLD, 15));
      lblSpieler2.addMouseListener(myM);
      lblSpieler2.setVisible(false);
      this.add(lblSpieler2);
      
      for(int i = 0; i<6; i++){      //spieler, belegt array auf 0 setzten
        for(int j = 0; j<7; j++){
          spieler[i][j] = 0;
          belegt[i][j] = false;
        }
      }
      
      this.setVisible(true);

   }
   
   public JLabel getLblFeld(int a, int b){
     return lblFeld[a][b];
   }
   
   public void setLblFeld(int x, int y, int spieler){
     if(spieler == 1){
       lblFeld[x][y].setIcon(c);
     }else{
       lblFeld[x][y].setIcon(b);
     }
   }
   
   public JLabel getLbl(){
     return this.lbl;
   }
   
   public JLabel getLblNeu(){
     return this.lblNeu;
   }
   
   public void setBelegt(int a, int b){
      belegt[a][b] = true;
   }
   
   public boolean getBelegt(int a, int b){
      return belegt[a][b];
   }
   
   public void setSpieler(int a, int b, int sp){
      spieler[a][b] = sp;
   }
   
   public int getSpieler(int a, int b){
      return spieler[a][b];
   }
   
   public JLabel getLblSpieler1(){
     return this.lblSpieler1;
   }
   
   public JLabel getLblSpieler2(){
     return this.lblSpieler2;
   }
   
   public void setLblSpieler1(boolean z){
     lblSpieler1.setVisible(z);
   }
   
   public void setLblSpieler2(boolean z){
     lblSpieler2.setVisible(z);
   }
   
   public JLabel getLblGewonnen1(){
     return this.lblGewonnen1;
   }
   
   public JLabel getLblGewonnen2(){
     return this.lblGewonnen2;
   }
   
   public void setLblGewonnen1(boolean z){
     lblGewonnen1.setVisible(z);
   }
   
   public void setLblGewonnen2(boolean z){
     lblGewonnen2.setVisible(z);
   }
   
   public JLabel getLblUnentschieden(){
     return this.lblUnentschieden;
   }
   
   public void setLblUnentschieden(boolean z){
     lblUnentschieden.setVisible(z);
   }
   
   public boolean gewinner1(){
      for(int a = 0; a<6; a++){
        for(int b = 0; b<6; b++){
        
            if(spieler[a][b] == spieler[a][b+1] && spieler[a][b] == 1 && vier == false){
            
              richtige = richtige + 1;
              gewinner1[a][b] = 1;
              
              if(richtige == 4){
                vier = true;
                gewinner1[a][b+1] = 1;
              }
              
            }else{
              richtige = 1;
              if(vier == false){
                for(int i = 0; i<6; i++){
                  for(int j = 0; j<7; j++){
                    gewinner1[i][j] = 0;
                  }
                }
              }

            }
        }
      }
      
      if(vier == true){
        return true;
      }else{
        return false;
      }
      
   }

   public boolean gewinner2(){
      for(int a = 0; a<6; a++){
        for(int b = 0; b<6; b++){
            if(spieler[a][b] == spieler[a][b+1] && spieler[a][b] == 2 && vier == false){

              richtige = richtige + 1;
              gewinner2[a][b] = 2;
              
              if(richtige == 4){
                vier = true;
                gewinner2[a][b+1] = 2;
              }

            }else{
              richtige = 1;
              if(vier == false){
                for(int i = 0; i<6; i++){
                  for(int j = 0; j<7; j++){
                    gewinner2[i][j] = 0;
                  }
                }
              }
            }
        }
      }

      if(vier == true){
        return true;
      }else{
        return false;
      }
   }
   
   public boolean senkrecht1(){

      for(int a = 0; a<7; a++){
        for(int b = 0; b<5 ; b++){
           if(spieler[b][a] == 1 && spieler[b][a] == spieler[b+1][a] && vier == false){

              gewinner1[b][a] = 1;
              richtige = richtige +1;

             if(richtige == 4){
                vier = true;
                gewinner1[b+1][a] = 1;
             }

           }else{

              richtige = 1;

              if(vier == false){
                for(int i = 0; i<6; i++){
                  for(int j = 0; j<7; j++){
                    gewinner1[i][j] = 0;
                  }
                }
              }
           }
        }
      }

      if(vier == true){
        return true;
      }else{
        return false;
      }
   }
   
   public boolean senkrecht2(){

      for(int a = 0; a<7; a++){
        for(int b = 0; b<5 ; b++){
           if(spieler[b][a] == 2 && spieler[b][a] == spieler[b+1][a] && vier == false){

              gewinner2[b][a] = 2;
              richtige = richtige +1;

             if(richtige == 4){
                vier = true;
                gewinner2[b+1][a] = 2;
             }

           }else{

              richtige = 1;

              if(vier == false){
                for(int i = 0; i<6; i++){
                  for(int j = 0; j<7; j++){
                    gewinner2[i][j] = 0;
                  }
                }
              }
           }
        }
      }

      if(vier == true){
        return true;
      }else{
        return false;
      }
   }
   
   public boolean diagonal1(int x, int y){

      int i = x;
      int j = y;
      
          if(spieler[i][j]==1 && spieler[i][j] == spieler[i+1][j+1] && vier == false){
            gewinner1[i][j] = 1;
            richtige = richtige + 1;

            if(spieler[i+1][j+1] == 1 && spieler[i+1][j+1] == spieler[i+2][j+2]){
              gewinner1[i+1][j+1] = 1;
              richtige = richtige + 1;

              if(spieler[i+2][j+2] == 1 && spieler[i+2][j+2] == spieler[i+3][j+3]){
                gewinner1[i+2][j+2] = 1;
                gewinner1[i+3][j+3] = 1;
                richtige = richtige + 1;

                vier = true;

              }else{
                richtige = 1;
                if(vier == false){
                  for(int a = 0; a<6; a++){
                    for(int b = 0; b<7; b++){
                      gewinner1[a][b] = 0;
                    }
                  }
                }

              }

            }else{
              richtige = 1;
              if(vier == false){
                for(int a = 0; a<6; a++){
                  for(int b = 0; b<7; b++){
                    gewinner1[a][b] = 0;
                  }
                }
              }
            }

          }else{
            richtige = 1;
            if(vier == false){
              for(int a = 0; a<6; a++){
                for(int b = 0; b<7; b++){
                  gewinner1[a][b] = 0;
                }
              }
            }
          }
          
      if(vier == true){
        return true;
      }else{
        return false;
      }
   }
   
   public boolean diagonal2(int x, int y){

      int i = x;
      int j = y;
      
          if(spieler[i][j] == 2 && spieler[i][j] == spieler[i+1][j+1] && vier == false){
            gewinner2[i][j] = 2;
            richtige = richtige + 1;

            if(spieler[i+1][j+1] == 2 && spieler[i+1][j+1] == spieler[i+2][j+2]){
              gewinner2[i+1][j+1] = 2;
              richtige = richtige + 1;

              if(spieler[i+2][j+2] == 2 && spieler[i+2][j+2] == spieler[i+3][j+3]){
                gewinner2[i+2][j+2] = 2;
                gewinner2[i+3][j+3] = 2;
                richtige = richtige + 1;

                vier = true;

              }else{
                richtige = 1;
                if(vier == false){
                  for(int a = 0; a<6; a++){
                    for(int b = 0; b<7; b++){
                      gewinner2[a][b] = 0;
                    }
                  }
                }

              }

            }else{
              richtige = 1;
              if(vier == false){
                for(int a = 0; a<6; a++){
                  for(int b = 0; b<7; b++){
                    gewinner2[a][b] = 0;
                  }
                }
              }
            }

          }else{
            richtige = 1;
            if(vier == false){
              for(int a = 0; a<6; a++){
                for(int b = 0; b<7; b++){
                  gewinner2[a][b] = 0;
                }
              }
            }
          }

      if(vier == true){
        return true;
      }else{
        return false;
      }
   }
   
   public boolean diagonal3(int x, int y){
   
      int i = x;
      int j = y;
      
          if(spieler[i][j]==1 && spieler[i][j] == spieler[i+1][j-1] && vier == false){
            gewinner1[i][j] = 1;
            richtige = richtige + 1;

            if(spieler[i+1][j-1] == 1 && spieler[i+1][j-1] == spieler[i+2][j-2]){
              gewinner1[i+1][j-1] = 1;
              richtige = richtige + 1;

              if(spieler[i+2][j-2] == 1 && spieler[i+2][j-2] == spieler[i+3][j-3]){
                gewinner1[i+2][j-2] = 1;
                gewinner1[i+3][j-3] = 1;
                richtige = richtige + 1;

                vier = true;

              }else{
                richtige = 1;
                if(vier == false){
                  for(int a = 0; a<6; a++){
                    for(int b = 0; b<7; b++){
                      gewinner1[a][b] = 0;
                    }
                  }
                }

              }

            }else{
              richtige = 1;
              if(vier == false){
                for(int a = 0; a<6; a++){
                  for(int b = 0; b<7; b++){
                    gewinner1[a][b] = 0;
                  }
                }
              }
            }

          }else{
            richtige = 1;
            if(vier == false){
              for(int a = 0; a<6; a++){
                for(int b = 0; b<7; b++){
                  gewinner1[a][b] = 0;
                }
              }
            }
          }

      if(vier == true){
        return true;
      }else{
        return false;
      }
   }
   
   public boolean diagonal4(int x, int y){
   
      int i = x;
      int j = y;
      
          if(spieler[i][j]==2 && spieler[i][j] == spieler[i+1][j-1] && vier == false){
            gewinner2[i][j] = 2;
            richtige = richtige + 1;

            if(spieler[i+1][j-1] == 2 && spieler[i+1][j-1] == spieler[i+2][j-2]){
              gewinner2[i+1][j-1] = 2;
              richtige = richtige + 1;

              if(spieler[i+2][j-2] == 2 && spieler[i+2][j-2] == spieler[i+3][j-3]){
                gewinner2[i+2][j-2] = 2;
                gewinner2[i+3][j-3] = 2;
                richtige = richtige + 1;

                vier = true;

              }else{
                richtige = 1;
                if(vier == false){
                  for(int a = 0; a<6; a++){
                    for(int b = 0; b<7; b++){
                      gewinner2[a][b] = 0;
                    }
                  }
                }

              }

            }else{
              richtige = 1;
              if(vier == false){
                for(int a = 0; a<6; a++){
                  for(int b = 0; b<7; b++){
                    gewinner2[a][b] = 0;
                  }
                }
              }
            }

          }else{
            richtige = 1;
            if(vier == false){
              for(int a = 0; a<6; a++){
                for(int b = 0; b<7; b++){
                  gewinner2[a][b] = 0;
                }
              }
            }
          }

      if(vier == true){
        return true;
      }else{
        return false;
      }                                                                         //erreicht am 12.03.2012 um 14:10 UHR
   }
   
   public void zuruecksetzten(){
     for(int a = 0; a<6; a++){
       for(int b = 0; b<7; b++){
          lblFeld[a][b].setIcon(d);
          gewinner1[a][b] = 0;
          gewinner2[a][b] = 0;
          spieler[a][b] = 0;
          belegt[a][b] = false;
          richtige = 1;
          voll = false;
          vier = false;
       }
     }
     this.setLblGewonnen1(false);
     this.setLblGewonnen2(false);
   }
   
   public void gewonnen(int spi){
     for(int i = 0; i<6; i++){
       for(int j = 0; j<7; j++){
         if(spi == 1 && gewinner1[i][j] == 1){
           lblFeld[i][j].setIcon(g);
         }
         if(spi == 2 && gewinner2[i][j] == 2){
           lblFeld[i][j].setIcon(f);
         }
       }
     }
   }
   
   public boolean vollesFeld(){
     int a = 0;
     boolean abbrechen = false;
     do{
        if(belegt[5][a]==true){
          a = a+1;
          abbrechen = false;
          if(a == 7){
            voll = true;
            abbrechen = true;
          }
        }else{
          abbrechen = true;
          voll = false;
        }
     }while(abbrechen == false);
     return voll;
   }
   
   public void paintComponent(Graphics g)
  {
    try {
     img = ImageIO.read(new File("src/background4.png"));
     g.drawImage(img,0,0,null);
    } catch (IOException e){
    }
        // Draws the img to the BackgroundPanel.

  }
  //Für Alternative KI
 /*  public void chance(){
   
     boolean fertig = false;
   
     for(int i = 0; i<7; i++){
       for(int j = 0; j<4; j++){
         if(spieler[j][i] == 2 && spieler[j+1][i] == 2){
            richtige = richtige + 1;
            if(richtige == 3 && belegt[j+2][i] == false){
              this.setLblFeld(j+2,i,2);
              belegt[j+2][i] = true;
              spieler[j+2][i] = 2;
              gewinner2[j+2][i] = 2;
            }
         }else{
           richtige = 1;
         }
       }
     }
     
       richtige = 1;
       for(int i = 0; i<6; i++){
         for(int j = 0; j<5; j++){
            if(spieler[i][j]==2 && spieler[i][j+1]==2){
               richtige = richtige + 1;
               try{
                 if(richtige == 3 && belegt[i][j+2] == false && belegt[i-1][j+2] == true){
                   this.setLblFeld(i,j+2,2);
                   belegt[i][j+2] = true;
                   spieler[i][j+2] = 2;
                   gewinner2[i][j+2] = 2;
                 }
                 if(richtige == 3 && belegt[i][j-2] == false && belegt[i-1][j-2] == true){
                   this.setLblFeld(i,j-2,2);
                   belegt[i][j-2] = true;
                   spieler[i][j-2] = 2;
                   gewinner2[i][j-2] = 2;
                 }
               }catch(Exception e){
                  if(richtige == 3 && belegt[i][j+2] == false){
                   this.setLblFeld(i,j+2,2);
                   belegt[i][j+2] = true;
                   spieler[i][j+2] = 2;
                   gewinner2[i][j+2] = 2;
                 }
                 if(richtige == 3 && belegt[i][j-2] == false){
                   this.setLblFeld(i,j-2,2);
                   belegt[i][j-2] = true;
                   spieler[i][j-2] = 2;
                   gewinner2[i][j-2] = 2;
                 }
               }
            }else{
              richtige = 1;
            }
         }
       }
       
       richtige = 1;
       
       for(int i = 0; i<3; i++){
          for(int j = 0; j<4; j++){
            if(spieler[i][j] == 2 && spieler[i][j] == spieler[i+1][j+1]){
              if(spieler[i+1][j+1] == 2 && spieler[i+1][j+1] == spieler[i+2][j+2]){
                if(belegt[i+3][j+3] == false && belegt[i+2][j+3] == true){
                  this.setLblFeld(i+3,j+3,2);
                  belegt[i+3][j+3] = true;
                  spieler[i+3][j+3] = 2;
                  gewinner2[i+3][j+3] = 2;
                }
              }
            }
          }
       }
       
//       for(int i = 0; i<3; i++){
//          for(int j = 3; j<7; j++){
//            if(spieler[i][j] == 2 && spieler[i][j] == spieler[i+1][j-1]){
//              if(spieler[i+1][j+1] == 2 && spieler[i+1][j+1] == spieler[i+2][j-2]){
//                if(belegt[i+3][j+3] == false && belegt[i+2][j+3] == true){
//                  this.setLblFeld(i+3,j+3,2);
//                  belegt[i+3][j+3] = true;
//                  spieler[i+3][j+3] = 2;
//                  gewinner2[i+3][j+3] = 2;
//                }
//              }
//            }
//          }
//       }
   }                        */
   
   public void umwandeln(int feld[][]){
     for(int i = 0; i<7; i++){
       for(int j = 0; j<6; j++){
         if(feld[i][j] == 1){
           this.setLblFeld(i,j,1);
         }
         if(feld[i][j] == -1){
           this.setLblFeld(i,j,2);
         }
       }
     }
   }
   
  public MausListener getMyM(){
    return myM;
  }
}
