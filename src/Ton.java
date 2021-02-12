/*Diese Klasse ist ein JPanel und beinhaltet das Menü, das erscheint
  wenn man im Optionen-Menü auf den Ton-JButton clickt.
  Dieses Menü beinhaltet 2 RadioButtons, 1 JSlider und 1 JButton.
  Der zugehörige Listener dieser Klasse ist TonListener.
  Die Methoden spieleTon,spieleTon2,spieleTon3,spieleTon4 und spieleMusik
  spielen beim Aufruf verschiedene wav- oder midi-Dateien ab.                  */

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.net.*;
import javax.sound.midi.*;
import javax.sound.sampled.spi.*;
import javax.sound.sampled.*;

public class Ton extends JPanel{
  private JLabel[] lblS = new JLabel[2];
  private JSlider[] sl = new JSlider[2];
  private JRadioButton[] rBtn = new JRadioButton[4];
  private ButtonGroup grp;
  private ButtonGroup grp2;
  private JLabel lbl2,lbl3,lblI,lblB, lblV;
  private Font f,f1,f2;
  private int i,a;
  private int anAus = 1;
  TonListener myL = new TonListener(this);
  BufferedImage img = null;
  private URL u;
  private Clip clip;
  
  Sequencer sequencer;
  Synthesizer synth;
  Menue me;

  public Ton(){
    this.setLayout(null);
    this.setBounds(0,0,515,555);
    this.setBackground(Color.yellow);
    f = new Font("Impact",Font.ROMAN_BASELINE,20);
    f1 = new Font("Impact",Font.TRUETYPE_FONT,15);
    f2 = new Font("Impact",Font.TRUETYPE_FONT,30);
    
    for(i=0;i<2;i++){
      //JSlider definieren
      if(i==0){
        sl[i] = new JSlider();
        sl[i].setBounds(130,320+a,100,30);
        sl[i].setMinimum(1);
        sl[i].setMaximum(20);
        sl[i].setValue(10);
        sl[i].setForeground(Color.cyan);
        sl[i].addChangeListener(myL);
        sl[i].setOpaque(false);
        this.add(sl[i]);
      }
      
      //JLabels2 definieren
      lblS[i] = new JLabel();
      a = 50+a;
      lblS[i].setBounds(300,50+a,100,30);
      if(i==0){
        lblS[0].setBounds(230, 320, 30, 30);
        lblS[0].setForeground(new Color(208, 244, 248));
        lblS[0].setFont(f);
        lblS[0].setText(""+sl[i].getValue());
      }
//      if(i==1){
//        lblS[1].setText(""+sl[i].getValue());
//      }
      lblS[i].setFont(f);
      this.add(lblS[i]);
    }
    for(i=0;i<rBtn.length;i++){
      //Radio Buttons definieren
      
      grp = new ButtonGroup();
      grp2 = new ButtonGroup();
      
      rBtn[i] = new JRadioButton();
      rBtn[i].addMouseListener(myL);
      rBtn[i].setForeground(new Color(208, 244, 248));
      rBtn[i].setFont(f1);

      if(i==0){
       rBtn[0].setBounds(130,260,60,30);
       rBtn[0].setText("AN");
       rBtn[0].setSelected(true);
       rBtn[0].setEnabled(false);
      }
      if(i==1){
       rBtn[1].setBounds(200,260,60,30);
       rBtn[1].setText("AUS");
      }
//      if(i==2){
//       rBtn[2].setBounds(400,250,30,30);
//       rBtn[2].setSelected(true);
//      }
//      if(i==3){
//       rBtn[3].setBounds(450,250,30,30);
//      }
      grp.add(rBtn[0]);
      grp.add(rBtn[1]);
      grp2.add(rBtn[2]);
      grp2.add(rBtn[3]);
      rBtn[i].setOpaque(false);
      this.add(rBtn[i]);
    }
    
    lbl2 = new JLabel();
    lbl2.setBounds(120,185,300,50);
    lbl2.setFont(f2);
    lbl2.setText("Musik");
    lbl2.setForeground(new Color(208, 244, 248));
    this.add(lbl2);
    
    lblV = new JLabel("Lautstärke");
    lblV.setBounds(145,290,100,30);
    lblV.setFont(f);
    lblV.setForeground(new Color(208, 244, 248));
    this.add(lblV);
    
    lblB = new JLabel(new ImageIcon("src/butt1.png"));
    lblB.setHorizontalTextPosition(lblB.getX());        //TextPosition muss vor allen anderen attributen von lblB gesetzt werden!
    lblB.setBounds(110,400,275,100);
    lblB.setFont(f);
    lblB.setText("Zurück");
    lblB.setIcon(new ImageIcon("src/Zurück.png"));
    lblB.addMouseListener(myL);
    this.add(lblB);
  }
  
