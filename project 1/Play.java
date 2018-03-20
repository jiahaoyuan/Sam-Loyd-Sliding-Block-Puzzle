
import java.util.*;

public class Play {
	public static List<GameState> explored;
	public static Deque<GameState> frontier;
	public static boolean marked;
	public static GameState current;


	
	public static void main(String[] args)
	{

		int[][] StartArray = {{1,5,2}, {3,4,0}, {6,8,7}};
		//int[][] StartArray = {{1,2,0}, {3,4,5}, {6,7,8}};
		GameState Start = new GameState(StartArray, null);
	
		explored = new ArrayList<GameState>();
		frontier = new ArrayDeque<GameState>();
		
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
			
		
		// BFS 
		// 1. Root = current
		current = Start;
		// 2. Mark, Push
		//explored.add(Start);
		frontier.push(Start);
		// 3. While (!current.isEnd())

		while (!(current.isEnd()))
		{

					// 3.0 "Current" = front of the list
					
					// 3.1 Check Marked (while loop until (!marked))
					while (current.Marked(explored))
					{
						current = frontier.removeLast();
					}
					// 3.2 (Deleted)
					// 3.3 Mark 
						explored.add(current);
					// 3.4 Get Children, Push
					current.getAdjacent();
					for (Iterator itr = current.x
							.iterator(); itr.hasNext();)
						frontier.push((GameState) itr.next());
		}
				// End Found
		System.out.println(current);

		// Get Parent Pseudocode
				// while (temp.parent!=start)
		while (!current.ParentToChild(Start))
		{
				// 1. "temp" = end found
		
				// 2. search temp.parent and compares wth childrens in "explored"
			for (int a= 0; a< explored.size(); a++)
			{
				if (current.ParentToChild(explored.get(a)))
				// 3. update temp
					current=explored.get(a);
			}
				// 4. print children
			System.out.println(current);
		}
				// when start is found, print start
		System.out.println(Start);
		
		
	}
	

}
