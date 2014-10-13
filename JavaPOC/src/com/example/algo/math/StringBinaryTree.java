package com.example.algo.math;

public class StringBinaryTree {
	
	/**
	 * Consider this string representation for binary trees. Each node is of the form (lr), where l represents the left child and r represents the right child. If l is the character 0, then there is no left child. Similarly, if r is the character 0, then there is no right child. Otherwise, the child can be a node of the form (lr), and the representation continues recursively.
		For example: (00) is a tree that consists of one node. ((00)0) is a two-node tree in which the root has a left child, and the left child is a leaf. And ((00)(00)) is a three-node tree, with a root, a left and a right child.
		
		Write a function that takes as input such a string, and returns -1 if the string is malformed, and the depth of the tree if the string is well-formed.
		
		For instance:
		
		find_depth('(00)') -> 0
		find_depth('((00)0)') -> 1
		find_depth('((00)(00))') -> 1
		find_depth('((00)(0(00)))') -> 2
		find_depth('((00)(0(0(00))))') -> 3
		find_depth('x') -> -1
		find_depth('0') -> -1
		find_depth('()') -> -1
		find_depth('(0)') -> -1
		find_depth('(00)x') -> -1
		find_depth('(0p)') -> -1
	*
	*	http://www.careercup.com/question?id=13262681
	*
	*/


	public static int findDepth( String s )
		{
		    int countLeft = 0;
		    int countLeftTotal = 0;
		    int countZero = 0;
		    int depth = -1; // countLeft - 1
		    for( int i = 0; i < s.length(); i++)
		    {
		        char a = s.charAt( i );
		        switch( a ){
		        case '0':	countZero++; break;
		        case '(':	{ 	countLeft++; countLeftTotal++; }; break;
		        case ')':	{ if( depth < countLeft - 1 )
		        				depth = countLeft - 1;
		        				countLeft = 1;
		        	};break;
		        default: return -1;
		        }
		       /* if( a == '(' )
		            countLeft++;
		        else if( a == ')' && depth < ( countLeft - 1 ) )
		        {
		            depth = countLeft - 1;
		            countLeft = 1;
		        }
		        else if( a != '0' )
		        	return -1;*/
		    }
		    if( countZero == countLeftTotal + 1 )
		    	return depth;
		    else 
		    	return -1;
		}
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			String s1 = "(00)";     		//0
			String s2 = "((00)0)"; 			// 1
			String s3 = "((00)(00))"; 		// 1
			String s4 = "((00)(0(00)))";	// -> 2
			String s5 = "((00)(0(0(00))))";	// -> 3
			String s6 = "x";				// -> -1
			String s7 = "0";				// -> -1
			String s8 = "()"; 				// -> -1
			String s9 = "(0)";				// -> -1
			String s10 = "(00)x";			// -> -1
			String s11 = "(0p)";			// -> -1*/
			
			System.out.println("(00) = " + findDepth(s1));
			System.out.println("((00)0) ="+ findDepth(s2));
			System.out.println("((00)(00)) ="+ findDepth(s3));
			System.out.println("((00)(0(00))) ="+ findDepth(s4));
			System.out.println("((00)(0(0(00)))) ="+ findDepth(s5));
			System.out.println("x ="+ findDepth(s6));
			System.out.println("0 ="+ findDepth(s7));
			System.out.println("() ="+ findDepth(s8));
			System.out.println("(0) ="+ findDepth(s9));
			System.out.println("(00)x ="+ findDepth(s10));
			System.out.println("(0p) ="+ findDepth(s11));
	}
	}