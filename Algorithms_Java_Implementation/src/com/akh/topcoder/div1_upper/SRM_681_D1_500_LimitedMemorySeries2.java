/**
 * 
 */
package com.akh.topcoder.div1_upper;

/**
 * @author Akhash Ramamurthy
 *
 *         Feb 17, 2016 12:54:26 PM SRM_681_D1_500_LimitedMemorySeries2.java
 */
public class SRM_681_D1_500_LimitedMemorySeries2 {

	public static void main(String[] args) {
		System.out.println("Result for n=6,x0=2,a=23,b=1 ==> "+getSum(6,2,23,1));
		System.out.println("Result for n=100,x0=0,a=0,b=1 ==> "+getSum(100,0,0,1));
	}

	public static int getSum(int n, long x0, long a, long b) {
		int totalRadii = 0;
		long prevElement = x0;
		for (int index = 1; index < n - 1; index++) {
			long currElement = getSeriesElement(index, a, b, prevElement);
			long prev = x0;
			long curr;
			int maxRadii = (index <= n/2) ? index : (n-1)-index;
			for(int radiiIndex=0; radiiIndex <= index+maxRadii; radiiIndex++){

				if(radiiIndex == 0){
					curr = x0;
				}else {
					curr = getSeriesElement(radiiIndex, a, b, prev);
				}

				if((radiiIndex != index) && ((radiiIndex >= index - maxRadii) || (radiiIndex <= index + maxRadii))){
					if(curr >= currElement){
						maxRadii = Math.abs(index - radiiIndex)-1;
					}else{
						maxRadii = Math.abs(index - radiiIndex);
					}

				}

				prev = curr;
			}
			/*System.out.println("**********************");
			System.out.println("Adding to Total Radii");
			System.out.println("TotalRadii before = "+totalRadii);
			System.out.println("Current Element from Array = "+currElement);
			System.out.println("Index = "+index);
			System.out.println("maxRadii = "+maxRadii);*/
			totalRadii += maxRadii;
			/*System.out.println("TotalRadii after = "+totalRadii);
			System.out.println("**********************");*/
			prevElement = currElement;
		}
		return (int)totalRadii%1000000007;
	}


	public static long getSeriesElement(int index, long a, long b, long prevElement) {
		long element;
		if (index < 1)
			element = prevElement;
		else
			element = ((prevElement ^ a) + b) & ((long) Math.pow(2, 50) - 1);
		return element;
	}

}

/**
 *
 * 
Problem Statement
    	
    	Due to some infrastructure limits the memory limit is set to 13 MB. Note that this should correspond to an actual memory limit of only 1 MB. If your solution allocates more than 1 MB of memory, it may exceed the memory limit.
You are given an array X[0..n-1] of integers. For each i between 0 and n-1, inclusive, the radius of element i is the largest k with the following properties:

Both i-k and i+k are valid indices into the array. That is, i-k >= 0 and i+k < n.
The value X[i] is the strict maximum among the values X[i-k], X[i-k+1], ..., X[i+k]. (Here, "strict" means that the values at all other indices must be strictly smaller.)
For example, in the array X = {4,4,4,4,4} the radius of each element is 0, and in the array X = {10,20,30,20} the radius of element 2 (0-based index) is 1.

Your task is to find the radius of each element of X and to compute the sum of all those radii. Right now, this seems like a fairly standard problem. Here's the catch: the memory limit in this problem is really small. So small that you cannot even store the array X into memory.

You are given the int n and the longs x0, a, and b. Use the following pseudocode to generate the array X:

X[0] = x0
for i = 1 to n-1:
        X[i] = ((X[i-1] XOR a) + b) AND ((2^50) - 1)
In the above pseudocode, XOR and AND are the standard operators "bitwise xor" and "bitwise and".

Return the sum of radii of all elements of X, modulo 1,000,000,007.

 
Definition
    	
Class:	LimitedMemorySeries2
Method:	getSum
Parameters:	int, long, long, long
Returns:	int
Method signature:	int getSum(int n, long x0, long a, long b)
(be sure your method is public)
    
 
Constraints
-	n will be between 1 and 10,000,000, inclusive.
-	x0, a and b will be between 0 and 2^50-1, inclusive.
 
Examples
0)	
    	
6
2
23
1
Returns: 2
In this case, the generated array is X = {2,22,2,22,2,22}. The radii of its elements are {0,1,0,1,0,0}. The correct return value is 0+1+0+1+0+0 = 2.
1)	
    	
100
0
0
1
Returns: 0
Here, the generated array is {0,1,...,99}. The radius of each element is zero, so the answer is zero in this case.
2)	
    	
234234
1125899906842623
123456789123456
987654321549687
Returns: 1144970
Don't forget, the answer is modulo 1,000,000,007.
3)	
    	
10000000
12345678912345
98765094309812
34893049812392
Returns: 65420804
It is highly recommended to test this example in the arena before submitting.

 * 
 **/
