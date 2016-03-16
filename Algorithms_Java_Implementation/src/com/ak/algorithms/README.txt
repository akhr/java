Problem statement:

Given an array of n integers, find the sum of the most common integer.

Example: (2,4,5,6,4) – return 8 (as 4+4 = 8) .
(1,2,1,3,1) – return 3 (as 1+1+1 = 3).



Solution:


1. Space Complexity Optimized
   ==========================

  * Each element in the array check with all other elements in the array whether the integer is repeating.

  * Has two for-loops.
         - First for-loops runs 0 to (N-1)
         - Second for loop runs starting with index of first for-loop to (N-1)
         - O(n) * O(n) comparisons  

  * Average case time complexity = O(n^2)

  * Worst case time complexity = O(n^2)

  * Memory: 2*32bytes of extra memory used to store the most common integer value and its count 




2. Time Complexity Optimized
   =========================

  * Every element in the array is stored in a HashMap where the 
       Key = element in the array
       Count = no of occurence of this element in the array

  * Only for-loop that runs from 0 to (N-1) which is O(n)

  * HashMap has constant time complexity O(1) to lookup an element in the hashmap.  
          - O(n) * O(1) = O(n) 

  * Average case time complexity = O(n)

  * Worst case time complexity = O(n)

  * Memory: (Unique Elements in the array)*32bytes * 2(key & value) of extra memory used to store each unique element 
    in the array and its repeating count.  


