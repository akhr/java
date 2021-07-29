package quick.test;

import java.util.ArrayList;
import java.util.List;

public class Pancake {

	public static void main(String[] args) {
		ArrayList<Integer> pancakes = new ArrayList<Integer>();
		pancakes.add(2);
		pancakes.add(7);
		pancakes.add(5);
		pancakes.add(1);
		pancakes.add(4);
		pancakes.add(2);
		pancakes.add(3);
		pancakes.add(6);
		System.out.println(pancakes);
		sortPancakes(pancakes);
		System.out.println(pancakes);
	}
	public static void sortPancakes(List<Integer> pancakes)
	{
		int toBeSorted = pancakes.size()-1;
		for(int i = 0; i<pancakes.size(); i++){
			toBeSorted = pancakes.size()-1-i;
			int maxPos = maxPosition(pancakes, 0, toBeSorted);
			flip(pancakes, maxPos);
			print(pancakes);
			flip(pancakes, toBeSorted);
			print(pancakes);
		}
	}


	private static int maxPosition(List<Integer> pancakes, int left, int right) {
		int maxPos = left;
		for(int pos=left+1; pos<=right; pos++){
			if(pancakes.get(pos) > pancakes.get(maxPos)) maxPos = pos;
		}
		return maxPos;
	}  
	public static void flip(List<Integer> pancakes, int indexToStartFlip)
	{
		int left = 0, right = indexToStartFlip;
		while(left < right){
			int temp = pancakes.get(left);
			pancakes.set(left, pancakes.get(right));
			pancakes.set(right, temp);
			left++;
			right--;
		}
	}

	private static void print(List<Integer> list){
		for(Integer i : list){
			System.out.print(i);
		}
		System.out.println();
	}
}
