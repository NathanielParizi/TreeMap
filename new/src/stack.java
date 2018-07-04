import java.util.Stack;

public class stack{
	
	public static void main(String[] args) 
	{
		
		Stack<String> mystack = new Stack<>();
		
		
		mystack.push("Nathaniel");
		mystack.push("JET");
		mystack.push("data");
		
		for(String i : mystack)
		{
			System.out.println(i);
		}
		

		mystack.pop();
		System.out.println("Whats on top of the stack?: " + mystack.peek()+  "\n ...cool!");
		
	}
	
}