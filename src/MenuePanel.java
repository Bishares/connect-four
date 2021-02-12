/*Diese Klasse ist ein JPanel und beinhaltet das erste Menü, das erscheint
  wenn man das Programm startet.
  Dieses Menü beinhaltet 3 JButtons und ein Hintergrundbild.
  Der zugehörige Listener dieser Klasse ist MenueListener.                 */

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class MenuePanel extends JPanel {

 private JLabel[] lbl = new JLabel[3];
 private JTextField txt1;
 private JRadioButton[] rdBtn = new JRadioButton[2];
 private ButtonGroup grp;
 private int spielArt = 1;
 private int j;
 private int a = 0;
 MenueListener myL = new MenueListener(this);
 private Font f, f1;
 BufferedImage img = null;
 
 //Konstruktor der Klasse MenuePanel
  public MenuePanel(){
    this.setLayout(null);
    this.setBounds(0,0,515,555);                         //Größe und Positon
    this.setBackground(Color.blue);                      //Hintergrundfarbe
    this.getAccessibleContext();
    f = new Font("Impact",Font.TRUETYPE_FONT,14);        // Initialisiert neue Schriftart("Schriftart",Schrifttyp,Schriftgröße)
    f1 = new Font("Dialog",Font.BOLD,14);
    
    grp = new ButtonGroup();

     rdBtn[0] = new JRadioButton("Singleplayer");
     rdBtn[0].setBounds(240,263,150,25);
     rdBtn[0].setOpaque(false);
     rdBtn[0].setSelected(false);
     rdBtn[0].setForeground(new Color(208, 244, 248));
     rdBtn[0].setFont(f1);
     grp.add(rdBtn[0]);
     rdBtn[0].addMouseListener(myL);
     this.add(rdBtn[0]);

     rdBtn[1] = new JRadioButton("Multiplayer");
     rdBtn[1].setBounds(130,263,150,25);
     rdBtn[1].setOpaque(false);
     rdBtn[1].setSelected(true);
     rdBtn[1].setForeground(new Color(208, 244, 248));
     rdBtn[1].setFont(f1);
     grp.add(rdBtn[1]);
     rdBtn[1].addMouseListener(myL);
     this.add(rdBtn[1]);
    
    //Menue-Bilder definieren(JLabel)
    for (j= 0; j < lbl.length;j++){

     lbl[j] = new JLabel(new ImageIcon("src/butt1.png"));
     lbl[j].setHorizontalTextPosition(lbl[j].getX());    //TextPosition muss vor allen anderen attributen von lbl[j] gesetzt werden!
     lbl[j].setBounds(110,205+a,275,50);
     a = a +110;
     if (j == 0){
      lbl[0].setIcon(new ImageIcon("src/BtnSs.png"));
      lbl[0].setText("Spielen");
     }
     if (j == 1){
      lbl[1].setIcon(new ImageIcon("src/BtnOpt.png"));
      lbl[1].setText("Optionen");
     }
     if (j == 2){
      lbl[2].setIcon(new ImageIcon("src/BtnBe.png"));
      lbl[2].setText("Beenden");
     }
     lbl[j].setFont(f);
     lbl[j].addMouseListener(myL);
     lbl[j].setVisible(true);
     this.add(lbl[j]);
    }
  }

  //Getter für lbl[j]
  public JLabel getLblOp(int j){
    return this.lbl[j];
  }
  
  //Getter für JLabel[] lbl
  public JLabel[] getLbl(){
    return this.lbl;
  }
  
  //Setter für JLabel[] lbl
  public void setLbl(JLabel[] l){
    this.lbl = l;
  }
  
  public JRadioButton getRdBtn(int x){
    return rdBtn[x];
  }
  
  public void setMultiSingle(int x){
    spielArt = x;
  }
  
  public int getMultiSingle(){
    return spielArt;
  }
  
  public void paintComponent(Graphics g)
  {
    try {                                                    //Try-Anweisung mit catch falls Bilddatei nicht gefunden wird.
     img = ImageIO.read(new File("src/Home.png"));
    } catch (IOException e) {
      }
        // Zeichnet die BufferedImage-Datei(img) auf das JPanel.
    g.drawImage(img,0,0,null);
  }


}
