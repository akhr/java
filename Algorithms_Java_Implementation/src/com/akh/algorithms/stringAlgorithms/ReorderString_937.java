package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;


public class ReorderString_937 {
	
	public class LetterLogComparator implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			String[] o1Arr = o1.split(" ");
			String[] o2Arr = o2.split(" ");
			if(Character.isDigit(o1Arr[1].charAt(0)) && Character.isDigit(o2Arr[1].charAt(0))) {
				return 0;
			}
			if(Character.isDigit(o1Arr[1].charAt(0))) {
				return 1;
			}
			if(Character.isDigit(o2Arr[1].charAt(0))) {
				return -1;
			}

			int compareRes = o1Arr[1].compareTo(o2Arr[1]);
			if(compareRes == 0) {
				return o2Arr[0].compareTo(o1Arr[0]);
			}
			return compareRes;
		}
	}

	public String[] reorderLogFiles(String[] logs) {
		LetterLogComparator comparator = new LetterLogComparator();
		String[] temp = Arrays.copyOf(logs, logs.length);
		Arrays.sort(temp, comparator);
		return temp;
	}

	@Test
	public void test_1() {
		String[] arr = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
		String[] exp = {"g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"};
		assertArrayEquals(exp, reorderLogFiles(arr)); 
	}
}
