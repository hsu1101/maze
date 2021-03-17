//資二B 07156210 許家瑋
import java.util.*;
public class mazetest {
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		java.io.File file = new java.io.File("D:/Rat5.txt");
		Scanner input = new Scanner(file,"MS950");
		int sucess =0;
	    int maze[][] = new int[12][12];
		while(input.hasNext())
		{for(int i=0;i<12;i++)
		 {for(int k=0;k<12;k++)
		  {maze[i][k] = input.nextInt();
      	  }
		 }
		}
		input.close();
		//讀檔
		for(int i=0;i<12;i++)
		 {for(int k=0;k<12;k++)
		  {System.out.print(maze[i][k]+" ");
     	  }
		 System.out.println();
		 }
		System.out.println();
		System.out.println();
		findPath(maze,1,1,sucess);	
	
	}
	
	public static  int findPath(int maze[][],int i,int j,int sucess)
	{	
    	maze[i][j] = 2;//把走過的路以2表示
   
    	if(i == 10 && j == 10)
    		{output(maze);
    		sucess =1;
    		}//走到終點就輸出
    	
    	 if(sucess!=1&&maze[i][j+1] == 0)
    		   {findPath(maze,i,j+1,sucess=0);
    	       }//如果右方為0就往右走
    	
    	 if(sucess!=1&&maze[i+1][j] == 0)
    		   {findPath(maze,i+1,j,sucess=0);
    		   }//如果下方為0就往下走
    	
    	 if(sucess!=1&&maze[i][j-1] == 0)
	           {findPath(maze,i,j-1,sucess=0);
	           }//如果是左方為0就往左走
	       
    	 if(sucess!=1&&maze[i-1][j] == 0)
    		   {findPath(maze,i-1,j,sucess=0);
    		   }//如果上方為0就往上走
    	 if(sucess!=1)
    	     maze[i][j]=0;
    return sucess;
	}
    
    public static void output(int maze[][])
     {System.out.println("True");
    	for(int k = 0; k<12;k++)  
              {for(int l = 0; l<12;l++)  
            	 {if(maze[k][l] == 1) //如果是 1 就輸出 1 當牆
                    System.out.print("1 "); 
            	  else if(maze[k][l] == 2) //如果是表示走過的2就輸出-當移動路徑
            	    System.out.print("- "); 
                  else //輸出0當不是牆也沒走到的路
                    System.out.print("0 "); 
               	 } 
               System.out.println(); 
               }
		/*if (findPath(maze,1,1,0)==0)
		{
			System.out.print("False");
		}
		*/
		 
    	} 
}
	

