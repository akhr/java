package com.thesaka.eg.genericsTest;

public class GenericMethodReturnTypeTest {
	 // determines the largest of three Comparable objects
	   public static <T extends Comparable<T>> T maximum(T x, T y, T z)
	   {                      
	      T max = x; // assume x is initially the largest       
	      if ( y.compareTo( max ) > 0 ){
	         max = y; // y is the largest so far
	      }
	      if ( z.compareTo( max ) > 0 ){
	         max = z; // z is the largest now                 
	      }
	      return max; // returns the largest object   
	   }
	   public static void main( String args[] )
	   {
		   int a = 0;
		   int b = 4;
		   int c = 5;
   
		   
	      System.out.printf( "Max of %d, %d and %d is %d\n\n", 
	                   a, b, c, maximum( a, b, c ) );

	       System.out.printf( "Maxm of %.1f,%.1f and %.1f is %.1f\n\n",
	                   6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

	       System.out.printf( "Max of %s, %s and %s is %s\n","pear",
	         "apple", "orange", maximum( "pear", "apple", "orange" ) );
	       
//	       System.out.printf( "Max of %s, %s and %s is %s\n","pear",
//	  	         "apple", "orange", maximum( new ObjectType1(), new ObjectType2(), new ObjectType3() ) );
	   }
	   
	   private class ObjectType1{};
	   private class ObjectType2{};
	   private class ObjectType3{};
	   
}
