package com.example.funwithds;

public class Node 
{
	private int key;
    private Node parent;
    private Node leftChild;
    private Node rightChild;
 
    public Node(int key,Node parent ,Node leftChild, Node rightChild) 
    {
        this.setKey(key);
        this.setLeftChild(leftChild);
        this.setRightChild(rightChild);
        this.setParent(parent);
    }
 
    public void setKey(int key) 
    {
        this.key = key;
    }
 
    public Integer getKey() 
    {
        return key;
    }
 
    public void setParent(Node parent) 
    {
        this.parent = parent;
    }
 
    public Node getParent() 
    {
        return parent;
    }
 
    public void setLeftChild(Node leftChild) 
    {
        this.leftChild = leftChild;
    }
 
    public Node getLeftChild() 
    {
        return leftChild;
    }
 
    public void setRightChild(Node rightChild) 
    {
        this.rightChild = rightChild;
    }
 
    public Node getRightChild() 
    {
        return rightChild;
    }
}
