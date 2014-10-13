package com.thesaka.algorithms.dataStructure.tree.trie;

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word){
		insert(word.toLowerCase(), root);
	}

	private void insert(String word, TrieNode root){
		char ch = word.charAt(0);
		if(root.links[ch-97] ==  null){
			TrieNode node = new TrieNode();
			node.charac = ch;
			root.links[ch-97] = node;
		}

		if(word.length()>1){
			insert(word.substring(1), root.links[ch-97]);
		}else{
			root.links[ch-97].fullWord = true;
		}
	}

	public boolean search(String word){
		return search(word, root);
	}

	private boolean search(String word, TrieNode root){

		if(word == null || root == null)
			return false;

		char ch = word.charAt(0);
		TrieNode child = root.links[ch-97];

		if(child == null)
			return false;

		if(child.charac == ch){
			if(word.length()<=1 && child.fullWord){
				return true;
			}else if(word.length()<=1 && !child.fullWord){
				return false;
			}else if(word.length()>1)
				return search(word.substring(1), child);
		}
		return false;
	}



	private class TrieNode{
		private char charac;
		private TrieNode[] links;
		private boolean fullWord;

		public TrieNode() {
			links = new TrieNode[26];
			fullWord = false;
		}
	}

}
