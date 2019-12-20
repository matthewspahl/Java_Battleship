//Matthew Spahl

import java.awt.*;
import java.applet.*;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.Scanner;

public class GameSetup extends BattleshipGame{
         
         public static void setBoard(String[][] myBoard, String[][] enemyBoard, String[][] oceanBoard)
   {
      
      
      for(int k = 0; k<myBoard.length;k++)
      {
      
         for(int j = 0; j<myBoard[0].length;j++)
         {
            myBoard[k][j] = "-";
         }
      
      }
      
      
      for(int k = 0; k<enemyBoard.length;k++)
      {
      
         for(int j = 0; j<enemyBoard[0].length;j++)
         {
            enemyBoard[k][j] = "-";
         }
      
      }
      
      for(int k = 0; k<oceanBoard.length;k++)
      {
      
         for(int j = 0; j<oceanBoard[0].length;j++)
         {
            oceanBoard[k][j] = "-";
         }
      
      }



   }
   
   public static void setMyBattleshipCoordinates(String [][] myBoard)
   {      
       int bowX = -1;
       int bowY = -1;
       int sternX = -1;
       int sternY = -1;
       int Facing = -1;
       
       Scanner input = new Scanner(System.in);
       
               
    while(bowX < 0 || bowX > 9)
    {
       System.out.print("Battleship reporting. Enter bow x coordinate (0 to 9) ===>>  ");		
    		while(!input.hasNextInt())
         {
            input.next();
            System.out.print("Please enter an integer: ");
         }
         bowX = input.nextInt();
    }
    
    while(bowY < 0 || bowY > 9)
    {
       System.out.print("Battleship reporting. Enter bow y coordinate (0 to 9) ===>>  ");		
    		while(!input.hasNextInt())
         {
            input.next();
            System.out.print("Please enter an integer: ");
         }
         
         bowY = input.nextInt();
    }
    	
    while(sternX < 0 || sternX > 9 || sternY <0 || sternY > 9)
    {
    System.out.println("Facing: Up(1),Down(2),Left(3),Right(4)?");
    while(!input.hasNextInt())
    {
      input.next();
      System.out.print("Please enter an integer: ");
    }
    Facing = input.nextInt();
    
          if(Facing == 1)
          {
             sternY = bowY-3;
             sternX = bowX;
          }
          
          else if(Facing == 2)
          {
             sternY = bowY+3;
             sternX = bowX;
          }
          
          else if(Facing == 3)
          {
             sternY = bowY;
             sternX = bowX-3;
          }
          
          else if(Facing == 4)
          {
             sternY = bowY;
             sternX = bowX + 3;
          }
          
          
          else 
          {
          System.out.println("This is not a valid number.");
          }
    }
    
    
    if (Facing == 1)
    {
       for (int a = bowY; a>= sternY; a--)
          {
             myBoard[a][bowX] = "B";
          }
    }
    
    if (Facing == 2)
    {
       for (int a = bowY; a<= sternY; a++)
          {
             myBoard[a][bowX] = "B";
          }
    }
    
    if (Facing == 3)
    {
       for (int a = bowX; a>= sternX; a--)
          {
             myBoard[bowY][a] = "B";
          }
    }
    
    if (Facing == 4)
    {
       for (int a = bowX; a<= sternX; a++)
          {
             myBoard[bowY][a] = "B";
          }
    }
  }
   
