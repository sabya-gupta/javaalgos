package order.Topological;

import java.util.LinkedList;
import java.util.List;

public class TopoVertex {

	private String data;
	private boolean isVisited;
	private List<TopoVertex> neighbours;
	private String completepath;
	
	public TopoVertex(String data) {
		this.data = data;
		neighbours = new LinkedList<>();
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public List<TopoVertex> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<TopoVertex> neighbours) {
		this.neighbours = neighbours;
	}

	public String getCompletepath() {
		return completepath;
	}

	public void setCompletepath(String completepath) {
		this.completepath = completepath;
	}
	
	public void addNeighbour(TopoVertex vertex) {
		neighbours.add(vertex);
	}

	@Override
	public String toString() {
		return "[" + data + "]";
	}

}
