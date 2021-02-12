/*Diese Klasse ist ein JPanel und beinhaltet das Men�, das erscheint
  wenn man im Optionen-Men� auf den Sprache-JButton clickt.
  Dieses Men� beinhaltet 4 JButtons.
  Der zugeh�rige Listener dieser Klasse ist SpracheListener.                 */

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;


public class Sprache extends JPanel{

  private JLabel[] lbl= new JLabel[4];
  private int i;
  private int a = 0;
  SpracheListener myL = new SpracheListener(this);
  private Font f;
  BufferedImage img = null;
  
 public Sprache(){
    this.setLayout(null);
    this.setBounds(0,0,515,555);
    this.setBackground(Color.blue);
    this.getAccessibleContext();
    f = new Font("Impact",Font.TRUETYPE_FONT,14);


    for (i = 0;i<lbl.length;i++){
     lbl[i] = new JLabel(new ImageIcon("src/butt1.png"));
     lbl[i].setHorizontalTextPosition(lbl[i].getX());     //TextPosition muss vor allen anderen attributen von lbl[i] gesetzt werden!

     lbl[i] = new JLabel(new ImageIcon("src/butt1.png"));
     lbl[i].setHorizontalTextPosition(lbl[i].getX());

     if (i == 0){
      lbl[0].setText("Deutsch");
      lbl[0].setIcon(new ImageIcon("src/Deutsch.png"));
     }
     if (i == 1){
      lbl[1].setText("Englisch");
      lbl[1].setIcon(new ImageIcon("src/Englisch.png"));
     }
     if (i == 2){
      lbl[2].setText("Franz�sisch");
      lbl[2].setIcon(new ImageIcon("src/Franz�sisch.png"));
     }
     if (i == 3){
      lbl[3].setText("Zur�ck");
      lbl[3].setIcon(new ImageIcon("src/Zur�ck.png"));
     }

     lbl[i].setBounds(110, 176 + a, 275,50);
     a = a + 83;
     lbl[i].setFont(f);
     lbl[i].addMouseListener(myL);
     this.add(lbl[i]);

    }
  }

  //Getter f�r btn[j]
  public JLabel getLblOp(int j){
    return this.lbl[j];
  }

  public void paintComponent(Graphics g)
  {
    try {                                                    //Try-Anweisung mit catch falls Bilddatei nicht gefunden wird.
     img = ImageIO.read(new File("src/Sprachen.png"));
    } catch (IOException e) {
      }
        // Zeichnet die BufferedImage-Datei(img) auf das JPanel.
    g.drawImage(img,0,0,null);
  }
}
