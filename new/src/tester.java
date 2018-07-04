//================================
//CSCI3200_DA_3409_Summer2018
//Nathaniel Parizi
//Assignment 4 (CH4)
//Problem 4 (Visually Identical Trees)
//================================



public class tester {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
		BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();  // tree that is identical to bst1
		BinarySearchTree<Integer> bst3 = new BinarySearchTree<>();  // tree that is not identical to bst1
		
		bst1.insert(2);
		bst1.insert(4);
		bst1.insert(3);
		bst1.insert(1);
		bst1.insert(8);
		bst1.insert(7);
		bst1.insert(9);
		bst1.insert(0);

		// tree that is identical to bst1
		bst2.insert(2);
		bst2.insert(4);
		bst2.insert(3);
		bst2.insert(1);
		bst2.insert(8);
		bst2.insert(7);
		bst2.insert(9);
		bst2.insert(0);
		
		// tree that is not identical to bst1
		bst3.insert(2);
		bst3.insert(4);
		bst3.insert(3);
		bst3.insert(1);
		bst3.insert(4);
		bst3.insert(7);
		bst3.insert(9);
		bst3.insert(0);
		
		
		// method name "identical()"  to determine whether trees are visually identical
		System.out.println("It is [" + bst1.identical(bst1.root, bst2.root) + "] that bst1 and bst2 are identical");
		System.out.println("It is [" + bst1.identical(bst1.root, bst3.root) + "] that bst1 and bst3 are identical");
		
		


	}

}
