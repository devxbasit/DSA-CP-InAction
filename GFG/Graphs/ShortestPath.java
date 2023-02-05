// A Java program for Dijkstra's single source shortest path algorithm. 
// The program is for adjacency matrix representation of the graph 
import java.util.*; 
import java.lang.*; 
import java.io.*; 

class ShortestPath { 
	static final int V = 9; 

	void printSolution(int dist[]) 
	{ 
		System.out.println("Vertex \t\t Distance from Source"); 
		for (int i = 0; i < V; i++) 
			System.out.println(i + " \t\t " + dist[i]); 
	} 

	int minDistance(int distance[], boolean visited[]) { 

		int minDistance = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < V; i++) {

			if (!visited[i] && distance[i] < minDistance) {

				minDistance = distance[i];
				minIndex = i;

			}
		}

		return minIndex;
	} 


	void dijkstra(int graph[][], int src) {

		int distance[] = new int [V];
		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {

			distance[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		distance[src] = 0;

		for (int i = 0; i < V - 1; i++) {

			int u = minDistance(distance, visited);

			visited[u] = true;

			for (int v = 0; v < V; v++) {

				if (!visited[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + graph[u][v]) {

					distance[v] = distance[u] + graph[u][v];

				}

			}
		}


		printSolution(distance); 
	} 


	public static void main(String[] args) 
	{ 

		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
									{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
									{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
									{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
									{ 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
									{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
									{ 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
									{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
									{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
		ShortestPath t = new ShortestPath(); 
		t.dijkstra(graph, 0); 
	} 
} 