# Tree Preparation Notes
##Introduction
	1. A tree is a frequently-used data structure to simulate a hierarchical tree structure.
	2. From graph view, a tree can also be defined as a directed acyclic graph which has N nodes and N-1 edges.
	
##Traversal:
######	1.PreOrder:
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
			  
######	2.InOrder:
		- Left --> Root --> Right
		- Iterative:
			- 1 Stack
			****currNode variable must****
			- currNode = root
			- if currNode != null
				- stack.push(currNode)
				- currNode = currNode.left //Go all the way to leftmost
			- else
				- currNode = pop()
				- visit(currNode)
				- currNode = currNode.right //One at a time
			```	
			While(currNode != null && !stack.isEmpty)
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
######	3.PostOrder:
		- Left --> Right --> Root
		- 2 Stacks
		- 		
					
					
							