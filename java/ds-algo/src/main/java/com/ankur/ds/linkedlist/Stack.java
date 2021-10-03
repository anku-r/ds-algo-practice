package com.ankur.ds.linkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of Stack using Doubly Linked List with last pointer
 */
public class Stack<T> implements Iterable<T> {
	
	private Node<T> head;
	private Node<T> last;
	private Node<T> iteratorNode;
	
	private int size;
	
	public Stack() {
		size = 0;
	}
	
	/**
	 * Push data at the top of the stack
	 * 
	 * @param data
	 */
	public void push(T data) {	
		if (iteratorNode != null) {
			throw new ConcurrentModificationException();
		}
		Node<T> newNode = new Node<T>(); 
		newNode.data = data;
		newNode.index = size;
		if (head == null) {
			head = newNode;
		} else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
		size++;
	}
	
	/**
	 * Pop and return data from the top of the stack
	 * 
	 * @return data
	 */
	public T pop() {		
		if (head == null) {
			throw new NoSuchElementException("Stack is empty");
		}
		if (iteratorNode != null) {
			throw new ConcurrentModificationException();
		}
		T data = last.data;
		last = last.previous;
		if (last == null) {
			head = null;
		} else {
			last.next = null;
		}
		size--;
		return data;
	}
	
	/**
	 * Returns data at the top of the stack
	 * 
	 * @return data
	 */
	public T peek() {
		if (head == null) {
			throw new NoSuchElementException("Stack is empty");
		}
		return last.data;
	}
	
	/**
	 * Returns data at the provided index in stack
	 * 
	 * @param index
	 * @return data at specified index
	 */
	public T get(int index) {
		
		Node<T> node = head;
		while(node != null) {
			if (node.index == index) {
				return node.data;
			}
			node = node.next;
		}
		throw new IndexOutOfBoundsException("Index out of bounds at " + index);
	}
	
	/**
	 * Set or Replace data at the provided index in stack
	 * 
	 * @param index
	 * @param data
	 */
	public void set(int index, T data) {
		
		Node<T> node = head;
		while(node != null) {
			if (node.index == index) {
				node.data = data;
				return;
			}
			node = node.next;
		}
		throw new IndexOutOfBoundsException("Index out of bounds at " + index);
	}
	
	/**
	 * Returns index of data stored in the stack
	 * 
	 * @param data
	 * @return index
	 */
	public int indexOf(T data) {
		
		Node<T> node = head;
		while(node != null) {
			if (node.data.equals(data)) {
				return node.index;
			}
			node = node.next;
		}
		return -1;
	}
	
	/**
	 * Checks if the provided data is present in the stack
	 * 
	 * @param data
	 * @return true if present, otherwise false
	 */
	public boolean contains(T data) {	
		return indexOf(data) >= 0;
	}
	
	/**
	 * Checks if stack is empty or not
	 * 
	 * @return true if stack is empty, otherwise false
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * @return Size of stack
	 */
	public int size() {
		return size;
	}
	
	/**
	 * @return Returns object array from the stack
	 */
	public Object[] toArray() {
		Node<T> node = head;
		Object[] arr = new Object[size];
		while (node != null) {
			arr[node.index] = node.data;
			node = node.next;
		}
		return arr;
	}
	
	/**
	 * Prepares Iterator for Stack
	 * 
	 * @return Stack Iterator
	 */
	@Override
	public Iterator<T> iterator() {
			
		iteratorNode = head;	
		return new Iterator<T>() {
			
			@Override
			public boolean hasNext() {
		    	return iteratorNode != null;
		    }
		      
		    @Override
			public T next() {
		    	if (iteratorNode == null) {
		    		throw new NoSuchElementException();
		    	}
		    	T data = iteratorNode.data;
				iteratorNode = iteratorNode.next;
				return data;
		    }
		      
		    @Override
		    public void remove() {
		    	throw new UnsupportedOperationException();
		    }
		};
	}		
}

/**
 * Node containing generic data to be stored in Stack
 */
class Node<T> {
	T data;
    Node<T> next;
    Node<T> previous;
    int index;
}

