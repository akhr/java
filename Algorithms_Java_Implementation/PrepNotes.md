# Preparation Nodes

## Topics to Prepare
- Algorithms / Sanjoy Dasgupta, Christos Papadimitriou, Umesh Vazirani.
- Learn simple topics for leet code:
- Binary search
- hashing, 
- bfs, 
- dfs, 
- union find → very interesting - Quick Intro Video - https://www.youtube.com/watch?v=YB3_c11GPEo 
- tree traversal: inorder, pre and post order, 
- graph: shortest path
- Topological sort, 
- trie,
- Linked list, 
- tree map in java
- Recursion, 
- dynamic programming 
- Backtracking
- Divide and conquer, 
- merge sort
- Priority queue, 
- stack, 
- queue
- Most probs comes under this topics 
- Master this u can crack any company
- Algorithms book site by Robert sedgewick has awesome java code
- Download code from this site
- Solve prob in leet code then look at discuss section to see top voted prob solution to learn 


## Techniques to Learn
- Sliding Window 
- Expand and Shrink Window
- Slide the window
- BFS - Visiting nodes of a tree level-wise
- If sorted array - Have two pointers left and right and move inwards



## Difference between SubString and SubSequence
- Input: "pwwkew"
- "pwke" is a subsequence and not a substring.
- "pwwke" is a subString (NO SKIPPING)



## Array: Find Min or Max of something.
- Maintain a variable minVar or maxVar
- Definitely need to use Math.min or max.
- Need to compare two results. one with considering a condition and one without considering the condition
- minVar = Math.min(result1, result2)
- Initialization
	- To find min --> minVar = Integer.MAX_VALUE
    - To find max --> maxVar = Integer.MIN_VALUE
    	- Eg: LongestIncreasingSequence
        - MaxProfitFromAStock
        - CheckIfArrayIsIncreasingSquence
        - MinimumStepsToOne
        - DeleteMinCharsToMakeStringPalindrome


## Math: Number Problems
- To get digits from given num - 109283 --> [1,0,9,2,8,3]
          ```
          while(num > 0){
                      int quotient = num / 10;
                      int reminder = num % 10;
                      digitsArr[reminder] += 1;
                      num = quotient;
           }
           ```
- Digits problem... There are only 0-9 digits. So use an int[10] array


## Tree
- Check ./Tree_PrepNotes.md


## Array: Check if sum adds to k
- A + B = C
- A + B + C = D
- A + B + C = 0
- a^3 + b^3 + c^3 = d^3
- Method
a. For a+b=c 
     	1. Sort array
     	2. Left pointer (a) and Right Pointer (b)
     	3. Check sum < || = || > c
     	4. Move a and b inwards based on step 3
	b. For a+b+c=d
     	1. Sort array
     	2. Choose a (for I=0 —> Len-1)
     	3. Left pointer (b) and Right Pointer (c)
     	4. Check sum < || = || > d
     	5. Move b and c inwards based on step 3
	c. Same for a+b+c=0 
	d. Same for a^3 + b^3 + c^3 = d^3 


## Array: Maximum Sum SubArray
- Kadane’s algorithm
	1. Have var maxSum and tempSum
	2. Loop thro array add new item to tempSum
	3. If tempSum > maxSum update maxSum
	4. If tempSum < 0 then it means we encountered -ve item… so lets restart tempSum and try to find new Subarray… while until that point maxSum is stored
	5. Repeat from steps 3


## Array: Longest Increasing SubSequence
- Prob 1 : 
	- Return only count of items that will from a longest increasing subsequence (LIS)
	- Form new LIS array
	- Use BinarySearch to find the position where to insert/replace-old-with new item read from input arr.
	- Always retain the lower item and replace the bigger item
	- Because of chances of find a longer sequence is higher when smaller item is retained
- Prob 2 : 
	- Return the LIS subarray itself
	- Create List<List<Integer>>
		1. Take a new item from input arr.
		2. If A[i] is smallest among all end candidates of active lists, we will start new active list of length 1.
		3. If A[i] is largest among all end candidates of active lists, we will clone the largest active list, and extend it by A[i].
		4. If A[i] is in between, we will find a list with largest end element that is smaller than A[i]. Clone and extend this list by A[i]. We will discard all other lists of same length as that of this modified list.
	- https://stackoverflow.com/questions/6129682/longest-increasing-subsequenceonlogn


