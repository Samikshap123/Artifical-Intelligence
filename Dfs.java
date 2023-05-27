import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class graph_implement {
    private LinkedList<Integer> adjancey[];
    
	public graph_implement(int v) {
		// TODO Auto-generated constructor stub
		adjancey = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adjancey[i]=new LinkedList<Integer>();
		}
		}
	public void insertedge(int s,int d)
	{
		adjancey[s].add(d);
		adjancey[d].add(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter number of vertices and edges");
	int v = sc.nextInt();
	int e = sc.nextInt();
	graph_implement g = new graph_implement(v);
	System.out.println("Enter the edges");
	for(int i=0;i<e;i++)
	{
		int s = sc.nextInt();
		int d = sc.nextInt();
		g.insertedge(s, d);
		
	}
	System.out.println("Enter source for bfs traversal\n");
	int source = sc.nextInt();
	g.bfs(source);
	System.out.println("\n");
	}

	private void bfs(int source) {
		// TODO Auto-generated method stub
		boolean visited_nodes[] = new boolean[adjancey.length];
		int parent_nodes[]=new int[adjancey.length];
		Stack<Integer> q = new Stack();
		q.add(source);
		visited_nodes[source]=true;
		parent_nodes[source]=-1;
		while(!q.isEmpty())
		{
			int p = q.pop();
			System.out.println(p);
			for(int i : adjancey[p])
			{
				if(visited_nodes[i]!=true)
				{
					visited_nodes[i]=true;
					q.add(i);
					parent_nodes[i]=p;
				}
			}
		}
	}

}