   public static void setMyShipCoordinates(String [][] myBoard, int length, String name, String marker)
   {      
       int bowX = -1;
       int bowY = -1;
       int sternX = -1;
       int sternY = -1;
       int Facing = -1;
       
       Scanner input = new Scanner(System.in);
       
               
    while(bowX < 0 || bowX > 9)
    {
       System.out.print(name + " reporting. Enter bow x coordinate (0 to 9) ===>>  ");		
    		while(!input.hasNextInt())
         {
            input.next();
            System.out.print("Please enter an integer: ");
         }
         bowX = input.nextInt();
    }
    
    while(bowY < 0 || bowY > 9)
    {
       System.out.print(name + " reporting. Enter bow y coordinate (0 to 9) ===>>  ");		
    		while(!input.hasNextInt())
         {
            input.next();
            System.out.print("Please enter an integer: ");
         }
         
         bowY = input.nextInt();
    }
    	
    while(sternX < 0 || sternX > 9 || sternY <0 || sternY > 9)
    {
    System.out.println("Facing: Up(1),Down(2),Left(3),Right(4)?");
    while(!input.hasNextInt())
    {
      input.next();
      System.out.print("Please enter an integer: ");
    }
    Facing = input.nextInt();
    
          if(Facing == 1)
          {
             sternY = bowY-length;
             sternX = bowX;
          }
          
          else if(Facing == 2)
          {
             sternY = bowY+length;
             sternX = bowX;
          }
          
          else if(Facing == 3)
          {
             sternY = bowY;
             sternX = bowX-length;
          }
          
          else if(Facing == 4)
          {
             sternY = bowY;
             sternX = bowX + length;
          }
          
          
          else 
          {
          System.out.println("This is not a valid number.");
          }
    }
    
    
    if (Facing == 1)
    {
       for (int a = bowY; a>= sternY; a--)
          {
             myBoard[a][bowX] = marker;
          }
    }
    
    if (Facing == 2)
    {
       for (int a = bowY; a<= sternY; a++)
          {
             myBoard[a][bowX] = marker;
          }
    }
    
    if (Facing == 3)
    {
       for (int a = bowX; a>= sternX; a--)
          {
             myBoard[bowY][a] = marker;
          }
    }
    
    if (Facing == 4)
    {
       for (int a = bowX; a<= sternX; a++)
          {
             myBoard[bowY][a] = marker;
          }
    }
  }
   
   
   
   
      public static void setEnemyBattleshipCoordinates(String [][] EnemyBoard)
   {      
       int bowX = -1;
       int bowY = -1;
       int sternX = -1;
       int sternY = -1;
       int Facing = -1;
       
       
       
               
    while(bowX < 0 || bowX > 9)
    {
       		
    		
         bowX = (int)(Math.random() * 10);
    }
    
    while(bowY < 0 || bowY > 9)
    {
       		
    	
      bowY = (int)(Math.random() * 10);
    }
    	
    while(sternX < 0 || sternX > 9 || sternY <0 || sternY > 9)
    {
    
    
    Facing = (int)(Math.random() * 5 + 1);
    
          if(Facing == 1)
          {
             sternY = bowY-3;
             sternX = bowX;
          }
          
          else if(Facing == 2)
          {
             sternY = bowY+3;
             sternX = bowX;
          }
          
          else if(Facing == 3)
          {
             sternY = bowY;
             sternX = bowX-3;
          }
          
          else if(Facing == 4)
          {
             sternY = bowY;
             sternX = bowX + 3;
          }
          
          
         
    }
    
    
    if (Facing == 1)
    {
       for (int a = bowY; a>= sternY; a--)
          {
             EnemyBoard[a][bowX] = "B";
          }
    }
    
    if (Facing == 2)
    {
       for (int a = bowY; a<= sternY; a++)
          {
             EnemyBoard[a][bowX] = "B";
          }
    }
    
    if (Facing == 3)
    {
       for (int a = bowX; a>= sternX; a--)
          {
             EnemyBoard[bowY][a] = "B";
          }
    }
    
    if (Facing == 4)
    {
       for (int a = bowX; a<= sternX; a++)
          {
             EnemyBoard[bowY][a] = "B";
          }
    }
  }

   public static void setEnemyShipCoordinates(String [][] EnemyBoard, int length, String name, String marker)
   {      
       int bowX = -1;
       int bowY = -1;
       int sternX = -1;
       int sternY = -1;
       int Facing = -1;
       
       
       
               
    while(bowX < 0 || bowX > 9)
    {
       		
    		
         bowX = (int)(Math.random() * 10);
    }
    
    while(bowY < 0 || bowY > 9)
    {
       		
    	
      bowY = (int)(Math.random() * 10);
    }
    	
    while(sternX < 0 || sternX > 9 || sternY <0 || sternY > 9)
    {
    
    
    Facing = (int)(Math.random() * 5 + 1);
    
          if(Facing == 1)
          {
             sternY = bowY-length;
             sternX = bowX;
          }
          
          else if(Facing == 2)
          {
             sternY = bowY+length;
             sternX = bowX;
          }
          
          else if(Facing == 3)
          {
             sternY = bowY;
             sternX = bowX-length;
          }
          
          else if(Facing == 4)
          {
             sternY = bowY;
             sternX = bowX + length;
          }
          
          
          
    }
    
    
    if (Facing == 1)
    {
       for (int a = bowY; a>= sternY; a--)
          {
             EnemyBoard[a][bowX] = marker;
          }
    }
    
    if (Facing == 2)
    {
       for (int a = bowY; a<= sternY; a++)
          {
             EnemyBoard[a][bowX] = marker;
          }
    }
    
    if (Facing == 3)
    {
       for (int a = bowX; a>= sternX; a--)
          {
             EnemyBoard[bowY][a] = marker;
          }
    }
    
    if (Facing == 4)
    {
       for (int a = bowX; a<= sternX; a++)
          {
             EnemyBoard[bowY][a] = marker;
          }
    }
  }



} 