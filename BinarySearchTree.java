package com.greatlearning.search;

import java.util.HashSet;

public class BinarySearchTree {

	static class Node
	{
		int data;
		Node left,right;
	};
	
	static Node NewNode(int data)
	{
		Node temp = new Node();
		temp.data = data;
		temp.left  = null;
		temp.right = null;
		
		return temp;
	}
	
	public Node insert(Node root,int key)
	{
		if(root == null)
			return NewNode(key);
		
		if(key < root.data)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;
	}
	
	public boolean findPairUtil(Node root, int sum ,HashSet<Integer> set)
	{
		if(root == null)
			return false;
		
		if(findPairUtil(root.left,sum,set))
			return true;
		
		if(set.contains(sum - root.data))
		{
			System.out.println("Pair is found (" + (sum - root.data) +","+ root.data +")" );
			return true;
		}
		else
			set.add(root.data);
			return findPairUtil(root.right,sum,set);
	}
	
	public void findPairWithGivenSum(Node root, int sum)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		if(!findPairUtil(root, sum, set))
			System.out.println("Pairs do not exists" +"\n");
	
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = null;
		
		BinarySearchTree bst = new BinarySearchTree();
		
		root = bst.insert(root, 40);
		root = bst.insert(root, 20);
		root = bst.insert(root, 60);
		root = bst.insert(root, 10);
		root = bst.insert(root, 30);
		root = bst.insert(root, 50);
		root = bst.insert(root, 70);
		
		int sum = 130;
		bst.findPairWithGivenSum(root,sum);
		
	}

}
