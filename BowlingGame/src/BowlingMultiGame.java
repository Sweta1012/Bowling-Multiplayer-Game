
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class BowlingMultiGame{
     
    public static void main(String []args) throws IOException
    {
         int noPlayers;
    
        Scanner scan = new Scanner(System.in);
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
     System.out.println("Please enter the number of players:\n");
     
     
     noPlayers = scan.nextInt();
    Output[] player = new Output[noPlayers];
     
    for(int i=0; i<noPlayers; i++)
    {
        player[i] = new Output();
        System.out.println("Please enter the name for players :"+(i+1));
        player[i].name = br.readLine();
         
    }
     
     int score;
     
     for(int frame=0; frame<10; frame++)
     {
             
         for(int count=0; count<noPlayers; count++)
         {
         
             boolean scrOne = true;
	         System.out.println("Frame:"+(frame+1));
	         System.out.println(" Please enter First Turn :"+player[count].name);
	         score=scan.nextInt();
         
         do{
                if(score<=10 && score>=0)
                {
                    scrOne=false;
                    player[count].fInput(frame, score);
         
                }
                else{
                System.out.println("**ERROR** Please enter Valid Score between 1 to 10:\n");
                System.out.println("Please enter new Score:\n");
                score=scan.nextInt();
         
                }
         
         }while(scrOne);
        
        
         if(score<10)
         {
             int scrTwo=0;
             boolean isSecondScrInValid=true;
             
             do{
         
                System.out.println("Please enter second turn for:"+player[count].name);
               
                scrTwo=scan.nextInt();
                
                    do{
                    
                            if(  (score+scrTwo)<=10 && scrTwo>=0)
                            {
                                
                            player[count].inputTwo(frame,scrTwo);
                                    isSecondScrInValid=false;
                            }
                            else{
                                System.out.println("**ERROR** Please enter a valid score between 0 and "+(10-score)+"\n");
                System.out.println("Please enter new score:\n");
                scrTwo=scan.nextInt();
         
                            }
                        
                    }while(isSecondScrInValid);
                player[count].inputTwo(frame,scrTwo);
         
             
             }while(isSecondScrInValid);
         
         }
             
         }
     
     }
     
    System.out.println("\n\n*Score*");

     for(int i=0;i<noPlayers;i++)
     {
    	 System.out.println("\n");
         System.out.println(player[i].name+" *Score*");
         System.out.println();
         player[i].output();
     }
    }
    
    
}
