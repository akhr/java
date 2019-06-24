package com.akh.aa.mudField;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * @fileName: Contest_2.java
 * @author: Akhash Ramamurthy Created on: Oct 27, 2018
 */

public class Contest_2 {

	public int numSubarraysWithSum(int[] A, int S) {
		int left = 0;
		int sum = 0;
		int count = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];

			if (sum == S) {
				count++;
				continue;
			}

			while (sum >= S && left < A.length) {
				sum -= A[left++];
				if (sum == S) {
					count++;
				}
			}
		}
		return count;
	}

	public int numSubarraysWithSum_2(int[] A, int k) {
		if(A == null || A.length <=0)
			return 0;

		int sum = 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for(int i=0; i<A.length; i++) {
			sum += A[i];

			if(sum == k) {
				count++;
			}

			int diff = sum - k;
			if(map.containsKey(diff)) {  
				count += map.getOrDefault(diff, 0);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	@Test
	public void test_1() {
		int[] A = { 1, 0, 1, 0, 1 };
		int S = 2;
		assertEquals(4, numSubarraysWithSum_2(A, S));
	}

	@Test
	public void test_2() {
		int[] A = { 0, 0, 0, 0, 0 };
		int S = 0;
		assertEquals(15, numSubarraysWithSum_2(A, S));
	}







	public int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		String at = "@";
		for (String email : emails) {
			if (email == null || email.length() <= 0)
				continue;
			if (email.indexOf('@') != email.lastIndexOf('@'))
				continue;

			String user = "";
			String domain = email.substring(email.indexOf('@') + 1, email.length());
			if (email.contains("+")) {
				user = email.substring(0, email.indexOf("+"));
			}
			if (user.contains(".")) {
				user = user.replace(".", "");
			}
			set.add(user + at + domain);
		}

		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println("-- " + it.next());
		}
		return set.size();
	}

	@Test
	public void test_101() {
		String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
		"testemail+david@lee.tcode.com" };
		int out = 2;
		assertEquals(out, numUniqueEmails(emails));
	}

	@Test
	public void test_102() {
		String[] emails = { "test.email+alex@leetcode.com", "test.e.ma++il+bob.cathy@leetcode.com",
		"testemail+david@lee.tcode.com" };
		int out = 2;
		assertEquals(out, numUniqueEmails(emails));
	}






	public int minFallingPathSum(int[][] A) {

		int[] minSum = { Integer.MAX_VALUE };
		Container container = new Container(A);

		dfs(A, 0, container, minSum);

		return minSum[0];
	}

	private void dfs(int[][] A, int row, Container container, int[] minSum) {
		if (row == A.length) {
			System.out.println("@ Leaf MinSum Before : "+minSum[0]);
			minSum[0] = Math.min(minSum[0], container.sum);
			System.out.println("@ Leaf MinSum After : "+minSum[0]);
			return;
		}

		Cell lastPos = container.getLastAddedCell();
		if(lastPos == null){
			for (int col = 0; col < A[0].length; col++) {
				container.addCell(row, 0);
				dfs(A, row + 1, container, minSum);
				container.removeLastAddedCell();
			}
		} else{
			int left = lastPos.col - 1;
			left = (left < 0) ? 0 : left;

			int right = lastPos.col + 1;
			right = (right > A[0].length-1) ? A[0].length-1 : right;

			System.out.println("row: "+row+" --> Left "+left+"  Right : "+right);
			for (int col = left; col < right; col++) {
				//				if(Math.abs(col - lastPos.col) <= 1) {
				container.addCell(row, col);
				dfs(A, row + 1, container, minSum);
				container.removeLastAddedCell();
				//				}
			}
		}
	}

	public static class Container {
		private int[][] input;
		private List<Cell> list = new ArrayList<>();
		private int sum = 0;

		public Container(int[][] data) {
			this.input = data;
		}

		public List<Cell> getTempList() {
			return this.list;
		}

		public void addCell(int row, int col) {
			Cell newPos = new Cell(row, col );
			this.list.add(newPos);
			addToSum(input[row][col]);
		}

		public Cell getLastAddedCell() {
			if(this.list.size() >= 1){
				return this.list.get(this.list.size() - 1);
			}else{
				return null;
			}
		}

		public void removeLastAddedCell() {
			Cell cell = this.list.get(this.list.size() - 1);
			this.list.remove(this.list.size() - 1);
			removeLastSum(cell.row, cell.col);
		}

		public int getSum() {
			return this.sum;
		}

		private void addToSum(int val) {
			this.sum += val;
		}

		private void removeLastSum(int row, int col) {
			this.sum -= input[row][col];
		}
	}

	public static class Cell{
		int row;
		int col;

		Cell(int row, int col){
			this.row = row;
			this.col = col;
		}
	}

	@Test
	public void test_201() {
		int[][] A = { {1,2,3},{4,5,6},{7,8,9} };
		int expected = 12;
		assertEquals(expected, minFallingPathSum(A));
	}

	@Test
	public void test_202() {
		int[][] A = { {17,82},{1,-44} };
		int expected = -27;
		assertEquals(expected, minFallingPathSum(A));
	}


	@Test
	public void test_203() {
		int[][] A = { 
				{-19,-1,-96,48,-94,36,16,55,-42,37,-59,6,-32,96,95,-58,13,-34,94,85},
				{17,44,36,-29,84,80,-34,50,-99,64,13,91,-27,25,-36,57,20,98,-100,-72},
				{-92,-75,86,90,-4,90,64,56,50,-63,10,-15,90,-66,-66,32,-69,-78,1,60},
				{21,51,-47,-43,-14,99,44,90,8,11,99,-62,57,59,69,50,-69,32,85,13},
				{-28,90,12,-18,23,61,-55,-97,6,89,36,26,26,-1,46,-50,79,-45,89,86},
				{-85,-10,49,-10,2,62,41,92,-67,85,86,27,89,-50,77,55,22,-82,-94,-98},
				{-50,53,-23,55,25,-22,76,-93,-7,66,-75,42,-35,-96,-5,4,-92,13,-31,-100},
				{-62,-78,8,-92,86,69,90,-37,81,97,53,-45,34,19,-19,-39,-88,-75,-74,-4},
				{29,53,-91,65,-92,11,49,26,90,-31,17,-84,12,63,-60,-48,40,-49,-48,88},
				{100,-69,80,11,-93,17,28,-94,52,64,-86,30,-9,-53,-8,-68,-33,31,-5,11},
				{9,64,-31,63,-84,-15,-30,-10,67,2,98,73,-77,-37,-96,47,-97,78,-62,-17},
				{-88,-38,-22,-90,54,42,-29,67,-85,-90,-29,81,52,35,13,61,-18,-94,61,-62},
				{-23,-29,-76,-30,-65,23,31,-98,-9,11,75,-1,-84,-90,73,58,72,-48,30,-81},
				{66,-33,91,-6,-94,82,25,-43,-93,-25,-69,10,-71,-65,85,28,-52,76,25,90},
				{-3,78,36,-92,-52,-44,-66,-53,-55,76,-7,76,-73,13,-98,86,-99,-22,61,100},
				{-97,65,2,-93,56,-78,22,56,35,-24,-95,-13,83,-34,-51,-73,2,7,-86,-19},
				{32,94,-14,-13,-6,-55,-21,29,-21,16,67,100,77,-26,-96,22,-5,-53,-92,-36},
				{60,93,-79,76,-91,43,-95,-16,74,-21,85,43,21,-68,-32,-18,18,100,-43,1},
				{87,-31,26,53,26,51,-61,92,-65,17,-41,27,-42,-14,37,-46,46,-31,-74,23},
				{-67,-14,-20,-85,42,36,56,9,11,-66,-59,-55,5,64,-29,77,47,44,-33,-77}
		};
		int expected = 12;
		assertEquals(expected, minFallingPathSum(A));
	}
}