  public JLabel getLblS(int i){
    return this.lblS[i];
  }
  
  public JLabel getLblV(){
    return this.lblV;
  }
  
  public JSlider getSl(int i){
    return this.sl[i];
  }
  public JRadioButton getRBtn(int i){
    return this.rBtn[i];
  }
  public JLabel getLblB(){
    return this.lblB;
  }
  public JLabel getLbl2(){
    return this.lbl2;
  }
  public JLabel getLbl3(){
    return this.lbl3;
  }
  public TonListener getMyl(){
    return this.myL;
  }
  
  public float labelDezibelKoverter(){
    double d = (Double.parseDouble(this.getLblS(0).getText()))/10;
    float s = (float)d * (float)d;
    return s;
  }
  
  public boolean setAnAus(int x){
    //anAus = x;
    if(x == 0){
      System.out.println("ton ausgeschalten");
      return true;
    }
    if(x == 1){
      System.out.println("ton angeschalten");
      return false;
    }
    return false;
  }
  
  public int getAnAus(){
    return this.anAus;
  }
  
  public void spieleTon(){
   try{
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
         new File("src/CLICK1C-1.wav"));
         Clip clip = AudioSystem.getClip();
         clip.open(audioInputStream);
         FloatControl gainControl =
        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(this.labelDezibelKoverter()); // Volumen regeln
        clip.start();
       } catch(Exception e){

       }
  }
  
  public void spieleTon2(){
   try{
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
         new File("src/BEEP1C-1.wav"));
         Clip clip = AudioSystem.getClip();
         clip.open(audioInputStream);
         FloatControl gainControl =
        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(this.labelDezibelKoverter()); // Volumen regeln
        clip.start();
       } catch(Exception e){

       }
  }
  
  public void spieleTon3(){
   try{
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
         new File("src/click2.wav"));
         Clip clip = AudioSystem.getClip();
         clip.open(audioInputStream);
         FloatControl gainControl =
        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(this.labelDezibelKoverter()); // Volumen regeln
        clip.start();
       } catch(Exception e){

       }
  }
  
  public void spieleTon4(){
   try{
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
         new File("src/applause.wav"));
         Clip clip = AudioSystem.getClip();
         clip.open(audioInputStream);
         FloatControl gainControl =
        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(this.labelDezibelKoverter()); // Volumen regeln
        clip.start();
       } catch(Exception e){

       }
  }
  
  public void spieleMusik(){
   try{
        if(myL.getP() != 1){
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/game03.mid"));
         clip = AudioSystem.getClip();
         clip.open(audioInputStream);
         FloatControl gainControl =
         (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
         gainControl.setValue(this.labelDezibelKoverter()); // Volumen regeln
         clip.loop(clip.LOOP_CONTINUOUSLY);
         clip.start();
        }else{
          clip.stop();
        }

       } catch(Exception e){
        System.err.println(e);
       }
  }
  
  public void paintComponent(Graphics g)
  {
    try {                                                    //Try-Anweisung mit catch falls Bilddatei nicht gefunden wird.
     img = ImageIO.read(new File("src/MusikHinter.png"));
    } catch (IOException e) {
      }
        // Zeichnet die BufferedImage-Datei(img) auf das JPanel.
    g.drawImage(img,0,0,null);
  }
}
