package com.datastructureslinkedlist.app;

import java.util.Scanner;

import com.datastructureslinkedlist.model.NodeList;
import com.datastructureslinkedlist.model.SaveData;

/*
 * @author Jonas
 * 
 * */
public class DataStructures {

	public static void main(String[] args) {
		//objects initialization
				String option = "y";
				Scanner input = new Scanner(System.in);
				NodeList nodeList = null;
				
				//variables declaration
				int optionNumber = 0;
				int index = 0;
				nodeList = SaveData.readAll();
				if(nodeList == null) {
					nodeList = new NodeList();
				}
				//process to create the menu
				do 
				{
					//clear the console
					
					System.out.println("Press any letter to continue and 'e' to exit the program");
					
					//get the option of being in the program
					option = input.next();
					
					
					if(option.equals("e"))
					{
						option = "e";
						break;
					}
					else
					{
						//Menu to manipulate the linked list with nodes
						System.out.println("********Options************");
						System.out.println("To add element to the list press:  [1]");
						System.out.println("To show element of the list press: [2]");
						System.out.println("To show all the list press: 	   [3]");
						System.out.println("To show the list size press:       [4]");
						System.out.println("To delete an element of the list:  [5]");
						System.out.println("To update an element of the list:  [6]");
						System.out.println("To reverse all nodes list values:  [7]");
						System.out.println("To save all your nodes list     :  [8]");
						try {
							optionNumber = input.nextInt();
							switch(optionNumber)
							{
							    case 1: 
							    	System.out.println("Input data to the element:");
							    	input.nextLine();
							    	nodeList.add(input.nextLine());
							    	System.out.println("Saved!");
							    	break;
							    case 2:
							    	System.out.println("Input the index of the element:");
							    	index = input.nextInt();
							    	if(nodeList.nodeDataAtIndex(index) == null)
							    	{
							    		System.out.println("That node does not exist!");
							    	}
							    	else
							    	{
							    		System.out.println("The data of element: ["+index+"] is ["+ nodeList.nodeDataAtIndex(index).getNodeData()+"]");
							    	}
							    	
							    	break;
							    case 3:
							    	System.out.println("Elements of the list:");
							    	nodeList.showNodes();
							    	
							    	break;
							    case 4:
							    	System.out.println("The list size is:"+nodeList.getSize());
							    	
							    	break;
							    case 5:
							    	System.out.println("Input the index of the element:");
							    	index = input.nextInt();
							    	if(nodeList.delete(index)) 
							    	{
							    		System.out.println("deleted!!");
							    	}
							    	else
							    	{
							    		System.out.println("nothing changed!!");
							    	}						    	
							    	
							    	break;
							    case 6:
							    	System.out.println("Input the index of the element:");
							    	index = input.nextInt();
							    	System.out.println("Input the node new data:");
							    	input.nextLine();
							    	
							    	if(nodeList.updateNode(index, input.next())) 
							    	{
							    		System.out.println("Updated!!");
							    	}
							    	else
							    	{
							    		System.out.println("nothing changed!!");
							    	}						    	
							    	
							    	break;
							    case 7:
							    	nodeList.reverseNodeList();
							    	System.out.println("List reversed!!");
							    	break;
							    case 8:							    	
							    	System.out.println(SaveData.saveAll(nodeList.nodeDataAtIndex(0)));
							    	break;
							    default:
							    	System.out.println("That option does not exist!");
							    	break;
							    	
							}
						}
						catch(Exception e) {
							System.err.println("Please verify your input");
							e.printStackTrace();
						}
						finally {
							optionNumber = 0;
						}
						//get the user option
						
						
						
					}
					
					
					
				}while(true);
				
			System.out.println("Good bye!");
			input.close();

	}

}
