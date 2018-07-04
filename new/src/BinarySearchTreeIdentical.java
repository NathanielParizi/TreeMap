//================================
//CSCI3200_DA_3409_Summer2018
//Nathaniel Parizi
//Assignment 4 (CH4)
//Problem 4 (Visually Identical Trees)
//================================

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeIdentical<E extends Comparable<? super E>> {
	Node root;

	public BinarySearchTreeIdentical()
	{
		root = null;
	}

	public void printTree()
	{
		printTree(root);
	}
	private void printTree(Node current)
	{
		if(current != null)
		{
			String content = "Current:"+current.data.toString();
			if(current.left != null)
			{
				content += "; Left side:"+current.left.data.toString();
			}
			if(current.right != null)
			{
				content += "; Right side:"+current.right.data.toString();
			}
			System.out.println(content);
			printTree(current.left);
			printTree(current.right);

		}
	}
	
	 //*************************************************************
	//Recursive Method
	
	public boolean identical(Node leftChild, Node rightChild) //
	{
		if(leftChild == null && rightChild == null)
		{
			return true;
		}
		if( (leftChild == null && rightChild != null) || (leftChild != null && rightChild == null) )
		{
			return false;
		}
		
		//recursive call
		return identical(leftChild.left, rightChild.left) && identical(leftChild.right, rightChild.right);
	}
	
	//**************************************************************
	
	
	
	 
	public void printInOrder()
	{
		System.out.print("In order:");
		printInOrder(root);
		System.out.println();
	}
	private void printInOrder(Node current)
	{
		if(current != null)
		{
			printInOrder(current.left);
			System.out.print(current.data.toString()+",");
			printInOrder(current.right);
		}
	}
	
	public boolean contains(E val)
	{
		Node result = findNode(val, root);

		if(result != null)
			return true;
		else
			return false;
	}
	private Node findNode(E val, Node current)
	{
		//base cases
		if(current == null)
			return null;
		if(current.data.equals(val))
			return current;

		//recursive cases
		int result = current.data.compareTo(val);
		if(result < 0)
			return findNode(val, current.right);
		else
			return findNode(val, current.left);
	}
	public E findMin()
	{
		Node result = findMin(root);
		if(result == null)
			return null;
		else
			return result.data;
	}
	private Node findMin(Node current)
	{
		while(current.left != null)
		{
			current = current.left;
		}
		return current;
	}
	public E findMax()
	{
		Node current = root;
		while(current.right != null)
		{
			current = current.right;
		}
		return current.data;
	}
	public void insert(E val)
	{
		root = insertHelper(val, root);
	}
	public Node insertHelper(E val, Node current)
	{
		/* for showing steps to insert a given value
		if(val.equals(9) && current != null)
		{
			System.out.println(current.data);
		}
		*/

		if(current == null)
		{
			return new Node(val);
		}
		int result = current.data.compareTo(val);
		if(result < 0)
		{
			current.right = insertHelper(val, current.right);
		}
		else if(result > 0)
		{
			current.left = insertHelper(val, current.left);
		}
		else//update
		{
			current.data = val;
		}
		return current;
	}
	public void remove(E val)
	{
		root = removeHelper(val, root);
	}
	private Node removeHelper(E val, Node current)
	{
		if(current.data.equals(val))
		{
			if(current.left == null && current.right == null)//no children
			{
				return null;
			}
			else if(current.left != null && current.right != null)//two children
			{
				Node result = findMin(current.right);
				result.right = removeHelper(result.data, current.right);
				result.left = current.left;
				return result;
			}
			else//one child
			{
				return (current.left != null)? current.left : current.right;
			}
		}
		int result = current.data.compareTo(val);
		if(result < 0)
		{
			current.right = removeHelper(val, current.right);
		}
		else if(result > 0)
		{
			current.left = removeHelper(val, current.left);
		}
		return current;
	}


	private class Node
	{
		E data;
		Node left, right;
		public Node(E d)
		{
			data = d;
			left = null;
			right = null;
		}
	}

}
