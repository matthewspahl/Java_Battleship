//Java Battleship
//by Matthew Spahl 
//
//10 * 10 grid
// 1 battleship, of length 4, 1 Aircraft Carrier, length 5, destroyer length 3, sub length 3, patrol boat length 2
//If computer scores a hit, gets to fire again, and fires at adjacent spot if possible.
/*
import java.awt.*;
import java.applet.*;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import java.awt.Color;*/
import java.util.Scanner;
//import javafx.scene.Parent;

public class BattleshipGame{
   
   
   
   public static void main(String[] args)
   {
   
      String playerBoard[ ][ ];           		// declaration of two-dimensional String array
      playerBoard = new String[10][10];

   String comBoard[][];
      comBoard = new String [10][10];
      
      String hitBoard[][];
      hitBoard = new String [10][10];


      GameSetup.setBoard(playerBoard, comBoard, hitBoard);
      BattleshipUtilities.intro();
      BattleshipUtilities.displayBoard(playerBoard, comBoard);
      GameSetup.setMyShipCoordinates(playerBoard,3,"Battleship","B");
      BattleshipUtilities.displayBoard(playerBoard, comBoard);

      GameSetup.setMyShipCoordinates(playerBoard,4,"Aircraft Carrier", "C");
      BattleshipUtilities.displayBoard(playerBoard, comBoard);

      GameSetup.setMyShipCoordinates(playerBoard,2,"Destroyer","D");
      BattleshipUtilities.displayBoard(playerBoard, comBoard);

      GameSetup.setMyShipCoordinates(playerBoard,2,"Submarine","S");
      BattleshipUtilities.displayBoard(playerBoard, comBoard);

      GameSetup.setMyShipCoordinates(playerBoard,1,"Patrol Boat","P");
      BattleshipUtilities.displayBoard(playerBoard, comBoard);

     
      GameSetup.setEnemyShipCoordinates(comBoard,3,"Battleship","B");
      GameSetup.setEnemyShipCoordinates(comBoard,4,"Aircraft Carrier", "C");
      GameSetup.setEnemyShipCoordinates(comBoard,2,"Destroyer","D");
      GameSetup.setEnemyShipCoordinates(comBoard,2,"Submarine","S");
      GameSetup.setEnemyShipCoordinates(comBoard,1,"Patrol Boat","P");
      BattleshipUtilities.displayBoard(playerBoard, hitBoard);
      playGame(playerBoard, comBoard, hitBoard);
      BattleshipUtilities.endGame(playerBoard,comBoard);
   }
   
      
     
  
  
  public static void playGame(String[][] myBoard, String[][] enemyBoard, String[][] fogBoard)
  {
      boolean gameRunning = true;
      boolean playerHit = false;
      
      while(gameRunning)
      {
         BattleshipUtilities.statusReport(myBoard, enemyBoard);
         playerFire(myBoard, enemyBoard, fogBoard);
         gameRunning = BattleshipUtilities.checkRunning(myBoard, enemyBoard);
         BattleshipUtilities.displayBoard(myBoard, fogBoard);
         
         
         
            computerSearch(myBoard, enemyBoard, fogBoard);
         gameRunning = BattleshipUtilities.checkRunning(myBoard, enemyBoard);
         BattleshipUtilities.displayBoard(myBoard, fogBoard);


      
      }
      //BattleshipUtilities.endGame(myBoard, enemyBoard);
  }
  
    
    
  
   public static void playerFire(String[][] board1, String[][]board2, String[][]board3)
   {
       int fireX = -1;
       int fireY = -1;
       
       
       Scanner input = new Scanner(System.in);

       while(fireX < 0 || fireX > 9 || fireY < 0 || fireY > 9)
       {
       System.out.println("Select target X coordinate: ");
       while(!input.hasNextInt())
       {
         input.next();
         System.out.print("Please enter an integer: ");
       }
       fireX = input.nextInt();

       System.out.println("Select target Y coordinate: ");
       while(!input.hasNextInt())
       {
         input.next();
         System.out.print("Please enter an integer: ");
       }
       fireY = input.nextInt();
       
       
       }
       
       if (board2[fireY][fireX].equals("B") || board2[fireY][fireX].equals("C") || board2[fireY][fireX].equals("D") || board2[fireY][fireX].equals("S") || board2[fireY][fireX].equals("P"))
       {
          board2[fireY][fireX] = "X";
          board3[fireY][fireX] = "X";
          System.out.println("Radar confirms hit at (" + fireX + ", " + fireY + ")");      
       
       } 
       
       else if(board2[fireY][fireX].equals("X") || board2[fireY][fireX].equals("O"))
       {
          System.out.println("Already fired here.");
       }
       
       else if(board2[fireY][fireX].equals("-"))
       {
          System.out.println("Radar confirms miss at (" + fireX + ", " + fireY + ")");
          board3[fireY][fireX] = "O";
          board2[fireY][fireX] = "O";
       }
       
    }
    
