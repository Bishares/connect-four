/*Diese Klasse ist ein JPanel und beinhaltet das Menü, das erscheint
  wenn man im Hauptmenü auf den Optionen-JButton clickt.
  Dieses Menü beinhaltet 4 JButtons.
  Der zugehörige Listener dieser Klasse ist OptionenListener.                 */

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class Optionen extends JPanel{

  private JLabel[] lbl = new JLabel[4];
  private int i;
  private int a = 0;
  OptionenListener myL = new OptionenListener(this);
  private Font f;
  BufferedImage img = null;
  
  //Konstruktor der Klasse Optionen
  public Optionen(){
    this.setLayout(null);
    this.setBounds(0,0,515,555);
    this.setBackground(Color.darkGray);
    this.getAccessibleContext();
    f = new Font("Impact",Font.TRUETYPE_FONT,14);
    
    for (i = 0;i<lbl.length;i++){
     lbl[i] = new JLabel(new ImageIcon("src/butt1.png"));
     lbl[i].setHorizontalTextPosition(lbl[i].getX());

     if (i == 0){
      lbl[0].setText("Musik/Ton");
      lbl[0].setIcon(new ImageIcon("src/Musik.png"));
     }
     if (i == 1){
      lbl[1].setText("Schwierigkeit");
      lbl[1].setIcon(new ImageIcon("src/Schwierigkeit.png"));
     }
     if (i == 2){
      lbl[2].setText("Sprache");
      lbl[2].setIcon(new ImageIcon("src/Sprache.png"));
     }
     if (i == 3){
      lbl[3].setText("Zurück");
      lbl[3].setIcon(new ImageIcon("src/Zurück.png"));
     }
     
     lbl[i].setBounds(110, 176 + a, 275,50);
     a = a + 83;
     lbl[i].setFont(f);
     lbl[i].addMouseListener(myL);
     this.add(lbl[i]);
    }
  }
  
  //Getter für lbl[j]
  public JLabel getLblOp(int j){
    return this.lbl[j];
  }
  
  public void paintComponent(Graphics g)
  {
    try {                                                    //Try-Anweisung mit catch falls Bilddatei nicht gefunden wird.
     img = ImageIO.read(new File("src/Optionen.png"));
    } catch (IOException e) {
      }
        // Zeichnet die BufferedImage-Datei(img) auf das JPanel.
    g.drawImage(img,0,0,null);
  }
}
