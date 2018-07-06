import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

public class stack{
	
	public static void main(String[] args) 
	{
		
		Stack<String> mystack = new Stack<>();
		Scanner scan = new Scanner(System.in);
		String input;
		
		
		mystack.push("Nathaniel");
		mystack.push("JET");
		mystack.push("data");
		int q = 0;
		
		for(String i : mystack)
		{
			System.out.println(i);
		}
		

		mystack.pop();
		System.out.println("Whats on top of the stack?: " + mystack.peek()+  "\n ...cool!");
		
		for(int i = 0, ii = 5; i < ii; i++) 
		{
			System.out.println(i + " and " + ii);
		}
		
		
		for(;  q <= 10; q++)
		{	
		
			System.out.println( " q " + q);
		}
		
		for(;;)
		{
		System.out.println( "Computer: Knock knock?" );
		input = scan.nextLine();
		
		if(input.equalsIgnoreCase("whos there") || input.equalsIgnoreCase("who's there") || input.equalsIgnoreCase("who is there") ||
				input.equalsIgnoreCase("whos there?") || input.equalsIgnoreCase("who's there?") || input.equalsIgnoreCase("who is there?")) 
		{
			System.out.println( "Computer: Smartest" );
			for(;;)
			{
			input = scan.nextLine();
			
			if(input.equalsIgnoreCase("smartest who")) 
			{
				System.out.println( "Computer: smartest AI in the world! " );
				
				  try {
				        while (true) {
				        	System.out.println( "Computer: hahahahhahahah " );
				            Thread.sleep(5 * 500);
				        }
				    } catch (InterruptedException e) {
				        e.printStackTrace();
				    }
				
				  
				  break;
				
			}else {System.out.println( "... it's Smartest" );}
			
			}
			
		}
		
		}
		
	}
	
}