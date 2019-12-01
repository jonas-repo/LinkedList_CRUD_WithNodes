package com.datastructureslinkedlist.model;

public class Node {
	
	
	private Object nodeData;
	private Node nextNode;
	
	public Node(Object nodeData) {
	
		this.nodeData = nodeData;
	}
	
	public Object getNodeData() {
		return nodeData;
	}
	public void setNodeData(Object nodeData) {
		this.nodeData = nodeData;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	public boolean hasNextNode()
	{
		if(nextNode == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public String toString() {
		return "Node [nodeData=" + nodeData + ", nextNode=" + nextNode.getNodeData() + "]";
	}
	
	
}
