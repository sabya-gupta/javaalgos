package search.CycleDetection;

import java.util.LinkedList;
import java.util.List;

public class CDVertex {

	String data;
	List<CDVertex> neighbours;
	boolean visited;
	boolean beingVisited;
	public CDVertex(String data) {
		neighbours = new LinkedList<>();
		this.data=data;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List<CDVertex> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(List<CDVertex> neighbours) {
		this.neighbours = neighbours;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public boolean isBeingVisited() {
		return beingVisited;
	}
	public void setBeingVisited(boolean beingVisited) {
		this.beingVisited = beingVisited;
	}
	@Override
	public String toString() {
		return "[" + data + "]";
	}
	public void addNeighbour(CDVertex vertex) {
		neighbours.add(vertex);
	}
	
}
