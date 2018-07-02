//================================
//CSCI3200_DA_3409_Summer2018
//Nathaniel Parizi
//Assignment 4 (CH4)
//Problem 6  (TreeMap)
//================================

import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapTester {
	
	  public static void main(String[] args)
	  {

		  TreeMap<String, Integer> treeMap = new TreeMap<>();
		  Scanner scan = new Scanner(System.in);
		  String name = null;	 
		  System.out.println("\n******************************\n"
			  		+ "TreeMap is empty.\nFill tree with names and enter \"quit\" when complete\n");			  	  
		  do
		  {
			System.out.print("\tEnter name:");
			name = scan.nextLine();
			if (!name.isEmpty() && !name.equalsIgnoreCase("quit"))
				{
					treeMap.put(name, vowelCount(name));
				}
		  }while (!name.equalsIgnoreCase("quit"));	
		  
		  //***************************testing TreeMap methods
//		  System.out.println(treeMap.size());
//		  System.out.println(treeMap.lastKey());
//		  System.out.println(treeMap.containsKey("Nathaniel"));
//		  System.out.println(treeMap.containsValue(4));
		
		  System.out.println("******************************\n");
		  System.out.printf("\n%-40s%s\n", "Name   (<String> Keys)", "Count    (<Integer> values)");
		  System.out.println();
		  
		  
		  //Enhanced forloop to parse through tree's keys <String>
		  //and find vowel count values which are stored as <Integer>   
		  for(String names: treeMap.descendingKeySet())
		  	{
			  System.out.printf("%-40s%d\n", names, treeMap.get(names));
		  	}	  
		}
	
// count vowels in String
  public static int vowelCount(String name)
  {
	  
  int count = 0;

  	for (int i = 0; i < name.length(); i++)
  	{
  		if (name.charAt(i) == 'a' || name.charAt(i) == 'e' || name.charAt(i) == 'i' || name.charAt(i) == 'o' || name.charAt(i) == 'u'
  			|| name.charAt(i) == 'A' || name.charAt(i) == 'E' || name.charAt(i) == 'I' || name.charAt(i) == 'O' || name.charAt(i) == 'U')
  		{
  			count++;
  		}
  	}
  	
  	return count;
  }

}