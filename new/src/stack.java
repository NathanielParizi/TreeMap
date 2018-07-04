public class EquationBinaryTree {
	private Node root;
	public EquationBinaryTree(){
		root = null;
	}

	//toInfix
	public String toInfix(){
		return toInfixHelper(root);
	}
	private String toInfixHelper(Node node){
		String output = "";
		if(node.leftChild != null){
			output += "(";
			output += toInfixHelper(node.leftChild);
			output += node;
			output += toInfixHelper(node.rightChild);
			output += ")";
		}else
			output += node;
		return output;
	}

	//toPrefix
	public String toPrefix(){
		return toPrefixHelper(root);
	}
	private String toPrefixHelper(Node node){
		String output = "";
		if(node.leftChild != null){
			output += node;
			output += toPrefixHelper(node.leftChild);
			output += toPrefixHelper(node.rightChild);
		}else
			output += node;
		return output;
	}

	//toPostfix
	public String toPostfix(){
		return toPostfixHelper(root);
	}
	private String toPostfixHelper(Node node){
		String output = "";
		if(node.leftChild != null){
			output += toPostfixHelper(node.leftChild);
			output += toPostfixHelper(node.rightChild);
			output += node;
		}else
			output += node;
		return output;
	}

	//======================================
	//Populate with infix function
	public void populateFromInfix(String infix){ 
		root = populateFromInfixHelper(infix); 
	}
	private Node populateFromInfixHelper(String infix){ 
		String[] parts = infixBreakdownHelper(infix); 
		Node temp = new Node(parts[0].charAt(0));
		if(parts[1].length() == 1)
			temp.leftChild = new Node(parts[1].charAt(0));
		else
			temp.leftChild = populateFromInfixHelper(parts[0]);

		if(parts[2].length() == 1)
			temp.rightChild = new Node(parts[2].charAt(0));
		else
			temp.rightChild = populateFromInfixHelper(parts[2]);
		return temp;
	}
	private String[] infixBreakdownHelper(String infix){ 
		String[] temp = new String[3];
		int pos = 0;
		int count = 0;
		for(int i = 1; i < infix.length(); i++){
			if(infix.charAt(i) == '(')
				count++;
			else if(infix.charAt(i) == ')')
				count--;
			if(count == 0){
				pos = i;
				break;
			}
		}
		temp[0] = infix.substring(1, pos+1);//left
		temp[1] = ""+infix.charAt(pos+1);//middle
		temp[2] = infix.substring(pos+2, infix.length()-1);//right
		return temp;
	}
	
	//======================================
	//Prefix - (+2+11) - (++a*bc*+*defg)
	public void populateFromPrefix(String pre){
		root = populateFromPrefixHelper(pre);
	}
	private Node populateFromPrefixHelper(String pre){
		String[] parts = prefixBreakdownHelper(pre);
		Node temp = new Node(parts[0].charAt(0));
		if(parts[1].length() == 1)
			temp.leftChild = new Node(parts[1].charAt(0));
		else
			temp.leftChild = populateFromPrefixHelper(parts[1]);

		if(parts[2].length() == 1)
			temp.rightChild = new Node(parts[2].charAt(0));
		else
			temp.rightChild = populateFromPrefixHelper(parts[2]);
		return temp;
	}
	private String[] prefixBreakdownHelper(String pre){
		String[] temp = new String[3];
		
		//If pre is something like "-15"
		if(pre.length() == 3){
			temp[0] = "" + pre.charAt(0);//left
			temp[1] = "" + pre.charAt(1);//middle
			temp[2] = "" + pre.charAt(2);//right
			return temp;
		}
		//Assign left
		temp[0] = "" + pre.charAt(0);//left
		
		//Seperate left and right sides
		int end = 1;
		int count = 1;
		for(int i = 1; i < pre.length(); i++){
			if(isOperator(pre.charAt(i))){
				count++;
			}else{
				count--;
			}
			if(count == 0){
				end = i;
				break;
			}
		}
		
		//Assign middle
		temp[1] = "" + pre.substring(1,end+1);//middle
		
		//Assign right
		temp[2] = pre.substring(end+1, pre.length());//right
		return temp;
	}

	//======================================
	//Postfix
	public void populateFromPostfix(String post){
		root = populateFromPostfixHelper(post);
	}
	private Node populateFromPostfixHelper(String post){
		String[] parts = postfixBreakdownHelper(post);
		for(String s : parts)
			System.out.println("Parts: " + s);
		Node temp = new Node(parts[0].charAt(0));
		if(parts[2].length() == 1)
			temp.leftChild = new Node(parts[2].charAt(0));
		else
			temp.leftChild = populateFromPostfixHelper(parts[2]);

		if(parts[1].length() == 1)
			temp.rightChild = new Node(parts[1].charAt(0));
		else
			temp.rightChild = populateFromPostfixHelper(parts[1]);
		return temp;
	}
	private String[] postfixBreakdownHelper(String post){
		System.out.println("Post: " + post);
		String[] temp = new String[3];
		
		//If post is something like "15-"
		if(post.length() == 3)
		{
			temp[2] = "" + post.charAt(0);//left
			temp[1] = "" + post.charAt(1);//middle
			temp[0] = "" + post.charAt(2);//Operator
			return temp;
		}
		//Assign left
		temp[0] = "" + post.charAt(post.length()-1);//Operator
		
		//Seperate left and right
		int end = post.length();
		int count = 1;
		for(int i = post.length()-2; i >= 0; i--){
			if(isOperator(post.charAt(i))){
				count++;
			}else{
				count--;
			}
			if(count == 0){
				end = i;
				break;
			}
		}
		
		//Assign right
		temp[1] = "" + post.substring(end,(post.length()-1));//right
		System.out.println("Right: " + temp[1]);
		
		//Assign left
		temp[2] = post.substring(0, end);//left
		System.out.println("Left: " + temp[2]);
		return temp;
	}
	
	//======================================
	//isOperator
	private boolean isOperator(char c){
		switch(c){
			case '+':
			case '-':
			case '*':
			case '/':
				return true;
			default:
				return false;
		}
	}
	
	//======================================
	//Node
	private class Node{
		public Node leftChild, rightChild;
		public char data;
		public Node(char data) {
			leftChild = null;
			rightChild = null;
			this.data = data;
		}
		public String toString(){
			return "" + data;
		}
	}
}