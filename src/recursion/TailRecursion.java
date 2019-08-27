package recursion;

public class TailRecursion {

	public TailRecursion() {
		// TODO Auto-generated constructor stub
	}
	
	public void tailRecursion(int n) {
		if(n==0) return;
		
		System.out.println(n);
		
		tailRecursion(n-1);
	}

	public static void main(String[] args) {
		new TailRecursion().tailRecursion(6);
	}
}
