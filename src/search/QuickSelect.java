package search;

import java.util.Random;

public class QuickSelect {

	private int arr[];
	public QuickSelect(int[] arr) {
		this.arr=arr;
	}
	
	public int select(int k) {
		return select(0, arr.length-1, k-1);
	}

	private int select(int strt, int end, int k) {
		
		int pivot = partition(strt, end);
		
		if(pivot>k) {
			return select(strt, pivot-1, k);
		}else if(pivot<k) {
			return select(pivot+1, end, k);
		}
		
		return arr[k];
	}
	
	

	private int partition(int strt, int end) {
		int pivot = new Random().nextInt(end-strt+1)+strt;
		swap(pivot, end);
		
		for(int i=strt; i<end; ++i) {
			if(arr[i]>arr[end]) {
				swap(strt, i);
				strt++;
			}
		}
		
		swap(strt, end);
		return strt;
	}

	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String[] args) {
		int a[]= {1,4,2,6,3};
		QuickSelect qs = new QuickSelect(a);
		int sel = qs.select(3);
		System.out.println(sel);
	}
}
