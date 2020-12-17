package com.kishorekumarkorada.test;

public class Test {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		
	}
}

class Node {
	
	private int value;
	private Node nextNode;
	
	public Node(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}	
}