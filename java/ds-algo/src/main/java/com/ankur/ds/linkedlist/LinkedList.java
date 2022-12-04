package com.ankur.ds.linkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    private LNode<T> head;

    private LNode<T> iteratorNode;

    private int size;

    public LinkedList() {
	size = 0;
    }

    public void reverse() {
	if (iteratorNode != null) {
	    throw new ConcurrentModificationException();
	}
	if (head != null) {
	    LNode<T> oldHead = head;
	    try {
		LNode<T> node = head;
		head = null;
		while (node != null) {
		    LNode<T> revNode = new LNode<>();
		    revNode.data = node.data;
		    revNode.next = head;
		    head = revNode;
		    node = node.next;
		}
	    } catch (Exception e) {
		// Reset the data
		head = oldHead;
	    }
	}
    }

    public void addFirst(T data) {
	if (iteratorNode != null) {
	    throw new ConcurrentModificationException();
	}
	LNode<T> node = new LNode<>();
	node.data = data;
	node.next = head;
	head = node;
	size++;
    }

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
 * Node containing generic data to be stored in LinkedList
 */
class LNode<T> {
    T data;
    LNode<T> next;
}
