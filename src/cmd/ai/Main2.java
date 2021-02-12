package cmd.ai;

import java.util.*;

public class Main2 {

    private Integer[][] gameBoard = new Integer[6][7];
    private final int MAX_DEPTH = 16;
    private int bestTurn = -1;
    private HashMap<Integer,Integer> cache = new HashMap<Integer,Integer>();
    private final int MAX_INT = Integer.MAX_VALUE;
    private final int MIN_INT = Integer.MIN_VALUE+1;
    Scanner sc = new Scanner(System.in);
    int i,j;

    public Main2() {
        //Array auf 0 setzen
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = 0;
            }
        }
        //Spieler startet

//        doMove(3, 1);
        while (true) {
            System.out.println("welche spalte willst du setzen?");
            int read = sc.nextInt();
            doMove(read, 1);
            if(check4setzen() == true){
              check4setzen();
            }else{
             doCPUTurn(-1);
            }
//            doCPUTurn(1);
            print();
            int winner = checkWinner();
            if (winner != 0) {
                System.out.println("Der Gewinner ist: "+winner);
                break;
            }
        }

    }

    public void print(){
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j]+"   ");
            }
            System.out.print("\n");
        }
    }

    public int checkWinner() {
        //check Reihen
     for(i = gameBoard.length-1;i >= 0;i--){
      for(j = gameBoard[i].length-1;j >= 0;j--){
       if (i >= 3){

         if(gameBoard[i][j] == gameBoard[i-1][j]
        && gameBoard[i][j] == gameBoard[i-2][j]
        && gameBoard[i][j] == gameBoard[i-3][j]
        && gameBoard[i][j] == 1){
          return 1;
        } else {
          if(gameBoard[i][j] == gameBoard[i-1][j]
          && gameBoard[i][j] == gameBoard[i-2][j]
          && gameBoard[i][j] == gameBoard[i-3][j]
          && gameBoard[i][j] == -1){
            return -1;
          }
        }
       }
      }
     }
        //check Spalten
        for(i = gameBoard.length-1;i >= 0;i--){
         for(j = gameBoard[i].length-1;j >= 0;j--){
          if (j >= 3){
           if(gameBoard[i][j] == gameBoard[i][j-1]
           && gameBoard[i][j] == gameBoard[i][j-2]
           && gameBoard[i][j] == gameBoard[i][j-3]
           && gameBoard[i][j] == 1){
            return 1;
           } else {
             if(gameBoard[i][j] == gameBoard[i][j-1]
            && gameBoard[i][j] == gameBoard[i][j-2]
            && gameBoard[i][j] == gameBoard[i][j-3]
            && gameBoard[i][j] == -1){
              return -1;
            }
           }
         }

        }
       }
        //check Diagonal
      for(i = gameBoard.length-1;i >= 0;i--){
       for(j = gameBoard[i].length-1;j >= 0;j--){
        if (i >= 3 && j>= 3){
          if(gameBoard[i][j] == gameBoard[i-1][j-1]
            && gameBoard[i][j] == gameBoard[i-2][j-2]
            && gameBoard[i][j] == gameBoard[i-3][j-3]
            && gameBoard[i][j] == 1){
             return 1;
           } else {
            if(gameBoard[i][j] == gameBoard[i-1][j-1]
            && gameBoard[i][j] == gameBoard[i-2][j-2]
            && gameBoard[i][j] == gameBoard[i-3][j-3]
            && gameBoard[i][j] == -1){
              return -1;
            }
           }
        }

       }
      }
      for(i = gameBoard.length-1;i >= 0;i--){
        for(j = gameBoard[i].length-1;j >= 0;j--){
        if (i >= 3 && j<= 3){
         if(gameBoard[i][j] == gameBoard[i-1][j+1]
          && gameBoard[i][j] == gameBoard[i-2][j+2]
          && gameBoard[i][j] == gameBoard[i-3][j+3]
          && gameBoard[i][j] == 1){
            return 1;
          } else {
           if(gameBoard[i][j] == gameBoard[i-1][j+1]
            && gameBoard[i][j] == gameBoard[i-2][j+2]
            && gameBoard[i][j] == gameBoard[i-3][j+3]
            && gameBoard[i][j] == -1){
             return -1;
            }
          }
        }

       }
      }
        return 0;
    }

    public static void main(String[] args) {
        Main2 m = new Main2();
    }

    //ki logik
    private void doCPUTurn(int player) {
        bestTurn = -1;
        int trash = Max(MAX_DEPTH, MIN_INT, MAX_INT, player, true);
        if (bestTurn != -1) {
            doMove(bestTurn, player);
        }
    }

    //cpu Spieler ist Spieler -1 und ruft diese Methode auf
    private int Max(int tiefe, int alpha, int beta, int player, boolean starter) {
        if (checkWinner() != 0 || tiefe == 0) {
            return evaluate(tiefe,player);
        }
        ArrayList<Integer> possibleMoves = generatePossibleMoves();
        int localAlpha = MIN_INT;
        while (!possibleMoves.isEmpty()) {
            Integer col = possibleMoves.remove(possibleMoves.size()-1);
            if (!doMove(col,player)) {
                continue;//sollte nicht passieren
            }
            int wert = Min(tiefe - 1, alpha, beta, player);
            undoMove(col);
            if (wert > localAlpha) {
                if (starter) {
                    bestTurn = col;
                }
                if (wert >= beta) {
                    return wert;
                }
                localAlpha = wert;
                if (wert > alpha) {
                    alpha = wert;
                }
            }
        }
        return localAlpha;
    }

    private int Min(int tiefe, int alpha, int beta, int player) {
        if (checkWinner() != 0 || tiefe == 0) {
            return evaluate(tiefe,player);
        }
        ArrayList<Integer> possibleMoves = generatePossibleMoves();
        int localBeta = MAX_INT;
        while (!possibleMoves.isEmpty()) {
            Integer col = possibleMoves.remove(possibleMoves.size()-1);
            if (!doMove(col,player)) {
                continue;//sollte nicht passieren
            }
            int wert = Max(tiefe - 1, alpha, beta, player, false);
            undoMove(col);
            if (wert < localBeta) {
                if (wert <= alpha) {
                    return wert;
                }
                localBeta = wert;
                if (wert < beta) {
                    beta = wert;
                    //bestTurn = col;
                }
            }
        }
        return localBeta;
    }

    private ArrayList<Integer> generatePossibleMoves() {
        //mögliche Züge
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        if (gameBoard[0][0] == 0) {
            possibleMoves.add(0);
        }
        for (int i=gameBoard[0].length/2-1; i>=0; i--) {
            if (gameBoard[0][gameBoard[0].length/2+i+1] == 0) {
                possibleMoves.add(gameBoard[0].length/2+i+1);
            }
            if (gameBoard[0][gameBoard[0].length/2-i] == 0) {
                possibleMoves.add(gameBoard[0].length/2-i);
            }
        }
        return possibleMoves;
    }

    private int evaluate(int tiefe, int player) {
        int rating=0;
        //besseres Rating wenn Tiefe geringer ist
        rating = tiefe +1;
        int winner = checkWinner();
        //cpu verliert -> rating wird negativ
        if (winner == -player) {
            rating *= -1;//richtig oder falsch?
        } else if (winner == 0) { //kein Gewinner, kein rating
            rating = 0;
        }
        return rating;
    }

    private boolean doMove(int col, int player) {
        for (int i=gameBoard.length-1; i>=0; i--) {
            if (gameBoard[i][col] == 0) {
                    gameBoard[i][col] = player;
                    return true;
            }
        }
        return false;
    }

    private boolean undoMove(int col) {
        for (int i=0; i<gameBoard.length; i++) {
            if (gameBoard[i][col] != 0) {
                gameBoard[i][col] = 0;
                return true;
            }
        }
        return false;
    }
    
    private boolean check4setzen(){
      for(i = gameBoard.length-1;i >= 0;i--){
       for(j = gameBoard[i].length-1;j >= 0;j--){
         //waagrecht-check
         if (i >= 2){
           if(gameBoard[i][j] == gameBoard[i-1][j]
          && gameBoard[i][j] == gameBoard[i-2][j]
          && gameBoard[i][j] != 0){
            if(i ==2){
             if(gameBoard[i+1][j] == 0){
               gameBoard[i+1][j] = -1;
               return true;
             }

            }else{
             if(gameBoard[i-3][j] == 0){
               gameBoard[i-3][j] = -1;
               return true;
             }
            }

          }
         }
         
         //senkrecht-check
         if (j >= 2){
          if(gameBoard[i][j] == gameBoard[i][j-1]
          && gameBoard[i][j] == gameBoard[i][j-2]
          && gameBoard[i][j] != 0)
             {
               if(j==2){
                if(gameBoard[i][j+1] == 0){
                  gameBoard[i][j+1] = -1;
                  return true;
                }
               }else{
                if(gameBoard[i][j-3] == 0){
                  gameBoard[i][j-3] = -1;
                  return true;
                }
               }

             }
         }
         
         //diagonal-check (von rechts unten nach links oben)
         if (i >= 2 && j>= 2){
          if(gameBoard[i][j] == gameBoard[i-1][j-1]
            && gameBoard[i][j] == gameBoard[i-2][j-2]
            && gameBoard[i][j] != 0){
            if(i == 2 && j == 2){
             if(gameBoard[i+1][j+1] == 0 &&
                gameBoard[i+1][j+2] != 0){
              gameBoard[i+1][j+1] = -1;
              return true;
             }
            }else{
             if(gameBoard[i-3][j-3] == 0 &&
                gameBoard[i-3][j-2] != 0){
               gameBoard[i-3][j-3] = -1;
               return true;
             }
            }
           }
         }
         
         //diagonal-check (von links unten nach rechts oben)
         if (i >= 2 && j<= 2){
          if(gameBoard[i][j] == gameBoard[i-1][j+1]
            && gameBoard[i][j] == gameBoard[i-2][j+2]
            && gameBoard[i][j] != 0){
              if(i == 2 && j == 2){
               if(gameBoard[i+1][j-1] == 0 &&
                  gameBoard[i+1][j] != 0){
                 gameBoard[i+1][j-1] = -1;
                 return true;
               }
              }else{
               if(gameBoard[i-3][j+3] == 0 &&
                  gameBoard[i-3][j+4] != 0){
                 gameBoard[i-3][j+3] = -1;
                 return true;
               }
              }

            }
         }

       }
      }
      return false;
    }
}
