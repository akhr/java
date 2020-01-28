package com.akh.aa.mudField;

import java.util.HashMap;
import java.util.Map;

/**
 *  @fileName: LRUCache.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 1, 2018
 */

class LRUCache{

	
	private static class Node {
		private Node prev = null;
		private Node next = null;
		private int data;
		Map<Integer, Integer> m = new HashMap();
		public Node(int data){
			this.data = data;
		}
	}
	

	private Node leftmost; //Older items will be at LEFT most end
	private Node rightmost; //Newer items will be at RIGHT most end
	private int CAPACITY;

	private Map<Integer, Node> map = new HashMap<Integer, Node>();

	
	public LRUCache(int capacity){
		this.CAPACITY = capacity;
	}
	
	
	public void setCapacity(int capacity){
		this.CAPACITY = capacity;
	}

	public int getRecent(){
		return get(rightmost.data);
	}
	
	public int getOldest(){
		return get(leftmost.data);
	}
	
	public int get(int key){
		Node searchNode = map.get(key);
		if(searchNode != null){
			moveToRecents(key, searchNode);
			return searchNode.data;
		}else{
			return -1;
		}
	}

	public void put(int key, int value){
		if(map.size() >= CAPACITY)
			removeOldest();
		add(key, value);
	}

	private void add(int key, int value){
		if(map.containsKey(key)){
			moveToRecents(key, map.get(key));
		}else{
			Node newNode = new Node(value);
			addToRecents(key, newNode);
		}
	}

	private void addToRecents(int key, Node nodeToAdd){
		map.put(key, nodeToAdd);
		
		if(leftmost == null){ // Cache is empty
			leftmost = nodeToAdd;
			rightmost = nodeToAdd;
		} else{
			rightmost.next = nodeToAdd;
			nodeToAdd.prev = rightmost;
			rightmost = nodeToAdd;
		}
	}

	private void moveToRecents(int key, Node node){
		if(node == null){
			return;
		}
		if(node != rightmost){
			Node relocatedNode = removeFromMiddle(node);
			addToRecents(key, relocatedNode);
		}
	}

	private Node removeOldest(){
		Node returnNode = null;

		if(leftmost != null){
			map.remove(leftmost.data);
			if(leftmost.next != null){
				returnNode = leftmost;
				leftmost = returnNode.next;
				returnNode.next = null;
				leftmost.prev = null;
			}
		}
		return returnNode;
	}

	private Node removeRecent(){
		Node returnNode = null;

		if(rightmost != null){
			map.remove(rightmost.data);
			if(rightmost.prev != null){
				returnNode = rightmost;
				rightmost = returnNode.prev;
				returnNode.prev = null;
				rightmost.next = null;
			}
		}
		map.remove(returnNode.data);
		return returnNode;
	}

	private Node removeFromMiddle(Node node){
		if(node != null){			
			if(node.prev != null && node.next != null){
				Node left = node.prev;
				Node right = node.next;
				node.prev = null;
				node.next = null;
				left.next = right;
				right.prev = left;
				map.remove(node.data);
			}else{
				if(node.prev == null){
					return removeOldest();
				}else if (node.next == null){
					return removeRecent();
				}
			}
		}
		return node;
	}
}