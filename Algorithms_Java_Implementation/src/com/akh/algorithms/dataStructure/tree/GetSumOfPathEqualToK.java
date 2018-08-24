/*
 *  GetSumOfPathEqualToK.java
 *  Author: Akhash Ramamurthy
 *  Created on: Jan 7, 2018
 */

package com.akh.algorithms.dataStructure.tree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Before;
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
	
	public List<BinNode> getPathRecursion(BinNode root, int k){
		List<BinNode> result = new ArrayList<>();
		findPath(root, k, result, 0);
		return result;
	}
	public int findPath(BinNode node, int k, List<BinNode> result, int sumSoFar) {
		if(node == null)
			return 0;
		System.out.println("Visiting Node - "+node.getName()+"  val - "+node.getData());
		
		int newSum = sumSoFar + node.getData();

		if(newSum == k) {
			result.add(node);
			return newSum;
		}

		if(newSum > k) {
			return sumSoFar;
		}

		if(newSum < k) {
			result.add(node);
			int leftPathSum = findPath((BinNode)node.getLeft(), k, result, newSum);
			if(leftPathSum == k) {
				return leftPathSum;
			}
			int rightPathSum = findPath((BinNode)node.getRight(), k, result, newSum);
			if(rightPathSum == k) {
				return rightPathSum;
			}
			result.remove(node);
		}
		return sumSoFar;
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

	private BinNode getTree() {
		BinNode a = new BinNode(1, "a");
		BinNode b = new BinNode(3, "b");
		BinNode c = new BinNode(2, "c");
		BinNode d = new BinNode(5, "d");
		BinNode e = new BinNode(20, "e");
		BinNode f = new BinNode(5, "f");
		BinNode g = new BinNode(4, "g");
		BinNode h = new BinNode(16, "h");
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

		return a;
	}


	@Test
	public void testFindPath_Recursion_1(){
		System.out.println("Recusion Impl....");
		BinNode root = getTree();
		String[] expecteds = {"a","c","f","l"};
		GetSumOfPathEqualToK pathFinder = new GetSumOfPathEqualToK();
		List<BinNode> result = pathFinder.getPathRecursion(root, 22);
		String[] actuals = new String[result.size()];
		for(int i =0; i<result.size(); i++){
			System.out.println(result.get(i).getName()+"  val - "+result.get(i).getData());
			actuals[i] = result.get(i).getName();
		}
		assertEquals("Compare Arrays Length",expecteds.length, actuals.length);
		assertArrayEquals("Compare Arrays", expecteds, actuals);
	}
	
	@Test
	public void testFindPath_Recursion_2(){
		System.out.println("Recusion Impl....");
		BinNode root = getTree();
		String[] expecteds = {};
		GetSumOfPathEqualToK pathFinder = new GetSumOfPathEqualToK();
		List<BinNode> result = pathFinder.getPathRecursion(root, 6);
		String[] actuals = new String[result.size()];
		for(int i=0; i<result.size(); i++){
			System.out.println(result.get(i).getName()+"  val - "+result.get(i).getData());
			actuals[i] = result.get(i).getName();
		}
		assertEquals("Compare Arrays Length",expecteds.length, actuals.length);
		assertArrayEquals("Compare Arrays", expecteds, actuals);
	}
	
	@Test
	public void testFindPath_Recursion_No_Branch_b(){
		System.out.println("Recusion Impl....");

		BinNode a = new BinNode(1, "a");
		BinNode b = new BinNode(3, "b");
		BinNode c = new BinNode(2, "c");
		BinNode d = new BinNode(5, "d");
		BinNode e = new BinNode(20, "e");
		BinNode f = new BinNode(5, "f");
		BinNode g = new BinNode(4, "g");
		BinNode h = new BinNode(16, "h");
		BinNode i = new BinNode(6, "i");
		BinNode j = new BinNode(75, "j");
		BinNode k = new BinNode(0, "k");
		BinNode l = new BinNode(14, "l");
		BinNode m = new BinNode(7, "m");
		BinNode n = new BinNode(9, "n");

		a.setLeft(b);
		a.setRight(c);

		//b.setLeft(d);
		b.setRight(e);

		c.setLeft(f);
		c.setRight(g);

		//d.setLeft(h);
		//d.setRight(i);

		e.setLeft(j);
		e.setRight(k);

		f.setLeft(l);
		f.setRight(m);

		g.setLeft(n);

		
		String[] expecteds = {"a", "c", "f", "m"};
		GetSumOfPathEqualToK pathFinder = new GetSumOfPathEqualToK();
		List<BinNode> result = pathFinder.getPathRecursion(a, 15);
		String[] actuals = new String[result.size()];
		
		for(int i1 = 0; i1<result.size(); i1++){
			System.out.println(result.get(i1).getName()+"  val - "+result.get(i1).getData());
			actuals[i1] = result.get(i1).getName();
		}
		assertEquals("Compare Arrays Length",expecteds.length, actuals.length);
		assertArrayEquals("Compare Arrays", expecteds, actuals);
	}

}
