package order.Topological;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalOrder {

	private Stack<TopoVertex> vertexOrder;
	public TopologicalOrder() {
		vertexOrder = new Stack<>();
	}
	
	public void topoOrder(TopoVertex root) {
		List<TopoVertex> neighbours = root.getNeighbours();
		for(TopoVertex temp : neighbours) {
			if(!temp.isVisited()) {
				temp.setVisited(true);
				topoOrder(temp);
			}
		}
		vertexOrder.add(root);
	}
	
	public Stack<TopoVertex> getVertexOrder() {
		return vertexOrder;
	}

	public static void main(String[] args) {
		TopoVertex tp15_6 = new TopoVertex("15-6");
		TopoVertex tp3_57 = new TopoVertex("3-57");
		TopoVertex tp24_5 = new TopoVertex("24-5");
		TopoVertex tp1_37_57 = new TopoVertex("1-37-57");
		TopoVertex tp1_5 = new TopoVertex("15");
		TopoVertex tp5_7 = new TopoVertex("57");
		TopoVertex tp2_4 = new TopoVertex("24");
		TopoVertex tp3_7 = new TopoVertex("37");
		TopoVertex tp6 = new TopoVertex("6");
		TopoVertex tp3 = new TopoVertex("3");
		TopoVertex tp5 = new TopoVertex("5");
		TopoVertex tp1 = new TopoVertex("1");
		TopoVertex tp7 = new TopoVertex("7");
		TopoVertex tp2 = new TopoVertex("2");
		TopoVertex tp4 = new TopoVertex("4");
		
		tp15_6.addNeighbour(tp1_5);
		tp15_6.addNeighbour(tp6);
		
		tp3_57.addNeighbour(tp3);
		tp3_57.addNeighbour(tp5_7);
		
		tp24_5.addNeighbour(tp2_4);
		tp24_5.addNeighbour(tp5);
		
		tp1_37_57.addNeighbour(tp1);
		tp1_37_57.addNeighbour(tp3_7);
		tp1_37_57.addNeighbour(tp5_7);
		
		tp1_5.addNeighbour(tp1);
		tp1_5.addNeighbour(tp5);
		
		tp5_7.addNeighbour(tp5);
		tp5_7.addNeighbour(tp7);

		tp2_4.addNeighbour(tp2);
		tp2_4.addNeighbour(tp4);
		
		tp3_7.addNeighbour(tp3);
		tp3_7.addNeighbour(tp7);

		List<TopoVertex> allList = new ArrayList<TopoVertex>();
		allList.add(tp15_6);
		allList.add(tp3_57);
		allList.add(tp24_5);
		allList.add(tp1_37_57);
		allList.add(tp1_5);
		allList.add(tp5_7);
		allList.add(tp2_4);
		allList.add(tp3_7);
		allList.add(tp6);
		allList.add(tp3);
		allList.add(tp5);
		allList.add(tp1);
		allList.add(tp7);
		allList.add(tp2);
		allList.add(tp4);
		
		TopologicalOrder topo = new TopologicalOrder();
		for(TopoVertex tp : allList) {
			if(!tp.isVisited()) {
				tp.setVisited(true);
				topo.topoOrder(tp);
			}
		}
		
		for(TopoVertex tp : topo.getVertexOrder()) {
			System.out.println(tp);
		}
			
	}

}
