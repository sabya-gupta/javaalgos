package search.BreathFirst;

import java.util.LinkedList;
import java.util.Queue;

public class BFSAlgo {

	public void bfs(Vertex root) {
		Queue<Vertex> queue = new LinkedList<Vertex>(); //Queue is FIFO
		queue.add(root);
		while(!queue.isEmpty()) {
			Vertex nextVertex = queue.remove();
			System.out.println(nextVertex+"");
			for(Vertex v : nextVertex.getNeighbourList()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					queue.add(v);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		BFSAlgo bfs = new BFSAlgo();
		
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		
		v1.addNeighbourVertex(v2);
		v1.addNeighbourVertex(v4);
		v4.addNeighbourVertex(v5);
		v2.addNeighbourVertex(v3);
		v5.addNeighbourVertex(v4);
		
		bfs.bfs(v1);
	}

}
