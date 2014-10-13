package com.thesaka.topcoder.div1;

import java.util.Arrays;
import java.util.Comparator;

public class CatchTheBeat {

	public CatchTheBeat() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] p0;
		int[] p1;
		String p2;
		
		p0 = new int[]{-1,1,0};
		p1 = new int[]{1,3,4};
		p2 = "Able to catch";
		System.out.println("Actual Soln = "+p2);
		System.out.println("MY Soln = "+ableToCatchAll_other(p0,p1));
		System.out.println("\n");
		
		p0 = new int[]{-3};
		p1 = new int[]{2};
		p2 = "Not able to catch";
		System.out.println("Actual Soln = "+p2);
		System.out.println("MY Soln = "+ableToCatchAll(p0,p1));
		System.out.println("\n");
		
		p0 = new int[]{-1,1,0};
		p1 = new int[]{1,2,4};
		p2 = "Not able to catch";
		System.out.println("Actual Soln = "+p2);
		System.out.println("MY Soln = "+ableToCatchAll(p0,p1));
		System.out.println("\n");
		
		p0 = new int[]{0,-1,1};
		p1 = new int[]{9,1,3};
		p2 = "Able to catch";
		System.out.println("Actual Soln = "+p2);
		System.out.println("MY Soln = "+ableToCatchAll(p0,p1));
		System.out.println("\n");
		
		p0 = new int[]{70,-108,52,-70,84,-29,66,-33};
		p1 = new int[]{141,299,402,280,28,363,427,232};
		p2 = "Not able to catch";
		System.out.println("Actual Soln = "+p2);
		System.out.println("MY Soln = "+ableToCatchAll(p0,p1));
		System.out.println("\n");
		
		p0 = new int[]{-175,-28,-207,-29,-43,-183,-175,-112,-183,-31,-25,-66,-114,-116,-66};
		p1 = new int[]{320,107,379,72,126,445,318,255,445,62,52,184,247,245,185};
		p2 = "Able to catch";
		System.out.println("Actual Soln = "+p2);
		System.out.println("MY Soln = "+ableToCatchAll(p0,p1));
		System.out.println("\n");
		
		p0 = new int[]{0,0,0,0};
		p1 = new int[]{0,0,0,0};
		p2 = "Able to catch";
		System.out.println("Actual Soln = "+p2);
		System.out.println("MY Soln = "+ableToCatchAll(p0,p1));
		System.out.println("\n");
		
	}

	public static String ableToCatchAll(int[] x, int[] y)
	{
		int totalSteps = 0;
		int currXPos = 0;
		int timeAvailable = 0;

		for(int i=0; i<x.length; i++){
			int indexToCatch = getSmallestY(y);
			timeAvailable = y[indexToCatch] - totalSteps;
			
			if(timeAvailable < 0)
				return "Not able to catch";
				
			int destinationLoc = x[indexToCatch];
			int stepsRequired = Math.max(currXPos, destinationLoc) - Math.min(currXPos, destinationLoc);
			totalSteps += stepsRequired;
			if(stepsRequired <= timeAvailable){
				currXPos = x[indexToCatch];
				x[indexToCatch] = Integer.MAX_VALUE;
				y[indexToCatch] = Integer.MAX_VALUE;
				continue;
			}else
				return "Not able to catch";
		}
		return "Able to catch";
	}

	private static int getSmallestY(int[] y){
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i=0; i< y.length; i++){
			if(min>y[i]){
				min = y[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	
	
	// Other solution for TopCoder
	
	public static String ableToCatchAll_other(int[] x, int[] y)
	{
		final int n =x.length;
		final int[][] pair = new int[n][2];
		
		for(int i=0; i<n; i++){
			pair[i][0] = x[i];
			pair[i][1] = y[i];
		}

		Arrays.sort(pair, comparator);
		
		int currLoc = 0;
		int time = 0;
		for (int i = 0; i < n; i++) {
			if(time + Math.abs(pair[i][0] - currLoc) > pair[i][1]){
				return "Not able to catch";
			}
			time = pair[i][i];
			currLoc = pair[i][0];
		}
		return "Able to catch";
	}
	
	private static Comparator<int[]> comparator = new Comparator<int[]>() {

		@Override
		public int compare(int[] a, int[] b) {
			return a[1] - b[1];
		}
		
	}; 

}






