package search.DepthFirst;

import java.util.LinkedList;
import java.util.List;

public class Vertex {

	private String name;
	private List<Vertex> neighbours;
	private boolean visited;
	String path="";
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Vertex(String name) {
		this.name = name;
		neighbours = new LinkedList<Vertex>();
	}

	@Override
	public String toString() {
		return "[" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Vertex> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Vertex> neighbours) {
		this.neighbours = neighbours;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public void addNeighbour(Vertex vertex) {
		neighbours.add(vertex);
	}

}
