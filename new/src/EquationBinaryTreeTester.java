
public class EquationBinaryTreeTester {

	public static void main(String[] args) {
		EquationBinaryTree ebt = new EquationBinaryTree();

//		ebt.populateFromInfix("(a+b)");
//	//	ebt.populateFromPostfix("(a+b)");
//		ebt.printInfix();
//		ebt.printPostfix();
//		ebt.printPrefix();
//
//		ebt.populateFromInfix("((a+b)+c)");
//		ebt.printInfix();
//		ebt.printPostfix();
//		ebt.printPrefix();
//
//		ebt.populateFromInfix("(a+(b+c))");
//		ebt.printInfix();
//		ebt.printPostfix();
//		ebt.printPrefix();

		System.out.println();
		ebt.populateFromInfix("((a+(b*c))+(((d*e)+f)*g))");
		ebt.populateFromPostfix("((a+(b*c))+(((d*e)+f)*g))");
		System.out.println("**********************************");
		ebt.printInfix();
		ebt.printPostfix();
		ebt.printPrefix();

	}

}
