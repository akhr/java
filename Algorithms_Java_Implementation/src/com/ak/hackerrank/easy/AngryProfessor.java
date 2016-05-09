/**
 * 
 */
package com.ak.hackerrank.easy;

import java.util.Scanner;

/**
 * @author Akhash Ramamurthy
 *
 * Feb 18, 2016 5:03:59 PM
 * AngryProfessor.java
 */
public class AngryProfessor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		//For each test case
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int k = in.nextInt();
			int studentsOnTime = 0;

			int a[] = new int[n];
			for(int a_i=0; a_i < n; a_i++){
				a[a_i] = in.nextInt();
				if(a[a_i] <= 0)
					studentsOnTime++;
				if(studentsOnTime >= k){
					System.out.println("NO");
					break;
				}
			}
			if(studentsOnTime < k)
				System.out.println("YES");
		}
	}
}


/**
 *
A Discrete Mathematics professor has a class of NN students. Frustrated with their lack of discipline, he decides to cancel class if fewer than KK students are present when class starts.

Given the arrival time of each student, determine if the class is canceled.

Input Format

The first line of input contains TT, the number of test cases.

Each test case consists of two lines. The first line has two space-separated integers, NN (students in the class) and KK (the cancelation threshold). 
The second line contains NN space-separated integers (a1,a2,…,aNa1,a2,…,aN) describing the arrival times for each student.

Note: Non-positive arrival times (ai≤0ai≤0) indicate the student arrived early or on time; positive arrival times (ai>0ai>0) indicate the student arrived aiai minutes late.

Output Format

For each test case, print the word YES if the class is canceled or NO if it is not.

Constraints

1≤T≤101≤T≤10
1≤N≤10001≤N≤1000
1≤K≤N1≤K≤N
−100≤ai≤100,where i∈[1,N]−100≤ai≤100,where i∈[1,N]
Note 
If a student arrives exactly on time (ai=0)(ai=0), the student is considered to have entered before the class started.

Sample Input

2
4 3
-1 -3 4 2
4 2
0 -1 2 1
Sample Output

YES
NO
 **/
