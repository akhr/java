package com.akh.algorithms.dataStructure.tree.bst;

public class MyData implements Comparable<MyData>{

	int value = 0;

	public MyData(int val) {
		this.value = val;
	}

	@Override
	public int compareTo(MyData o) {
		int result;
		if(this.value == o.value){
			result = 0;
		}else if(this.value < o.value){
			result = -1;
		}else{
			result = 1;
		}
//		System.out.println("Comparison returned : "+result+" for this.v = "+this.value+" & o.value="+o.value);
		return result;
	}
}
