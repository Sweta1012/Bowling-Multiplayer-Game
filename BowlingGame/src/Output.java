
import java.util.Scanner;


public class Output {
 Scanner scanner = new Scanner(System.in);
   String name;
           boolean dstrike;
     
         int scrGame,frame;
	 boolean Isspare,IsStrike;
	  public int arrayscr[][]= new int[10][2];
         int[] frame_scr=new int[10];
	 int position=0;
	 int currentturn=0;
      
        
        int lastFrame;
	
	 int screenCrnt;
         
         public Output(){
             for(int i=0;i<10;i++)
			frame_scr[i]=-1;
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<2;j++)
				arrayscr[i][j]=-1;
		}
         
         }
       
    
       	public  void output()
	{
		System.out.println("\t-----Score-------");
		for(int count=0;count<=9;count++)
		{
			System.out.print("\t"+(count+1)+":"+frame_scr[count]);
		
		}
	}
        
        
        
        public  void fFrame(int frame, int scr)
	{

		
		
                  
                    arrayscr[frame][0]=scr;
	    	
	    	
                
            
	    	
	    	}
	    

        public void fInput(int frame, int score)
        {
        arrayscr[frame][0]=score;
        
        
        if(Isspare==true)
	    	{
	    	
	    		
	    		if(frame>0&& frame<=9)
	    		{
	    		checkspare(frame-1);
	    		}
	    		
	    		Isspare=false;
	    	}
        
        
        
        	if(score==10)
	    	{
	    		IsStrike=true;
	    		
                     
                        if(frame>0)
                        {
                           if(arrayscr[frame-1][0]==10)
                             {
                            dstrike=true;
                             }
	    		
                        }
                     
	    		//arrayscr[count][0]=CurrentScr;
	    		//checkstrike(count);
	    		
	    		if(frame==9)
	    		{
	    			if(arrayscr[9][0]>=0)
		    		{
		    		System.out.println("Enter the second throw\n");
	    		
	    			arrayscr[9][1]=scanner.nextInt();
	    			if(arrayscr[9][1]==10)
	    				checkstrike(frame);
                                
                                System.out.println("Enter the Third Throw\n");
                                lastFrame=scanner.nextInt();
                               LastFrameScore();
                             
		    		}
                                
	    		}
	    	}
        
        
        }
        
                
         public void inputTwo(int frame,int score)
         {
         
         
        
	    			arrayscr[frame][1]=score;
	    				
	    			if(isSpare(frame))
	    			{
	    			 Isspare=true;
                                }
                                 if(frame>2 && dstrike==true)
                                 {
                                    DStrikeScore(frame);
                                 }
	    			if(frame>0 && IsStrike==true)
                                {
	    		            Strike_Score(frame);
	    					
                                }
	    			if(frame>0 && IsStrike==false)
	    			{
	    			    MFrameScoreWithouttSpare(frame);
	    			}
                                  if(frame==0 && Isspare==false)
                                  {
                                    addFirstFrameScrWithoutSpare();
                                  }
                                  
                                  
                                 if(frame==9)
                                 {
                                     if(isLasSpare())
                                     {
                                       System.out.println("Enter the Third Throw\n");
                                       lastFrame=scanner.nextInt();
                                       LastFrameScore();
                                     }
                                     
                                 }
                                 
	    			}
        
        
        
        	public  boolean isLasSpare()
        {
            if(arrayscr[9][0]+arrayscr[9][1]==10 && arrayscr[9][1]>=0)
                return true;
            
            return false;
        }
        public  void LastFrameScore()
        {
            if(arrayscr[9][0]+arrayscr[9][1]>=10)
            {
                frame_scr[9]=frame_scr[8]+arrayscr[9][0]+arrayscr[9][1]+lastFrame;
            
            }
            else
            {
                frame_scr[9]=frame_scr[8]+arrayscr[9][0]+arrayscr[9][1];
            }
        }
        public  void MFrameScoreWithouttSpare(int frame)
        {
            frame_scr[frame]= frame_scr[frame-1]+arrayscr[frame][0]+arrayscr[frame][1];
        }
	public  void addFirstFrameScrWithoutSpare()    
       {
        frame_scr[0]=arrayscr[0][0]+arrayscr[0][1];
       }

	public  void Strike_Score(int frame)
        {
            frame_scr[frame-1]=frame_scr[frame-2]+10+arrayscr[frame][0]+arrayscr[frame][1];
	    IsStrike=false;
        }

        public  void DStrikeScore(int frame)
        {
         if(arrayscr[frame][0]==10)
              {  
                  frame_scr[frame-2]=frame_scr[frame-3]+30;
                   dstrike=false;
               }
             else 
                {
                   frame_scr[frame-2]=frame_scr[frame-3]+20+arrayscr[frame][0];
                   dstrike=false;
                }
        }
	public  boolean  isSpare(int frame)
        {
            if((arrayscr[frame][0]+arrayscr[frame][1])==10)
            {return true;}
           return false;
        }
	
	public  void checkspare(int frame)
	{
		if(frame_scr[0]==(-1))
		{
			frame_scr[0]=10+arrayscr[1][0];
		}
		
		if(frame>0 && frame<9)
		{
			frame_scr[frame]=frame_scr[frame-1]+arrayscr[frame+1][0]+10;
			
		}
		
	}
	 
		
	public  void checkstrike(int frame)

	{
		
         
	
		
		//Update the frame 0 
		if(frame_scr[0]==(-1))
		{
			
			if(arrayscr[1][0]==10 && arrayscr[2][0]==10)
			{
				frame_scr[0]=30;
			}
			else if(arrayscr[1][0]==10 && arrayscr[2][0]>=0)
			{
				frame_scr[0]=20+arrayscr[2][0];
			}
			else if(arrayscr[1][0]>=0 && arrayscr[1][1]>=0)
			{
				frame_scr[0]=10+arrayscr[1][0]+arrayscr[1][1];
					
			}
		}
		
		for(int i=1;i<8;i++)
		{
			if(frame_scr[i]==(-1))
			{
				if(arrayscr[i+1][0]==10 && arrayscr[i+2][0]==10)
				{
					frame_scr[i]=frame_scr[i-1]+30;
					
				}
				else if(arrayscr[i+1][0]==10 && arrayscr[i+2][0]>=0)
				{
					frame_scr[0]=20+arrayscr[i+2][0];
				}
				else if(arrayscr[i+1][0]>=0 && arrayscr[i+1][1]>=0)
				{
					frame_scr[0]=10+arrayscr[i+1][0]+arrayscr[i+1][1];
						
				}	
			}
			
		}
		
		if(frame==9)
		{
			if(arrayscr[8][0]==10)
			{
				if(arrayscr[9][0]==10 && arrayscr[9][1]>=0)
				{
					frame_scr[8]=frame_scr[7]+10+arrayscr[9][0]+arrayscr[9][1];
				}
				}
			
		}
	}
}
