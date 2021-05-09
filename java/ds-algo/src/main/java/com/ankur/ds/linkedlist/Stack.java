package com.ankur.ds.linkedlist;

import java.util.Iterator;

/*
 * Node containing generic data to be stored in Stack
 */
class Node<T> {
	T data;
    Node<T> previous;
    int index;
}

/*
 * Implementation of Stack
 */
public class Stack<T> implements Iterable<T> {
	
	private Node<T> last;
	private Node<T> currentNode;
	
	public int size;
	
	public Stack() {
		last = currentNode = null;
		size = 0;
	}
	
	public void push(T data) {
		
		Node<T> newNode = new Node<T>(); 
		newNode.data = data;
		newNode.previous = last;
		newNode.index = size;;
		last = newNode;
		size++;
	}
	
	public T pop() {
		
		T data = last.data;
		last = last.previous;
		size--;
		return data;
	}
	
	public T get(int index) {
		
		Node<T> node = last;
		while(node != null) {
			if (node.index == index) {
				return node.data;
			}
			node = node.previous;
		}
		throw new IndexOutOfBoundsException("Index out of bounds at " + index);
	}
	
	public void set(int index, T data) {
		
		Node<T> node = last;
		while(node != null) {
			if (node.index == index) {
				node.data = data;
				return;
			}
			node = node.previous;
		}
		throw new IndexOutOfBoundsException("Index out of bounds at " + index);
	}
	
	public int indexOf(T data) {
		
		Node<T> node = last;
		while(node != null) {
			if (node.data.equals(data)) {
				return node.index;
			}
			node = node.previous;
		}
		return -1;
	}
	
	public boolean contains(T data) {	
		return indexOf(data) >= 0;
	}
	
	public boolean isEmpty() {
		return last == null;
	}
	
	/**
	 * Prepares Iterator for Stack
	 * Currently Iterator starts from last element
	 */
	@Override
	public Iterator<T> iterator() {
			
		currentNode = last;	
		return new Iterator<T>() {
			
			@Override
			public boolean hasNext() {
		    	return currentNode != null;
		    }
		      
		    @Override
			public T next() {
		    	T data = currentNode.data;
				currentNode = currentNode.previous;
				return data;
		    }
		      
		    @Override
		    public void remove() {
		    	throw new UnsupportedOperationException();
		    }
		};
	}	
}

