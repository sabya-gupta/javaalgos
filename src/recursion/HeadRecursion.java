package recursion;

public class HeadRecursion {

	public HeadRecursion() {
		// TODO Auto-generated constructor stub
	}

	public void headrecursion(int n) {
		if(n==0) return;
		
		headrecursion(n-1);
		
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		new HeadRecursion().headrecursion(5);
	}
}
