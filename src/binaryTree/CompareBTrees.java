package binaryTree;

public class CompareBTrees<T extends Comparable<T>> {

	public CompareBTrees() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean compare (Node<T> node1, Node<T> node2) {
		if(node1==null && node2==null) return node1==node2;
		
		if(node1.getData().compareTo(node2.getData())!=0) return false;
		
		return 
				(
						compare(node1.getLeftChild(), node2.getLeftChild())
						&&
						compare(node1.getRightChild(), node2.getRightChild())
				);
	}
	
	public static void main(String[] args) {
		TreeInterface<Integer> tree1 = new BinaryTree<>();
		tree1.insert(10);
		tree1.insert(5);
		tree1.insert(15);
		tree1.insert(3);
		tree1.insert(8);

		TreeInterface<Integer> tree2 = new BinaryTree<>();
		tree2.insert(10);
		tree2.insert(5);
		tree2.insert(15);
		tree2.insert(3);
		tree2.insert(7);
		
		boolean bool = new CompareBTrees<Integer>().compare(tree1.getRootNode(), tree2.getRootNode());
		
		System.out.println(bool);
	}

}
