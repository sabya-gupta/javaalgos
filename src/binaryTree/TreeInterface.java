package binaryTree;

public interface TreeInterface<T extends Comparable<T>> {
	public void insert(T data);
	public void delete(T data);
	public T getMax();
	public T getMin();
	public void inOrderTraversal();
	public Node<T> getRootNode();
}
