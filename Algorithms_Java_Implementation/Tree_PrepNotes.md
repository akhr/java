# Tree Preparation Notes
## Introduction
	1. A tree is a frequently-used data structure to simulate a hierarchical tree structure.
	2. From graph view, a tree can also be defined as a directed acyclic graph which has N nodes and N-1 edges.
	
## Traversal:
###	1.PreOrder:
- Root --> Left --> Right
- Iterative: 
	- 1 stack
	- No currentNode variable
	- Pop a node from stack
		- Visit it
		- Add its left
		- Add its right
		- Repeat while loop
			
```

While(!stack.isEmpty)
  {
		pop()
		visit()
		if(poped.left)
			stack.push(poped.left)	
		if(poped.right)
			stack.push(poped.right)	
  }							  
```

###	2.InOrder:
- Left --> Root --> Right
- Iterative:
	- 1 Stack
	- **_currNode variable must_**
	- currNode = root
	- if currNode != null
		- stack.push(currNode)
		- currNode = currNode.left //Go all the way to leftmost
	- else
		- currNode = pop()
		- visit(currNode)
		- currNode = currNode.right //One at a time
				
```			
while(currNode != null && !stack.isEmpty)
  {
		if(currNode != null){
			stack.push(currNode);
			currNode = curr.left;
		}else {
			currNode = stack.pop();
			visitNode(currNode);
			currNode = curr.right;
		}
  }
```

###	3.PostOrder:
- Left --> Right --> Root
- 1 Stack and 2 Stacks solution are available
- 1 Stack
	1. Create an empty stack
	2. Set curr = root
	3. If (curr != null)
		1. If curr has right - stack.push(right)
		2. then stack.push(curr)
		3. **_We push right and then curr coz_** 
			- while poping we can check if the poped.right == stack.peek()
			- Instead if right is pushed before root (actual required postOrder) 
			- then we will pop right first
			- From right node we cannot say whose right is this guy
			- We need the parent to say 
	4. If(curr == null)
		1. curr = pop()
		2. Check if curr.right == stack.peek() --> YES
			- Then store curr.right in temp
			- stack.push(curr)
			- set curr = temp
			- Goto 3
		3. Check if curr.right == stack.peek() --> NO  || stack.isEmpty() //Means last node
			- Means its left is visited and 
			- Its right is also visited and not in stack
			- Its time to visit this node.
- 2 Stacks
	1. s1 will read the tree and add items to s2 in postOrder 
	2. Create two empty stack
	3. Push root into s1
	4. while(!s1.isEmpty)
		- curr = s1.pop()
		- s2.push(curr)
		- s1.push(curr.left)
		- s1.push(curr.right)
	5. while(!s2.isEmpty)
		- visit(s2.pop())

## BFS:
## DFS:

## Tree Recursion:
- Two types of recursion for Trees
	1. Top-down 
	2. Bottom-up
### Top Down:
- At each recursion level 
	- Visit the node and come up with some values
	- Pass these values to its children while calling func recursively
	- Its kind of **_Pre Order Traversal_**
	
	```
		1. return specific value for null node
		2. update the answer if needed                      // anwer <-- params
		3. left_ans = top_down(root.left, left_params)      // left_params <-- root.val, params
		4. right_ans = top_down(root.right, right_params)   // right_params <-- root.val, params 
		5. return the answer if needed                      // answer <-- left_ans, right_ans
	```
	
- Eg: Find Max Depth of a Tree
	```
		public int findMaxDepth_Top_Down(TreeNode root) {
			int[] maxDepth = new int[1];
			findMaxDepth_Top_Down(root, 1, maxDepth);
			return maxDepth[0];
		}
		private void findMaxDepth_Top_Down(TreeNode root, int depth, int[] maxDepth) {
			//update the answer if LEAF
			if(root.left == null && root.right == null) {
				maxDepth[0] = new Integer(Math.max(maxDepth[0], depth));
			}
	
			//Get left ans
			if(root.left != null)
				findMaxDepth_Top_Down(root.left, depth+1, maxDepth);
			//Get right ans
			if(root.right != null)
				findMaxDepth_Top_Down(root.right, depth+1, maxDepth);
		}
	```
### Bottom Up:
- At each recursion level
	- Visit the childrens and get return vals
	- calculate result based on return vals and this node's val
	- Its kind of **_Post Order Traversal_**
	```
		1. return specific value for null node
		2. left_ans = bottom_up(root.left)          // call function recursively for left child
		3. right_ans = bottom_up(root.right)        // call function recursively for right child
		4. return answers                           // answer <-- left_ans, right_ans, root.val
	```
	
	```
		public int findMaxDepth_Bottom_Up(TreeNode root) {
			//return specific val for null node
			if(root == null)
				return 0;
			
			//Get return vals of left and right
			int leftDepth = findMaxDepth_Bottom_Up(root.left);
			int rightDepth = findMaxDepth_Bottom_Up(root.right);
			
			//Cal answer based on left, right and this node vals
			return 	Math.max(leftDepth, rightDepth) + 1;
		}	
	```

					
					
							
