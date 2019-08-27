package search;

public class LinearSearch {

	private int[] arr;
	public LinearSearch(int[] arr) {
		this.arr=arr;
	}
	
	public int search(int n) {
		for(int i=0; i<arr.length; i++) {
			if(n==arr[i]) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[]= {3,56,1,43,53,77,30};
		int toSearch=43;
		LinearSearch ls = new LinearSearch(arr);
		System.out.println(ls.search(toSearch));
	}

}
