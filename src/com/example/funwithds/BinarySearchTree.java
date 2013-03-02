package com.example.funwithds;

public class BinarySearchTree {
	public Node root;

	public BinarySearchTree() {
		root = null;
	}
	
	public boolean isEmpty()
	{
		if(root==null)
			return true;
		return false;
	}

	public boolean insert(int key) {
		Node currNode = root;
		if (root == null) {
			root = new Node(key, null, null, null);
			return true;
		} else {
			boolean ret = true;
			while (true) {
				if (currNode.getKey() < key) {
					if (!(currNode.getRightChild() == null)) {
						currNode = currNode.getRightChild();
					} else {
						currNode.setRightChild(new Node(key, currNode, null,
								null));
						break;
					}
				} else if (currNode.getKey() > key) {
					if (!(currNode.getLeftChild() == null)) {
						currNode = currNode.getLeftChild();
					} else {
						currNode.setLeftChild(new Node(key, currNode, null,
								null));
						break;
					}
				} else {
					ret = false;
					break;
				}
			}
			return ret;
		}
	}

	public boolean delete_node(int key) {
		Node currNode = root;
		boolean found = false;
		if (currNode.getKey() == key && (root.getLeftChild()==null) && (root.getRightChild()==null)) {
			root = null;
			return true;
		} else {
			while (currNode!=null) {
				if (currNode.getKey() < key)
					currNode = currNode.getRightChild();
				else if (currNode.getKey() > key)
					currNode = currNode.getLeftChild();
				else {
					found = true;
					break;
				}
			}
			
			 if(currNode==null) 
			 { 
				 return false;
			}
			 
			if (found == true) {
				if ((currNode.getLeftChild() == null)
						&& (currNode.getRightChild() == null)) {
					if (currNode.getParent() != null) {
						if (currNode.getParent().getRightChild() == currNode)
							currNode.getParent().setRightChild(null);
						else
							currNode.getParent().setLeftChild(null);
						currNode.setParent(null);
					}
				} else if ((currNode.getLeftChild() == null)
						&& (currNode.getRightChild() != null)) {
					if(currNode.getParent()!=null)
					{
						if (currNode.getParent().getRightChild() == currNode)
							currNode.getParent().setRightChild(
								currNode.getRightChild());
						else
							currNode.getParent().setLeftChild(
								currNode.getRightChild());
					}
					if(currNode==root)
						root=currNode.getRightChild();
					currNode.getRightChild().setParent(currNode.getParent());
					currNode.setRightChild(null);
					currNode.setParent(null);
				} else if ((currNode.getLeftChild() != null)
						&& (currNode.getRightChild() == null)) {
					if(currNode.getParent()!=null)
					{
						if (currNode.getParent().getRightChild() == currNode)
							currNode.getParent().setRightChild(
								currNode.getLeftChild());
						else
							currNode.getParent().setLeftChild(
								currNode.getLeftChild());
					}
					if(currNode==root)
						root=currNode.getLeftChild();
					currNode.getLeftChild().setParent(currNode.getParent());
					currNode.setLeftChild(null);
					currNode.setParent(null);
				} else {
					Node min = currNode.getRightChild();
					while (min.getLeftChild() != null) {
						min = min.getLeftChild();
					}
					currNode.setKey(min.getKey());
					if (min.getRightChild() != null) 
					{
						if(min.getParent()!=null)
						{
							if(min.getParent().getLeftChild()==min)
								min.getParent().setLeftChild(min.getRightChild());
							else
								min.getParent().setRightChild(min.getRightChild());
							min.getRightChild().setParent(min.getParent());
							min.setParent(null);
						}
						else
						{
							currNode.setRightChild(null);
						}
					}
					else
					{
						if(min.getParent()!=root)
						{
							if(min.getParent().getLeftChild()==min)
								min.getParent().setLeftChild(null);
							else
								min.getParent().setRightChild(null);
							min.setParent(null);
						}
						else
						{
							root.setRightChild(null);
						}
					}
					min.setRightChild(null);
				}
				return true;
			} else {
				return false;
			}
		}
	}
}
