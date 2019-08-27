package binaryTree;

public class BinaryTree<T extends Comparable<T>> implements TreeInterface<T> {

	private Node<T> root;
	
	@Override
	public void insert(T data) {
		if(root==null) {
			root = new Node<T>(data);
		}else {
			insert(data, root);
		}
	}
	

	private void insert(T data, Node<T> parent) {
		if(parent.getData().compareTo(data)<0) {
			if(parent.getRightChild()==null) {
				Node<T> tempNode = new Node<T>(data);
				parent.setRightChild(tempNode);
				System.out.println("Adding "+tempNode+ " as RIGHT child of "+ parent);
			}else {
				insert(data, parent.getRightChild());
			}
		}else {
			if(parent.getLeftChild()==null) {
				Node<T> tempNode = new Node<T>(data);
				parent.setLeftChild(tempNode);
				System.out.println("Adding "+tempNode+ " as LEFT child of "+ parent);
			}else {
				insert(data, parent.getLeftChild());
			}			
		}
	}

	@Override
	public void delete(T data) {
		delete(data, root);
	}
	
	private Node<T> delete(T data, Node<T> parent) {
		if(parent == null) return parent;
		
		if(data.compareTo(parent.getData())>0) {
			parent.setRightChild(delete(data, parent.getRightChild()));
		}else if(data.compareTo(parent.getData())<0) {
			parent.setLeftChild(delete(data, parent.getLeftChild()));
		}else {
			if(parent.getLeftChild()==null && parent.getRightChild()==null) {
				System.out.println("Deleting leaf node...");
				return null;
			}
			
			if(parent.getLeftChild()==null) {
				Node<T> tempNode = parent.getLeftChild();
				parent=null;
				System.out.println("Deleting Left node");
				return tempNode;
			}
			if(parent.getRightChild()==null) {
				Node<T> tempNode = parent.getRightChild();
				parent=null;
				System.out.println("Deleting Right node");
				return tempNode;
			}
			
			Node<T> temp = getPredecessor(parent.getLeftChild());
					
			parent.setData(temp.getData());
			
			temp.setLeftChild(
			delete(temp.getData(), parent.getLeftChild())
			);
			
		}
		return parent;
	}
	
	private Node<T> getPredecessor(Node<T> node){
		if(node.getRightChild()==null) return node;
		else
		return getPredecessor(node.getRightChild());
	}
	
	@Override
	public T getMax() {
		if(root==null) return null;
		return getMax(root);
	}
	
	
	private T getMax(Node<T> node) {
		if(node.getRightChild()!=null) {
			return getMax(node.getRightChild());
		}else {
			return node.getData();
		}
	}

	@Override
	public T getMin() {
		if(root==null) return null;
		return getMin(root);
	}

	private T getMin(Node<T> node) {
		if(node.getLeftChild()!=null) {
			return getMin(node.getLeftChild());
		}
		return node.getData();
	}
	
	public static void main(String[] args) {
		TreeInterface<Integer> tree = new BinaryTree<>();
//		int numberOfInt = 10;
//		
//		int posToDel=numberOfInt/2;
//		int numTodel=0;
//
//		Random random = new Random();
//		for(int i=0; i<numberOfInt; i++) {
//			int ranInt = random.nextInt(2*numberOfInt)-numberOfInt;
//			if(posToDel==i) numTodel=ranInt;
//			System.out.println(ranInt);
//			tree.insert(ranInt);
//		}
		
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(7);
		
		System.out.println("Max = "+tree.getMax());
		System.out.println("Min = "+tree.getMin());
		tree.delete(3);
		tree.inOrderTraversal();
	}


	@Override
	public void inOrderTraversal() {
		inOrderTraversal(root);
	}
	
	private void inOrderTraversal(Node<T> node) {
		if(node.getLeftChild()!=null) 
			inOrderTraversal(node.getLeftChild());
		
		System.out.println(node);
		
		if(node.getRightChild()!=null)
			inOrderTraversal(node.getRightChild());
	}


	@Override
	public Node<T> getRootNode() {
		return root;
	}


}
