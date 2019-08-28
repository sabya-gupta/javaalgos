package search.CycleDetection;

public class CycleDetecDFAlgo {

	public CycleDetecDFAlgo() {
	}
	
	void cddfAlgo(CDVertex root) {
		System.out.println(root);
		root.setBeingVisited(true);
		for(CDVertex v : root.neighbours) {
			
			if(v.beingVisited) {
				System.out.println("Cycle detected "+ v);
				return;
			}
			if(!v.isVisited()) {
				v.setVisited(true);
				cddfAlgo(v);
			}
		}
		root.setBeingVisited(false);
		root.setVisited(true);
	}
	
	public static void main(String[] args) {
		CDVertex cdv1 = new CDVertex("1");
		CDVertex cdv2 = new CDVertex("2");
		CDVertex cdv3 = new CDVertex("3");
		CDVertex cdv4 = new CDVertex("4");
		CDVertex cdv5 = new CDVertex("5");
		
		
		cdv1.addNeighbour(cdv2);
		cdv2.addNeighbour(cdv3);
		cdv2.addNeighbour(cdv5);
		cdv3.addNeighbour(cdv4);
//		cdv4.addNeighbour(cdv5);
		
		new CycleDetecDFAlgo().cddfAlgo(cdv1);
	}
	

}
