
 class ArrayStack {

		int top = -1;
		int stack[] = new int[100];

		public boolean empty() 
		{
			return top==-1;
		}

		public void push(int x) 
		{
			top++;
			stack[top] = x;
		}

		public int pop() 
		{if(top==-1)
		 {
			return-1;
		 }
		int theElement = stack[top];
		stack[top]=0;
	    top--;
	    return theElement;
		
	}

}
