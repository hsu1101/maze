package mouse;

import java.util.*;
import mouse.stack.Position;
import java.io.*;

public class maze {
	static int maze[][]=new int [12][12];
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		File file =new File("D:/Rat5.txt");
		Scanner input=new Scanner(file,"MS950");
		 for(int i=0;i<12;i++){
			 for(int j=0;j<12;j++){
				 maze[i][j]=input.nextInt();
			 }
		 }//讀檔
		 int road[][]=new int[12][12];
		 for(int i=0;i<12;i++){
			 for(int j=0;j<12;j++){
				 road[i][j]=maze[i][j];
			 }
		 }
		 System.out.println(findpath(road));
	}
		
	public static boolean findpath(int road[][]) {
		ArrayStack path=new ArrayStack();
		Position [] offset=new Position[4];
		offset[0]=new Position(0,1);//東
		offset[1]=new Position(1,0);//南
		offset[2]=new Position(0,-1);//西
		offset[3]=new Position(-1,0);//北
		Position here=new Position(1,1);//表示老鼠現在的位子
		
		maze[1][1]=1;//老鼠從入口進入，所以將迷宮入口的值改為1，以防走出入口
		int option=0;//由東南西北開始做選擇，初始化為0
		int lastoption=3;//代表最後的選擇，其他可能的方向都試過了
		while(here.row!=10||here.column!=10) {
			int r=1,c=1;//代表老鼠可能會走到的下一個位置，這裡為預設的初始位置
			while(option<=lastoption) {
				r=here.row+offset[option].row;//row的變化
				c=here.column+offset[option].column;//column的變化
				if(maze[r][c]==0) {
					break;
				}//如果即將走的那個位子的数值是0表示可以走不需要進行别的方向的嘗試
				option++;//如果即將走的位子不是0，那就嘗試下一個方向
			}
			if(option<=lastoption) {//表示老鼠暫時找到了自己可以走的路
				path.getposition(here);
				path.push(here);//將老鼠走的路径存入stack當中以防後面走不了要回頭，需要從stack中找路径
				here=new Position(r,c);//將新走的那一个位址存進stack中
				
				
				maze[r][c]=1;//走過的地方要將0變成1，防止走重復的路
				option=0;//位址變動並儲存過後就要把選擇的值歸0，然後準備走下一步
			}
			else {//假如老鼠的四周都是1無法找到路，就要回到上一步
				if(path.empty()) {//去找之前走過位置並放入到stack中，如果stack中是空的
					
					return false;//則走不出這個迷宮
				}
				path.getposition(here);
				option=0;//如果stack中還有上一個位址，则把option歸0
				here=path.pop();//回到上一个位置，考慮别的方向，而之前走過的死路已经變成1了，所以不會再走
				
			}
		}
		path.getposition(here);
		for(int i=0;i<12;i++){
			 for(int j=0;j<12;j++){
				 
				 if(road[i][j]!=maze[i][j]){
					 System.out.print("# ");}
				else  if(road[i][j]!=maze[i][j]&&j==11) {
					 System.out.println("# ");
				 }
				 else if(road[i][j]==maze[i][j]&&j==11) {
					 System.out.println(road[i][j]+" ");
				 }else if(road[i][j]==maze[i][j]) {
					 System.out.print(road[i][j]+" ");
				 }
				}
		 
			 }
		return true;
	}
	static class ArrayStack {
		int top=-1;//stack中的top值
		Position stack[] = new Position[100];//一個可以存position物件的stack
		public boolean empty() {
			return top==-1;//stack中是空的
		}
		public void push(Position x) {
			top++;
			stack[top]=x;
		}//把資料放入stack中
		public Position pop() {
			if(top<0) { 
				return null;
			}//stack為空的，無法呼叫
			Position element=stack[top];
			top--;
			return element;
			}//在stack裡面有東西的时候取出最上面的那個值，也就是老鼠走的上一步
		public  void getposition(Position x) {
			
			 System.out.println("("+x.row+","+x.column+")");
		}
		
	}
	
}

