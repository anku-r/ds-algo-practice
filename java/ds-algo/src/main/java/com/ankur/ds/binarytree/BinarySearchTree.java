package com.ankur.ds.binarytree;

import java.util.List;

public class BinarySearchTree {
	
	private Node root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public BinarySearchTree(int[] arr) {
		this.root = null;
		for (int key : arr) {
			insert(key);
		}
	}
	
	public BinarySearchTree(List<Integer> list) {
		this.root = null;
		for (int key : list) {
			insert(key);
		}
	}

	/**
	 * Pre-Order Traversal
	 * Root -> Left -> Right
	 */
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	/**
	 * In-Order Traversal
	 * Left -> Root -> Right
	 */
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}
	
	/**
	 * Post-Order Traversal
	 * Left -> Right -> Root
	 */
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + " ");
		}
	}
	
	/**
	 * Insertion in BST
	 * 
	 * @param data
	 */
	public void insert(int data) {
		root = insert(data, root);
	}
	
	private Node insert(int data, Node node) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (node.data > data) {
				node.left = insert(data, node.left);
			} else {
				node.right = insert(data, node.right);
			}
		}
		return node;
	}
	
	/**
	 * Creates Sample Binary Search Tree
	 *      8
	 *    /  \
	 *   3    10
	 *  / \     \
	 * 1   6     14
	 *    / \    / \
	 *   4   7  13  20
	 */
	public void sampleBinaryTree() {
		
		Integer[] arr = {
				8, 3, 10, 1, 6, 14, 4, 7, 13, 20
		};
		
		for (Integer integer : arr) {
			insert(integer);
		}
	}
	
	//===================================
	public void printBorder() {
		printLeft(root);
	}
	public void printLeft(Node node) {
		if (node != null) {
			System.out.println(node.data);
			printLeft(node.left);
			printBottom(node.right);
		} 
	}
	
	private void printBottom(Node node) {
		
		if (node != null) {
			printBottom(node.left);
			printBottom(node.right);
			if (node.left == null && node.right == null) {
				System.out.println(node.data);
			}
		}
	}
	//==========================================
}

class Node {
	
	Node left;
	int data;
	Node right;
	
	Node(int data){
		this.data = data;
	}
	
	Node() {}
}
