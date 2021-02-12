/*Diese Klasse ist ein JPanel und beinhaltet das Menü, das erscheint
  wenn man im Optionen-Menü auf den Schwierigkeit-JButton clickt.
  Dieses Menü beinhaltet 2 RadioButtons und 1 JButton.
  Der zugehörige Listener dieser Klasse ist SchwierigkeitListener.                 */

import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

public class Schwierigkeit extends JPanel{

  private JLabel lbl, lblS, lblI,lblB;
  private JRadioButton[] rBtn = new JRadioButton[2];
  private ButtonGroup grp;
  private int i;
  private int a = 0;
  SchwierigkeitListener myL = new SchwierigkeitListener(this);
  private Font f, f2, f3, f4;
  BufferedImage img = null;
  URL u;
  Icon ic;

  public Schwierigkeit(){
  
    this.setLayout(null);
    this.setBounds(0,0,515,555);
    this.setBackground(Color.orange);
    f = new Font("Impact",Font.TRUETYPE_FONT,14);
    f2 = new Font("Impact",Font.ROMAN_BASELINE,30);
    f3 = new Font("Impact",Font.ROMAN_BASELINE,35);
    f4 = new Font("Impact",Font.TRUETYPE_FONT,20);
    
    //JLabel von Schwierigkeit
    lbl = new JLabel();
    lbl.setBounds(120,185,300,50);
    lbl.setFont(f3);
    lbl.setText("Schwierigkeit");
    lbl.setForeground(new Color(208, 244, 248));
    this.add(lbl);
    
    grp = new ButtonGroup();
    
    for(i = 0;i< rBtn.length;i++){
     rBtn[i] = new JRadioButton();
     a = a + 50;
     rBtn[i].setBounds(100,215 + a,100,20);
     if(i == 0){
      rBtn[0].setText("Leicht");
     }
     if(i == 1){
      rBtn[1].setText("Schwer");
     }
     rBtn[i].setOpaque(false);
     rBtn[i].setForeground(new Color(208, 244, 248));
     rBtn[0].setSelected(true);
     grp.add(rBtn[i]);
     rBtn[i].addActionListener(myL);
     rBtn[i].setFont(f4);
     this.add(rBtn[i]);
    }
    
//    lblS = new JLabel();
//    lblS.setBounds(130,245,200,30);
//    lblS.setText("Leicht");
//    lblS.setFont(f4);
//    lblS.setForeground(Color.cyan);
//    this.add(lblS);
    
    
    lblB = new JLabel(new ImageIcon("src/Zurück.png"));
    lblB.setHorizontalTextPosition(lblB.getX());        //TextPosition muss vor allen anderen attributen von lblB gesetzt werden!
    lblB.setBounds(110,375,275,150);
    lblB.setFont(f);
    lblB.setText("Zurück");
    lblB.addMouseListener(myL);
    this.add(lblB);
    
    this.setVisible(true);
  }
  
   public JLabel getLblB(){
    return this.lblB;
  }
  public JRadioButton getRBtn(int i){
    return this.rBtn[i];
  }
  public JRadioButton[] getRBtnArr(){
    return this.rBtn;
  }
  public ButtonGroup getGrp(){
    return this.grp;
  }
  public JLabel getLbl(){
    return this.lbl;
  }
  public JLabel getLblS(){
    return this.lblS;
  }
  
  public void setPlatz(int x){
     System.out.println(x);
  }

  public void paintComponent(Graphics g)
  {
    try {                                                    //Try-Anweisung mit catch falls Bilddatei nicht gefunden wird.
     img = ImageIO.read(new File("src/SchwierigkeitHinter.png"));
    } catch (IOException e) {
      }
        // Zeichnet die BufferedImage-Datei(img) auf das JPanel.
    g.drawImage(img,0,0,null);
  }

}