## Array: Matrix (m*n)
  Spiral
      Define
            top=0  
            left=0
            bottom=n-1
            right=n-1
      Define 4 walk directions
            LTR
            TTB
            RTL
            BTT
      Walk through a LTR
            Start with dir = LTR
            Keep i constant and iterate j (left to right)
            Shrink top by one column… top ++ ;
            Dir = TTB
      Walk through a TTB
            Keep j constant and iterate I (top to bottom)
            Shrink right by one column… right - - ;
            Dir = RTL
      And so on…


Binary Tree: To Doubly link list
     Use Bfs to convert the BT to linked list
     Use Inorder traversal for converting BT to Linked list
     


Binary Tree: Height (max depth)
    Height equal to one plus number of edges on the longest path from root to leaf
    
        Recursive call
        function ( p)
           if( p == null )
                return zero
           int left = fucntion(p.left)
            int right  = fucntion (p.right)

          if( left > right)
             int h = left +1
          else
             int h = right +1
             return h;


 Binary Tree: Path sum = k
   
   define a variable sum and initialize to zero
   define a stack with either of type integer or type node
   
  
       function traverse(Node root)
         {
             if root equals null 
                return;

             sum = sum + root.data;
             stack.push(root)

             if( sum == k )
                print stack

             traverse(root.left);

             traverse(root.right)


             sum = sum - root.data;
             stack.pop()
         }


Binary Tree: Traverse Skeleton (Not BST)
	
      public boolean search(TreeNode root, int search) {
        if(root == null) return false;
        if(root.val == search) return true;
        return search(root.left, search) || search(root.right, search)
      }

      Check NULL
      If NOT NULL check the condition (search, lowest common ancestor, sumPath etc)
      If not satisfied then 
            leftResult = Recurse - Go left
            rightResult = Recurse - Go right
      Return leftResult || rightResult



Array: Prefix Sum Array

      for( i  1 → len-1)
        arr[i] =  arr[ i ] + arr[ i-1 ];
      Arr[i] carries the sum of all the items before i i.e., i-1 + itself
      


 
Array: Sliding Window
 
      sum = 0;
      startIndex = 0;
      while( i < arr.length)
      {
         //Window expands
         while(sum < target){  
           sum += arr[i];
           i++;
         }

         //shrink window
         while(sum > target){
           sum -= arr[startIndex++];
         }

      }

String: Sliding Window - 
	1. Check out /Algorithms_Java_Implementation/src/com/akh/algorithms/stringAlgorithms/slidingWindow/00_IMP_README.txt 
	2. Understand the template used below


LC76

    public String minWindow(String s, String t) {

        Map<Character, Integer> needToFind = new HashMap<>();

        for(char c : t.toCharArray()) {
          //Load target chars into MAP
        }


        // REQUIRED chars count
        int reqCharsCount = 0;
        int minLen = Integer.MAX_VALUE;
        int minLenIndx = 0;
        int left, right;
        left = right = 0;


        //Window EXPAND
        while(right < s.length()) {
            char expandChar = s.charAt(right);
            if(needToFind.containsKey(expandChar)) {
              if(needToFind.get(expandChar) > 0){ 
                // One valid char found
                reqCharsCount++;
              }
              //If more than required then MAP val will be negative. STARRED_STEP 1
              needToFind.put(expandChar, needToFind.get(expandChar)-1); 
        }
        /** At end of this step MAP val shd be 
         * 		-	'0' for required and found exact count 
         * 		-	'-ve' for required and found extra count
         */


        //WINDOW SHRINK
        while(left <= right && reqCharsCount == t.length()) {
              //Calculate the min window length
              if(minLen > right-left+1) {
                minLen = Math.min(minLen, right-left+1);
                minLenIndx = left;
              }

              char shrinkChar = s.charAt(left);
              if(needToFind.containsKey(shrinkChar)) {
                if(needToFind.get(shrinkChar) == 0) {
                  // One valid char lost
                  reqCharsCount--;
                }
                // Reverse of STARRED_STEP 1
                // If extra count then Map.value will incr from negative towards 0
                needToFind.put(shrinkChar, needToFind.get(shrinkChar)+1);
              }
              left++;
            }
            //Do at the bottom. Or else will mess up minLen calculation
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLenIndx, minLenIndx+minLen);
  }

Array: Best way to get MID
      int getMid(int s, int e) 
      {
          return s + ((e - s) / 2);
      }





























