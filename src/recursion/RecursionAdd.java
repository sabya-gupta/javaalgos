package recursion;

public class RecursionAdd {

	public RecursionAdd() {
		// TODO Auto-generated constructor stub
	}
	
	public int addN(int n) {
		if(n==1) return n;
		else return (n+addN(n-1));
	}
	
	public static void main(String[] args) {
		int n = new RecursionAdd().addN(4);
		System.out.println(n);
	}

}
