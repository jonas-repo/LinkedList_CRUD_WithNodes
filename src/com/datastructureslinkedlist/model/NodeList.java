package com.datastructureslinkedlist.model;

public class NodeList {
	private int size;
	private Node firstNode;
	
	
	
	public NodeList() {
	
	}

	public int getSize() 
	{
		return size;
	}
	
	public boolean updateNode(int index, Object data)
	{
		//get the node 
		Node temp = nodeDataAtIndex(index);
		
		//if the node exist change the data else send false
		if(temp != null)
		{
			temp.setNodeData(data);
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	public Node nodeDataAtIndex(int index)
	{
		//objects 
		Node temp = firstNode;
		
		//if the index is bigger than the list size or is a negative number return nothing
		if(index > size || index < 0)
		{
			return null;
		}
		else
		{
			//iterate in the list until get the node and set the node to the next one
			for (int i = 0;temp != null &&  i < index; i++) 
			{
				
					temp = temp.getNextNode();			   
			}
			return temp;
		}
	}
	
	public void add(Object nodeData) 
	{
		if (firstNode == null)  //there is no nodes in the list
		{
			firstNode = new Node(nodeData);
		} 
		else
		{
			Node temp = firstNode;
			Node newNode = new Node(nodeData);
			//move trough the nodes until get the last without next node to assign the new node
			while(true)
			{
				
				if(!temp.hasNextNode())
				{
					temp.setNextNode(newNode);
					break;
				}
				else
				{
					temp = temp.getNextNode();
				}
				
			}
			
		}
		size++; //make the list bigger 
	}
	
	public boolean delete(int index)
	{
		Node temp = firstNode;
		
		//if there no nodes in the list
		if(firstNode == null)
		{
			return false;
		}
		else if(index > size || index < 0) //if the index is bigger than list size or negative number
		{
			return false;
		}
		else if(index == 0) //if the node to delete is the first in the list
		{
			firstNode = temp.getNextNode(); //the first will be equals than the second reference
			return true;
		}
		else
		{
			
			
			//find previous node of the node to be deleted
			for (int i = 0; temp != null && i < index-1; i++) {
				temp = temp.getNextNode();
			}
			
			//set nextNode equals to the next node of the node to delete the reference
			Node nextNode = temp.getNextNode().getNextNode();
			
			//set this node to the next node of the node to delete the reference
			temp.setNextNode(nextNode);
			size--;
			return true;
		}
		
	}
	
	public void showNodes()
	{
		Node temp = firstNode;
		for (int i = 0; temp != null; i++) {
			System.out.println("The data of element: ["+i+"] is ["+temp.getNodeData()+"]");
			temp = temp.getNextNode();
		}
	}
	
	
}
