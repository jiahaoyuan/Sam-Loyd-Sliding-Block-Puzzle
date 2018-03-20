import java.util.*;

public class GameState {

	public int[][] state;
	public int[][] parent;
	public int[][] replica1;
	public int[][] replica2;
	public int row;
	public int col;
	public ArrayList<GameState> x;
	
	public GameState()
	{
		state = new int[3][3];
		parent = null;
	}
	
	public GameState(int[][] state)
	{
		this.state= state;
		parent = null;
	}
	
	public GameState(int[][] state, int[][] parent)
	{
		this.state = state;
		this.parent = parent;
	}
	
	public void location()
	{
		for (int a = 0; a< 3; a++)
			for (int b = 0; b<3; b++)
				if (state[a][b] == 0)
				{
					row = a;
					col = b;
				}

	}
	
	public void copy()
	{
		replica1 = new int[3][3];
	    replica2 = new int[3][3];
		for (int a = 0; a< 3; a++)
			for (int b = 0; b<3; b++)
			{
				int temp = this.state[a][b];
				replica1[a][b]= temp;
				replica2[a][b]= temp;
						
			}
		
	}
	
	public GameState swapRight()
	{   
		this.copy();
		int temp = replica1[row][col];
		replica1[row][col]= replica1[row][col+1];
		replica1[row][col+1]= temp;
		GameState Right = new GameState(replica1, replica2);
		return Right;
	}
	
	public GameState swapLeft()
	{   
		this.copy();
		int temp = replica1[row][col];
		replica1[row][col]= replica1[row][col-1];
		replica1[row][col-1]= temp;
		GameState Left = new GameState(replica1, replica2);
		return Left;
		
	}
	
	public GameState swapUp()
	{   		
		this.copy();
	int temp = replica1[row][col];
	replica1[row][col]= replica1[row-1][col];
	replica1[row-1][col]= temp;
	GameState Up = new GameState(replica1, replica2);
	return Up;
	

	}
	
	public GameState swapDown()
	{   
		this.copy();
		int temp = replica1[row][col];
		replica1[row][col]= replica1[row+1][col];
		replica1[row+1][col]= temp;
		GameState Down = new GameState(replica1, replica2);
		return Down;
		
	}
	
	
	public boolean isEnd()
	{
		int[][] end = {{0,1,2},{3,4,5},{6,7,8}};

		//create a gamestate with end and null parent
		GameState END = new GameState(end);
		if (this.equals(END))
			return true;
		else
			return false;
	}

	public ArrayList<GameState> getAdjacent()
	{
		x = new ArrayList<GameState>();
		this.location();
		if (row!=0)
			x.add(this.swapUp());
		if (row!=2)
			x.add(this.swapDown());
		if (col!=0)
			x.add(this.swapLeft());
		if (col!=2)
			x.add(this.swapRight());
		return x;
	}
	
	@Override
	// only comparing child
	public boolean equals(Object obj)
	{

		if (obj == this)
			return true;
		
		if (!(obj instanceof GameState))
			return false;
		
		GameState tmp = (GameState) obj;
		
		
		for (int a = 0; a< 3; a++)
			for (int b = 0; b<3; b++)
				if (this.state[a][b]!= tmp.state[a][b])
					return false;
					
		return true;
	}
	
	@Override
	public String toString()
	{
		// only printout the child, not parent
		String temp = "";
		for (int a = 0; a< state.length; a++)
		{
			for (int b = 0; b< state[a].length; b++)
				temp = temp + " " + Integer.toString(state[a][b]);
			temp = temp + "\n";
		}
		
		return temp;
	}
	
	//Unnecessary
	public String Parent()
	{
		String temp = "";
		for (int a = 0; a< state.length; a++)
		{
			for (int b = 0; b< state[a].length; b++)
				temp = temp + " " + Integer.toString(parent[a][b]);
			temp = temp + "\n";
		}
		
		return temp;
	}
	
	// comparing parent to child
	public boolean ParentToChild(GameState target)
	{
	
		for (int a = 0; a< 3; a++)
			for (int b = 0; b<3; b++)
				if (this.parent[a][b]!= target.state[a][b])
					return false;
					
		return true;
	}
	
	// Comparing child to child in Explored with an iterator
	public boolean Marked(List<GameState> target)
	{
		for (Iterator itr = target
				.iterator(); itr.hasNext();)
			//System.out.println(itr.next());
			if (this.equals(itr.next()))
				return true;
		return false;

	}
	
public static void main(String[] args)
{	
	GameState x1 = new GameState();
	int[][] StartArray = {{1,5,2}, {3,4,0}, {6,8,7}};
	GameState Start = new GameState(StartArray, StartArray);

	System.out.println(Start.Parent());
	System.out.println(Start.toString());
	
}
	
}
