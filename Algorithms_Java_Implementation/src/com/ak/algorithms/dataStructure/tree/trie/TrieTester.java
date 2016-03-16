package com.thesaka.algorithms.dataStructure.tree.trie;

public class TrieTester {

	public TrieTester() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("app");
		trie.insert("apple");
		System.out.println("Search \"APP\" = "+trie.search("app"));
		System.out.println("Search \"APPLE\" = "+trie.search("apple"));
		System.out.println("Search \"APPLES\" = "+trie.search("apples"));
		System.out.println("Search \"ORANGE\" = "+trie.search("orange"));
	}

}
