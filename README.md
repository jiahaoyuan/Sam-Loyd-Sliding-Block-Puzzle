# Sam-Loyd-Sliding-Block-Puzzle

![alt text](https://github.com/jiahaoyuan/Sam-Loyd-Sliding-Block-Puzzle/blob/master/project%201/Sam%20Loyd%20Sliding%20Block%20Puzzle.jpg)

As you can see from above, this is a Sam Loyd Sliding Block Puzzle.

What you should do is to return the puzzle from whatever the initial state is to a ordered state from 1 to 15.

Here, we used a Object-Orientated approach.

"GameState.java" defines a new Object called GameState.

"Play.java" uses a BFS to carry out a brute-force search to find the path.

Example:

Initial State: 

1 5 2
3 4 0
6 8 7

Output (Backward): 

 0 1 2
 3 4 5
 6 7 8

 3 1 2
 0 4 5
 6 7 8

 3 1 2
 6 4 5
 0 7 8

 3 1 2
 6 4 5
 7 0 8

 3 1 2
 6 0 5
 7 4 8

 3 1 2
 6 5 0
 7 4 8

 3 1 2
 6 5 8
 7 4 0

 3 1 2
 6 5 8
 7 0 4

 3 1 2
 6 5 8
 0 7 4

 3 1 2
 0 5 8
 6 7 4

 0 1 2
 3 5 8
 6 7 4

 1 0 2
 3 5 8
 6 7 4

 1 5 2
 3 0 8
 6 7 4

 1 5 2
 3 8 0
 6 7 4

 1 5 2
 3 8 4
 6 7 0

 1 5 2
 3 8 4
 6 0 7

 1 5 2
 3 0 4
 6 8 7

 1 5 2
 3 4 0
 6 8 7
