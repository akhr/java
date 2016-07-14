package com.ak.algorithms.dataStructure.tree.bst;

import com.ak.utils.Utils;

public class Tester {

	public static void main(String[] args) {
		
		BinarySearchTree<MyData> bst = new BinarySearchTree<MyData>();
		int min = 10;
		int max = 1000;
		int size = 10;
		MyData search = null;
		
//		int[] rands = Utils.intGenerator(size, min, max);
		int[] rands = new int[]{8,4,7,13,1,6,14,3,10,5};
	
		for(int i=0; i<rands.length; i++){
			MyData dataModel = new MyData(rands[i]);
			BinaryTreeNode<MyData> node = new BinaryTreeNode<MyData>(dataModel);
			bst.insert(node);
			if(i==7)
				search = dataModel;
			System.out.println("Inserted Node for Data : "+dataModel.value);
		}
		
		System.out.println("Search Node with Data : "+search.value);
		System.out.println("Search Result : "+bst.search(search));
	}

	

}
