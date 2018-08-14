/*
 *  GetSumOfPathEqualToK.java
 *  Author: Akhash Ramamurthy
 *  Created on: Jan 7, 2018
 */

package com.akh.algorithms.dataStructure.tree;

import java.util.Stack;

import org.junit.Test;

import com.akh.algorithms.dataStructure.tree.bst.BinaryTreeNode;

/**
 *  @fileName: GetSumOfPathEqualToK.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jan 7, 2018
 */

/**
 * @author Akhash Ramamurthy
 * Jan 7, 2018
 */
public class GetSumOfPathEqualToK {
	
	Stack<BinNode> stack;
	int sum = 0;
	
	public void getSumOfPathEqualToK(BinNode root, int k){
		stack = new Stack<>();
		findPath(root, k);
		while(!stack.isEmpty()){
			System.out.println(stack.pop().getName());
		}
	}
	
	public void findPath(BinNode node, int k){
		if(node == null)
			return;
		
		stack.push(node);
		sum = sum + node.getData();
		
		if(sum == k){
			return;
		}
		
		if(sum < k){
			findPath((BinNode)node.getLeft(), k);
			findPath((BinNode)node.getRight(), k);
		}else if(sum > k){
			stack.pop();
			sum = sum - node.getData();
		}
		return;
	}
	
	@Test
	public void testFindPath(){
		BinNode a = new BinNode(1, "a");
		BinNode b = new BinNode(3, "b");
		BinNode c = new BinNode(2, "c");
		BinNode d = new BinNode(5, "d");
		BinNode e = new BinNode(2, "e");
		BinNode f = new BinNode(5, "f");
		BinNode g = new BinNode(4, "g");
		BinNode h = new BinNode(12, "h");
		BinNode i = new BinNode(6, "i");
		BinNode j = new BinNode(75, "j");
		BinNode k = new BinNode(0, "k");
		BinNode l = new BinNode(14, "l");
		BinNode m = new BinNode(7, "m");
		BinNode n = new BinNode(9, "n");
		
		a.setLeft(b);
		a.setRight(c);
		
		b.setLeft(d);
		b.setRight(e);
		
		c.setLeft(f);
		c.setRight(g);
		
		d.setLeft(h);
		d.setRight(i);
		
		e.setLeft(j);
		e.setRight(k);
		
		f.setLeft(l);
		f.setRight(m);
		
		g.setLeft(n);
		
		GetSumOfPathEqualToK pathFinder = new GetSumOfPathEqualToK();
		pathFinder.getSumOfPathEqualToK(a, 22);
	}
	
	public class BinNode extends BinaryTreeNode<Integer>{
		String name;
		public BinNode(Integer data, String name) {
			super(data);
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}

}
