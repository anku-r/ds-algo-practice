package com.ankur.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU cache created using a HashMap and Doubly Linked List.
 * Recent accessed cache will be inserted into begining of DLL.
 * Least accessed will be moved to last and removed from end of DLL.
 * Cache will be fetch using key from hashmap.
 *
 * Usage:
 * LRUCache cache = new LRUCache;
 * cache.put(1, "Ankur");
 * String val = cache.get(1);
 */
class LRUCache {

    private Map<Integer, CNode> cache;
    private CNode head, last;
    private int capacity;

    /**
     * LRU Initialization with capacity
     * Initializes the map where cache nodes are stored.
     * Initializes the doubly linked list with head and last
     */
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        head = new CNode();
        last = new CNode();
        head.next = last;
        last.prev = head;
    }

    /**
     * checks if key is not present, return null
     * else get the node from the map,
     * removes the node, and add it to the beginning
     */
    public String get(int key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        CNode node = cache.get(key);
        removeNode(node);
        addNodeAtBegin(node);
        return node.value;
    }

    /**
     * checks if key is present, get the node and change the value
     * remove the same node and add it to beginning
     *
     * else create a new node with the key and add it to the beginning,
     * if size is more than capacity, the removes the node from last too
     *
     */
    public void put(int key, String value) {
        CNode node;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.value = value;
            removeNode(node);
            addNodeAtBegin(node);
            return;
        }
        if (cache.size() >= capacity) {
            cache.remove(last.prev.key);
            removeNode(last.prev);
        }
        node = new CNode();
        node.key = key;
        node.value = value;
        cache.put(key, node);
        addNodeAtBegin(node);
    }

    /**
     * This will remove node from any position
     */
    private void removeNode(CNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * This will add node at the beginning of linked list
     */
    private void addNodeAtBegin(CNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
}

/**
 * Node structure for one cache
 */
class CNode {
    int key;
    String value;
    CNode next, prev;
}
