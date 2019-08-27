package binaryTree;

public class FindKthElement<T extends Comparable<T>> {

	public FindKthElement() {
	}
	
	
	public Node<T> getKthNode(Node<T> node, int k) {
		if(node==null) return null;
		int n = treeSize(node.getLeftChild())+1;
		System.out.println(node+">>>"+n+" k = "+k);
		if(n==k) {
			System.out.println("returning "+node);
			return node;
		}
		
		if(n>k) {
			return getKthNode(node.getLeftChild(), (k));
		}
		
		if(n<k) {
			return getKthNode(node.getRightChild(), k-n);
		}
		
		return null;
	}
	
	

	private int treeSize(Node<T> node) {
		if(node==null) return 0;
		
		return treeSize(node.getLeftChild())+
				treeSize(node.getRightChild())
				+1;
	}

	public static void main(String[] args) {
		TreeInterface<Integer> tree1 = new BinaryTree<>();
		tree1.insert(10);
		tree1.insert(5);
		tree1.insert(15);
		tree1.insert(3);
		tree1.insert(8);
		
		System.out.println
		(
				new FindKthElement<Integer>()
				.getKthNode(tree1.getRootNode(), 10)
		);
	}

}
