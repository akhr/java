package com.akh.algorithms.dataStructure.linkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

/**
 *  @fileName: LRUCache.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jul 30, 2018
 *  
 *  LC146
 *  Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *  get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *  put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *  
 *  Follow up:
 *  Could you do both operations in O(1) time complexity?
 */

public class LRUCache{

	
	private static class Node {
		private Node prev = null;
		private Node next = null;
		private int data;

		public Node(int data){
			this.data = data;
		}
	}
	

	private Node leftmost; //Older items will be at LEFT most end
	private Node rightmost; //Newer items will be at RIGHT most end
	private int CAPACITY;

	private Map<Integer, Node> map = new HashMap<Integer, Node>();

	
	public LRUCache(){
		this.CAPACITY = 3;
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

	public void printLRUCache(){
		Node currNode = leftmost;
		System.out.println("LRUCache Entries inOrder (old --> recent) .... ");
		while(currNode != null){
			System.out.println("Data -> "+currNode.data);
			currNode = currNode.next;
		}
		System.out.println("Done LRUCache Entries");
	}
	
	private void printMapContents(){
		System.out.println("Print Map contents --> ");
		for(Entry<Integer, Node> entry :  map.entrySet()){
			System.out.println("Key --> "+entry.getKey()+", Value -->"+entry.getValue().data);
		}
	}
	
	//======================================  TEST  =========================================================//
	@SuppressWarnings("deprecation")
	@Test
	public void testAdd(){
		LRUCache lruCache = new LRUCache();
		lruCache.setCapacity(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		Assert.assertEquals(3, lruCache.getRecent());
	}
	
	@Test
	public void testGet(){
		LRUCache lruCache = new LRUCache();
		lruCache.setCapacity(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		Assert.assertEquals(3, lruCache.get(3));
	}
	
	@Test
	public void testGet_RemovedItem(){
		LRUCache lruCache = new LRUCache();
		lruCache.setCapacity(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		lruCache.put(4, 4);
		Assert.assertEquals(-1, lruCache.get(1));
	}
	
	@Test
	public void testAddOverCapacity(){
		LRUCache lruCache = new LRUCache();
		lruCache.setCapacity(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		lruCache.put(4, 4);
		Assert.assertEquals(4, lruCache.getRecent());
		Assert.assertEquals(2, lruCache.getOldest());
	}
	
	@Test
	public void testMoveToRecents(){
		LRUCache lruCache = new LRUCache();
		lruCache.setCapacity(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.get(1);
		lruCache.put(3, 3);
		lruCache.put(4, 4);
		Assert.assertEquals(4, lruCache.getRecent());
		Assert.assertEquals(1, lruCache.getOldest());
	}
	
	@Test
	public void testMoveToRecents_2(){
		LRUCache lruCache = new LRUCache();
		lruCache.setCapacity(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		lruCache.printLRUCache();
		lruCache.get(1);
		lruCache.get(2);
		lruCache.printLRUCache();
		lruCache.put(4, 4);
		lruCache.get(2);
		lruCache.printLRUCache();
		Assert.assertEquals(2, lruCache.getRecent());
		Assert.assertEquals(1, lruCache.getOldest());
	}

}
