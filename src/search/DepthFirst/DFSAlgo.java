package search.DepthFirst;

import java.util.List;
import java.util.Stack;


public class DFSAlgo {

	public void dfs(Vertex root) {
		Stack<Vertex> stack = new Stack<>();
		root.setVisited(true);
		root.setPath(root.toString());
		stack.push(root);
		while(!stack.isEmpty()) {
			Vertex v = stack.pop();
			System.out.println(v+":"+v.getPath());
			List<Vertex> neighbours = v.getNeighbours();
			for(Vertex temp : neighbours) {
				if(!temp.isVisited()) {
					temp.setVisited(true);
					temp.setPath(v.getPath()+temp.toString());
					stack.add(temp);
				}
			}
		}
	}
	
	public void dfsRecursive(Vertex root) {
		root.setPath(root.getPath());
		System.out.println(root +":"+ root.getPath());
		List<Vertex> neighbours = root.getNeighbours();
		for(Vertex temp : neighbours) {
			if(!temp.isVisited()) {
				temp.setVisited(true);
				temp.setPath(root.getPath()+temp.toString());
				dfsRecursive(temp);
			}
		}
	}
	
	public DFSAlgo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DFSAlgo dfs = new DFSAlgo();

		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		
		v1.addNeighbour(v2);
		v1.addNeighbour(v4);
		v4.addNeighbour(v5);
		v2.addNeighbour(v3);
		v5.addNeighbour(v4);
		
		dfs.dfs(v1);
		System.out.println("--------------");
		v1.setVisited(false);
		v2.setVisited(false);
		v3.setVisited(false);
		v4.setVisited(false);
		v5.setVisited(false);
		dfs.dfsRecursive(v1);
	}
}
