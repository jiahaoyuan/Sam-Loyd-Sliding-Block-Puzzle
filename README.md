# Sam-Loyd-Sliding-Block-Puzzle

![alt text](https://github.com/jiahaoyuan/Sam-Loyd-Sliding-Block-Puzzle/blob/master/project%201/Sam%20Loyd%20Sliding%20Block%20Puzzle.jpg)

As you can see from above, this is a Sam Loyd Sliding Block Puzzle.

What you should do is to return the puzzle from whatever the initial state is to a ordered state from 1 to 15.

Here, we used a Object-Orientated approach.

"GameState.java" defines a new Object called GameState.

"Play.java" uses a BFS to carry out a brute-force search to find the path.

Peudocode:

	//BFS Pseudocode
		// 1. Root check End 
		// 2. Mark, Push
		
		// 3. While (!current.isEnd())
			// 3.0 "Current" = front of the list
			// 3.1 Check Marked (while loop until (!marked))
			// 3.2 (Abort)
			// 3.3 Mark 
			// 3.4 Get Children, Push
		// End Found
		
		// Get Parent Pseudocode
		// while (temp.parent!=start)
		// 1. "temp" = end found
		// 2. search temp.parent and compares wth childrens in "explored"
		// 3. update temp
		// 4. print children
		// when start is found, print start