    public static void computerSearch(String[][] board1, String[][]board2, String[][]board3)
   {
       int fireX = -1;
       int fireY = -1;
       
       int hitX = -1;
       int hitY = -1;
       
       while(fireX < 0 || fireX > 9 || fireY < 0 || fireY > 9 || board1[fireY][fireX].equals("O") || board1[fireY][fireX].equals("X"))
       {
       
       fireY = (int)(Math.random() * 10);
              
       
       fireX = (int)(Math.random() * 10);

       }
       
       if (board1[fireY][fireX].equals("B") || board1[fireY][fireX].equals("C") || board1[fireY][fireX].equals("D") || board1[fireY][fireX].equals("S") || board1[fireY][fireX].equals("P"))
       {
          board1[fireY][fireX] = "X";
          System.out.println("Radar confirms hit at (" + fireX + ", " + fireY + ")"); 
          computerDestroy(board1, board2, board3, fireX,fireY );   
       
       } 
                 
       else if(board1[fireY][fireX].equals("-"))
       {
          System.out.println("Radar confirms miss at (" + fireX + ", " + fireY + ")");
          board1[fireY][fireX] = "O";
       }
       
      
       
    }
    
    public static void computerDestroy(String[][] board1, String[][]board2, String[][]board3, int x, int y)
    {
      
      int fireX = x;
      int fireY = y;
       
        int facingCheck;
         int counter = 0;
       
       while(board1[fireY][fireX].equals("O") || board1[fireY][fireX].equals("X"))
      {
         
      
      
      facingCheck= (int)(Math.random() * 4 + 1);
      
      counter++;
      
      if (counter == 20)
      {
      while(fireX < 0 || fireX > 9 || fireY < 0 || fireY > 9 || board1[fireY][fireX].equals("O") || board1[fireY][fireX].equals("X"))
       {
       
       fireY = (int)(Math.random() * 10);
              
       
       fireX = (int)(Math.random() * 10);

       }
       break;
      }
      
      else if (facingCheck == 1 && fireY < 9) {
         fireY++;
         //System.out.println("1");
         }
         
      else if (facingCheck == 2 && fireY > 0) {
         fireY--;
         //System.out.println("2");
         }
         
      else if (facingCheck == 3 && fireX < 9)
         fireX++;
         
      else if (facingCheck == 4 && fireX > 0)
         fireX--;        
      }
                       
       if (board1[fireY][fireX].equals("B") || board1[fireY][fireX].equals("C") || board1[fireY][fireX].equals("D") || board1[fireY][fireX].equals("S") || board1[fireY][fireX].equals("P"))
       {
          board1[fireY][fireX] = "X";
          
          System.out.println("Radar confirms hit at (" + fireX + ", " + fireY + ")");    
          computerDestroy(board1, board2, board3, fireX,fireY);  
       } 
       
       else if(board1[fireY][fireX].equals("X"))
       {
          System.out.println("Already fired here.");
       }
       
       else if(board1[fireY][fireX].equals("-"))
       {
          System.out.println("Radar confirms miss at (" + fireX + ", " + fireY + ")");
          board1[fireY][fireX] = "O";
       }
       
       else if(board1[fireY][fireX].equals("O"))
       {
         System.out.println("Already fired here");
       }

    }
    
}