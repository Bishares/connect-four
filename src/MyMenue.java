/*Startklasse des Programms.
  Mit der main-Methode wird das JFrame-Objekt (durch die Methode getInstance()
  der Klasse Menue) erzeugt und sichtbar gesetzt.                             */

public class MyMenue{

  public static void main(String[] args){
   Menue m;
   m = Menue.getInstance();
   m.setVisible(true);

  }
}
