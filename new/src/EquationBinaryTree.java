

public class EquationBinaryTree {
	private Node root;

	public EquationBinaryTree()
	{
		root = null;
	}

	//left -> parent -> right
	public void printInfix()
	{
		if(root != null)
		{
			printInfixHelper(root);
			System.out.println();
		}
	}
	//left -> parent -> right
	private void printInfixHelper(Node n)
	{
		if(n.left != null)//know the right also exists
		{
			System.out.print("(");
			printInfixHelper(n.left);
			System.out.print(n.data);
			printInfixHelper(n.right);
			System.out.print(")");
		}
		else
		{
			System.out.print(n.data);
		}
	}
	
	

	//left -> right -> parent
	public void printPostfix()
	{
		if(root != null)
		{
			printPostfixHelper(root);
			System.out.println();
		}
	}
	private void printPostfixHelper(Node n)
	{
		if(n.left != null)//know the right also exists
		{
			printPostfixHelper(n.left);
			printPostfixHelper(n.right);
			System.out.print(n.data);
		}
		else
		{
			System.out.print(n.data);
		}
	}

	//parent -> left -> right
	public void printPrefix()
	{
		if(root != null)
		{
			printPrefixHelper(root);
			System.out.println();
		}
	}
	private void printPrefixHelper(Node n)
	{
		if(n.left != null)//know the right also exists
		{
			System.out.print(n.data);
			printPrefixHelper(n.left);
			printPrefixHelper(n.right);
		}
		else
		{
			System.out.print(n.data);
		}
	}
	
	
	//**************************************************
	// Postfix
	//*************************************************
	
	public void populateFromPostfix(String posfix)
	{
		root = populateFromPostfixHelper(posfix);
	}
	private Node populateFromPostfixHelper(String posfix)  //outer most parenthesis
	{
		String[] parts = postfixSplitter(posfix);
		for(String s : parts)
			System.out.println("Parts: " + s);
		Node temp = new Node(parts[0].substring(0));
		if(parts[2].length() == 1)
			temp.left = new Node(parts[2].substring(0));
		else
			temp.left = populateFromPostfixHelper(parts[2]);

		if(parts[1].length() == 1)
			temp.right = new Node(parts[1].substring(0));
		else
			temp.right = populateFromPostfixHelper(parts[1]);
		return temp;
	
		
		
		//abc*+de*f+g*+
	}
	
	
	private String[] postfixSplitter(String posfix)
	{

		System.out.println("Post: " + posfix);
		String[] temp = new String[3];
		
		
		
		if(posfix.length() > 1) //if posfix has values
		{						
			posfix = posfix.substring(1, posfix.length()-1);//remove outer parenthesis 
			int parenCount = 0;
			int i;
			for(i = 0; i < posfix.length(); i++)   // till innermost parenthesis 
			{
				if(posfix.charAt(i) == '(')
					parenCount++;
				else if(posfix.charAt(i) == ')')
					parenCount--;
				if(parenCount == 0)
					break;
			}		
	
			temp[0] = posfix.substring(0, i+1);
	//		System.out.print("temp[0]::   " + posfix.substring(0,i+1)+ "\t");
			
			
			temp[1] = ""+posfix.charAt(i+1);
	//			System.out.print("temp[1]::   " + posfix.charAt(i+1)+ "\t");
								
				
			temp[2] = posfix.substring(i+2);
	//		System.out.print("temp[2]::   " + posfix.substring(i+2)+ "\t");		
			
		}
		else
		{
			temp[0] = "";
			temp[1] = posfix;
			temp[2] = "";
		
		}
	
		
		return temp;
	}
	
	//abc*+de*f+g*+	
	
	//******************************************************

	
	public void populateFromPrefix(String prefix)
	{

	}

	//(a+b)
	//((a+b)+c)
	//(a+(b+c))
	//((a+(b*c))+(((d*e)+f)*g))
	public void populateFromInfix(String infix)
	{
		root = populateFromInfixHelper(infix);
	}

	private Node populateFromInfixHelper(String infix)
	
	
	{
		String[] parts = infixSplitter(infix);//0 = left, 1 = middle, 2 = right
		Node item = new Node(parts[1]);
		if(parts[0].length() > 0)
			item.left = populateFromInfixHelper(parts[0]);
		if(parts[2].length() > 0)
			item.right = populateFromInfixHelper(parts[2]);
		return item;
	}

	private String[] infixSplitter(String infix)
	{
		String[] temp = new String[3];
		if(infix.length() > 1) //if infix has values
		{
			infix = infix.substring(1, infix.length()-1);//remove outer parenthesis 
			int parenCount = 0;
			int i;
			for(i = 0; i < infix.length(); i++)   // till innermost parenthesis 
			{
				if(infix.charAt(i) == '(')
					parenCount++;
				else if(infix.charAt(i) == ')')
					parenCount--;
				if(parenCount == 0)
					break;
			}
			temp[0] = infix.substring(0, i+1);
	//		System.out.println("temp[0]::   " + infix.substring(0,i+1));
			temp[1] = ""+infix.charAt(i+1);
	//		System.out.println("temp[1]::   " + infix.substring(i+1));
			temp[2] = infix.substring(i+2);
	//		System.out.println("temp[2]::   " + infix.substring(i+2));
			/*
			System.out.println(infix.substring(0, i+1));//left point
			System.out.println(infix.charAt(i+1));//middle point
			System.out.println(infix.substring(i+2));//right point
			System.out.println(infix + ":" + i);
			*/
		}
		else
		{
			temp[0] = "";
			temp[1] = infix;
			temp[2] = "";
		}
		return temp;
		
		//++a*bc*+*defg
	}
	


	private class Node
	{
		String data;
		Node left, right;
		public Node(String d)
		{
			data = d;
			left = null;
			right = null;
		}
	}
	
	//Determine whether char is operator
	public boolean isOperator(String temp)
	{
		if(temp.charAt(0) == '+' || temp.charAt(0) == '-' || temp.charAt(0) == '/' || temp.charAt(0) == '*')
		{
			return true;
		}
		else
		{
			return false;
		}		
	}
}
