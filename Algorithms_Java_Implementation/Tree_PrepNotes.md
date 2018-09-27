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
				
					
					
							
