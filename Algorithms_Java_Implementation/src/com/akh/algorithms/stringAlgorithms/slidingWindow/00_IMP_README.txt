README

COUNTER - The MOST CRUCIAL item which differentiates between the different problem while using same Sliding Window technique.

Find all Anagrams In a String LC438
	- Counter keeps track all the required characters and their respective counts.
	- If counter == target.length() then we have found a valid window
	- In shrink step we shrink until the counter < target.length() i.e., Window has become invalid by one char

Minimum Window Substring LC76
	- Counter keeps track all the required characters and their respective counts.
	- If counter == target.length() then we have found a valid window
	- In shrink step we shrink until the counter < target.length() i.e., Window has become invalid by one char

Longest Substring Without Repeating Characters LC3
	- Counter in this class keeps track of the UNIQUEness of the window. 
	- If uniqueness is broken then it increments. 
	- You need to shrink window inorder and make counter == 1 to restore UNIQUEness