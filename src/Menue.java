/* Diese Klasse Bildet das JFrame in dem alle JPanels untergebracht sind.
   In dieser Klasse werden die Eigenschaften des JFrames festgelegt.
   Die verschiedenen JPanels der Menues und Untermenues werden hier mit dem
   JFrame verknüpft(bzw. ge-addet).
   Durch die Methode getInstance() kann von diesem JFrame nur eine einzige
   Instanz (ein einziges Objekt) erzeugt werden.
   Durch die Methode getInstance() kann in anderen Klassen auf dieses konkrete
   Objekt zugegriffen werden.                                                      */
   
import java.awt.*;
import javax.swing.*;

public class Menue extends JFrame {

 private static Menue m = null;
 public MenuePanel mp = new MenuePanel();
 private Optionen o = new Optionen();
 private Spiel s = new Spiel();
 private Schwierigkeit sw = new Schwierigkeit();
 private Sprache sp = new Sprache();
 private Ton t = new Ton();
 
  //Konstruktor der Klasse Menue
  private Menue(){
    super("4Gewinnt-Game");                                   //Mit dem Konstruktor von JFrame
    this.setLayout(new BorderLayout());                       //kein Layoutmanager
    this.setBounds(100,100,521,583);                          //Größe und Positon
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //Operation beim Fenster schließen
    //this.setCursor(Cursor.DEFAULT_CURSOR);                  //Cursorhand über dem Frame
    this.setResizable(false);                                 //Fenster veränderbar oder nicht?
    
    this.add(mp);                                             //fügt MenuePanel mp zu Menue hinzu
    mp.setVisible(true);
    
    this.add(o);                                              //fügt Optionen2 o zu Menue hinzu
    o.setVisible(false);
    
    this.add(s);                                              //fügt Spiel s zu Menue hinzu
    s.setVisible(false);
    
    this.add(sw);                                             //fügt Schwierigkeit sw zu Menue hinzu
    sw.setVisible(false);
    
    this.add(sp);                                             //fügt Sprache sp zu Menue hinzu
    sp.setVisible(false);
    
    this.add(t);
    if(t.getMyl().getP() != 1){
      t.spieleMusik();
    }
    t.setVisible(false);
  }
  
  public MenuePanel getMp(){
    MenuePanel mp = new MenuePanel();
    return this.mp;
  }
  
  public Optionen getO(){
    Optionen o = new Optionen();
    return this.o;
  }
  
  public Spiel getS(){
    Spiel s = new Spiel();
    return this.s;
  }
  public void setS(Spiel spi){
    s = spi;
  }
  
  public Schwierigkeit getSw(){
    Schwierigkeit sw = new Schwierigkeit();
    return this.sw;
  }
  
  public Sprache getSp(){
    Sprache sp = new Sprache();
    return this.sp;
  }
  
  public Ton getT(){
    Ton t = new Ton();
    return this.t;
  }
  
  public static Menue getInstance(){
    if(m == null){
      m = new Menue();
    }
    return m;
  }
  
  public int getSpielArt(){
    return mp.getMultiSingle();
  }
}
