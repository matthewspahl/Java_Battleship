//Matthew Spahl


import java.awt.*;
import java.applet.*;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.Scanner;

public class BattleshipUtilities extends BattleshipGame{

public static void intro()
   {
      System.out.println("Battleship for Java, created by Matthew Spahl");
      System.out.println();
   }  
   
   
   
   public static void displayBoard(String[][] myBoard, String[][] enemyBoard)
   {
      System.out.println("My Board");
      System.out.print("  ");
         for(int a = 0; a<myBoard[0].length; a++)
         {
            System.out.print(" " + a + " ");
         }
         System.out.println();
         for(int k = 0; k<myBoard.length;k++)
      {
         System.out.print(k + " ");
         for(int j = 0; j<myBoard[0].length;j++)
         {
            System.out.print("[" + myBoard[k][j] + "]");
         }
      
         System.out.println();
      }
      System.out.println();
      
      System.out.println("Enemy Board");
      System.out.print("  ");
         for(int a = 0; a<myBoard[0].length; a++)
         {
            System.out.print(" " + a + " ");
         }
         System.out.println();
      
         for(int k = 0; k<enemyBoard.length;k++)
      {
         System.out.print(k + " ");
      
         for(int j = 0; j<enemyBoard[0].length;j++)
         {
            System.out.print("[" + enemyBoard[k][j] + "]");
         }
      
         System.out.println();
         //System.out.println();
      }
      System.out.println();
      System.out.println("////////////////////////////////////////////////////////////////");
   }


    public static void endGame(String[][] board1, String[][]board2)
  {
      
       
      boolean playerAfloat = false;
      boolean computerAfloat = false;
      
      for(int a = 0; a<board1.length; a++)
      {
         for(int b = 0; b<board1[a].length; b++)
         {
            if (board1[a][b] == "B" || board1[a][b] == "C" || board1[a][b] == "D" || board1[a][b] == "S" || board1[a][b] == "P")
            playerAfloat = true;
         }
      }   
      
      
      for(int a = 0; a<board2.length; a++)
      {
         for(int b = 0; b<board2[a].length; b++)
         {
            if (board2[a][b] == "B" || board2[a][b] == "C" || board2[a][b] == "D" || board2[a][b] == "S" || board2[a][b] == "P")
            computerAfloat = true;
         }
      }
      
      if (playerAfloat == true)
      System.out.println("Enemy fleet destroyed. Congratulations, Admiral.");
      
      else
      System.out.println("Our fleet has been sunk.");
         
  }
  
  
  public static boolean checkRunning(String[][] board1, String[][]board2)
  {
      boolean playerAfloat = false;
      boolean computerAfloat = false;
      
      for(int a = 0; a<board1.length; a++)
      {
         for(int b = 0; b<board1[a].length; b++)
         {
            if (board1[a][b] == "B" || board1[a][b] == "C" || board1[a][b] == "D" || board1[a][b] == "S" || board1[a][b] == "P")
            playerAfloat = true;
         }
      }   
      
      
      for(int a = 0; a<board2.length; a++)
      {
         for(int b = 0; b<board2[a].length; b++)
         {
            if (board2[a][b] == "B" || board2[a][b] == "C" || board2[a][b] == "D" || board2[a][b] == "S" || board2[a][b] == "P")
            computerAfloat = true;
         }
      }
      
      return (playerAfloat && computerAfloat);   
  }
  
  public static boolean checkPlayerHit(String[][] board1)
  {
      boolean playerDamaged = false;
      
      
      for(int a = 0; a<board1.length; a++)
      {
         for(int b = 0; b<board1[a].length; b++)
         {
            if (board1[a][b] == "X" || board1[a][b] == "x")
            playerDamaged = true;
         }
      }  
      return  playerDamaged;
  }
  
   public static void statusReport(String[][] board1, String[][] board2)
   {
      boolean myBB = false;
      boolean myAC = false;
      boolean myDD = false;
      boolean mySub = false;
      boolean myPt = false;
      
      boolean compBB = false;
      boolean compAC = false;
      boolean compDD = false;
      boolean compSub= false;
      boolean compPt = false;
       

      
      for(int a = 0; a<board2.length; a++)
      {
         for(int b = 0; b<board2[a].length; b++)
            {
               if (board2[a][b] == "B")
               compBB = true;
              
              if (board2[a][b] == "C")
              compAC = true;
              
              if(board2[a][b] == "D")
              compDD = true;
              
              if(board2[a][b] == "S")
              compSub = true;
              
              if(board2[a][b] == "P")
              compPt = true;
               
            }
      }
      
      System.out.println("Remaining targets:");
      if (compBB == true)
         System.out.println("Battleship");
         
      if(compAC == true)
         System.out.println("Aircraft Carrier");
         
      if(compDD == true)
         System.out.println("Destroyer");
         
      if(compSub == true)
         System.out.println("Submarine");
         
      if(compPt == true)
         System.out.println("Patrol Boat");
         
         System.out.println();            
      
      
   }


}