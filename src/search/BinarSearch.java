package search;

public class BinarSearch {

	private int[] arr;
	public BinarSearch(int[] arr) {
		this.arr=arr;
	}

	private int binarySearch(int startIdx, int endIdx, int n) {
		if(endIdx<startIdx) {
			return -1;
		}
		
		int midIdx = (startIdx+endIdx)/2;
		
		if(arr[midIdx]==n) return midIdx;
		
		if(n>arr[midIdx]) {
			return binarySearch(midIdx+1, endIdx, n);
		}else {
			return binarySearch(startIdx, midIdx-1, n);
		}
	}
	
	public int search(int n) {
		return binarySearch(0, arr.length-1, n);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,11,14,17, 18, 20, 24, 26, 28, 31, 33, 39};
		BinarSearch bs = new BinarSearch(arr);
		System.out.println(bs.search(19));
	}
}
