package com.ankur.ds.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {
	
	private Node root;
	
	static int maxLevel = 0;
	
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
		list.forEach(this::insert);
	}
	
	/**
	 * This method invert the binary tree
	 */
	public void invert() {
		invert(root);
	}
	
	private void invert(Node node) {
		if (node != null && (node.left != null || node.right != null)) {
			invert(node.left);
			invert(node.right);
			Node tmpNode = node.left;
			node.left = node.right;
			node.right = tmpNode;
		}
	}
	
	/**
	 * This method prints all the leaf nodes
	 */
	public void leafNode() {
		leafNode(root);
	}
	
	private void leafNode(Node node) {
		if (node != null) {
			if (node.left == null && node.right == null) {
				System.out.println(node.data);
			}
			leafNode(node.left);
			leafNode(node.right);
		}
	}
	
	/**
	 * @return Sorted List out of the BST
	 */
	public List<Integer> sortedList() {
		List<Integer> returnList = new ArrayList<>();
		sortBSTIntoList(root, returnList);
		return returnList;
	}
	
	private void sortBSTIntoList(Node node, List<Integer> returnList) {
		if (node != null) {
			sortBSTIntoList(node.left, returnList);
			returnList.add(node.data);
			sortBSTIntoList(node.right, returnList);
		}
	}
	
	/**
	 * Printing left view of binary tree
	 */
	public void leftView() {
        leftView(root, 0);
    }
    
    private void leftView(Node node, int level) {
        if (node != null) {
        	if (level == maxLevel) {
        		System.out.println(node.data);
        		maxLevel++;
        	}
        	leftView(node.left, level + 1);
        	leftView(node.right, level + 1);
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
	 * 1   6     15
	 *    / \    / \
	 *   4   7  13  20
	 */
	public void sampleBinaryTree() {	
		if (root != null) {
			throw new UnsupportedOperationException("A tree is already present");
		}
		Arrays.asList(
			8, 3, 10, 1, 6, 15, 4, 7, 13, 20
		).forEach(data -> insert(data));
	}

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
