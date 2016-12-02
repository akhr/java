package com.akh.algorithms.dataStructure.hashMap;

public class HashMapUsingArray {

	/**
	 * Assume this map only contains String key and String value.
	 */

	private int size = 0;
	private Node[] data = new Node[20];

	public static void main(String[] args) {
		HashMapUsingArray hashMapUsingArray = new HashMapUsingArray();
		hashMapUsingArray.put("sara", "one");
		hashMapUsingArray.put("saar", "two");
		hashMapUsingArray.put("raas", "three");
		System.out.println(hashMapUsingArray.get("raas"));
	}

	private class Entry{
		private String key;
		private String value;
	}

	private class Node{
		private Entry curr;
		private Node next;
	}

	private int hash(String strVal){
		int hash = 0;
		char[] charArray = strVal.toCharArray();

		if(charArray.length == 0)
			return hash;

		for(int i=0; i< charArray.length-1; i++){
			hash = hash + charArray[i];
		}

		hash = 100;
		hash = Math.abs(hash);
		if(hash > data.length-1){
			hash = hash%data.length;
		}

		return hash;
	}

	private boolean isEqual(String val1, String val2){

		char[] charArray1 = val1.toCharArray();
		char[] charArray2 = val2.toCharArray();

		if(charArray1.length != charArray2.length)
			return false;

		for(int i=0; i<charArray1.length-1; i++){
			if(charArray1[i] != charArray2[i])
				return false;
		}

		return true;
	}

	public void put(String key, String value){

		if(key==null){
			return;
		}
		int hash = hash(key);

		Entry newEntry = new Entry();
		newEntry.key = key;
		newEntry.value = value;

		Node newNode = new Node();
		newNode.curr = newEntry;
		newNode.next = null;

		if(data[hash]==null){
			data[hash] = newNode;
		}else{
			Node currNode = data[hash];
			while(currNode.next != null){
				currNode = currNode.next;
			}
			currNode.next = newNode;
			size++;
		}
	}

	public String get(String key){

		if(key == null)
			return null;

		int hash = hash(key);

		if(data[hash] == null){
			return null;
		}else{
			Node currNode = data[hash];
			while(currNode != null){
				if(isEqual(currNode.curr.key, key)){
					return currNode.curr.value;
				}else{
					currNode = currNode.next;
				}
			}
		}
		return null;
	}



}
