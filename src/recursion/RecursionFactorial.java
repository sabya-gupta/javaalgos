package recursion;

public class RecursionFactorial {

	public RecursionFactorial() {
		// TODO Auto-generated constructor stub
	}
	
	public int factorialN(int n) {
		if(n==1) return n;
		return (n*factorialN(n-1));
	}
	
	public int factorialNWithAccumulator(int n, int accumulator) {
		if(n==1) return n*accumulator;
		return (factorialNWithAccumulator(n-1, accumulator*n));
	}
	
	public static void main(String[] args) {
		int n= 19;
		int iter=50000000;
		long t1 = System.currentTimeMillis();
		for(int i=0; i<iter; i++) {
			new RecursionFactorial().factorialN(n);
		}
		System.out.println(new RecursionFactorial().factorialN(n));
		long t2 = System.currentTimeMillis();
		for(int i=0; i<iter; i++) {
			new RecursionFactorial().factorialNWithAccumulator(n, 1);
		}
		System.out.println(new RecursionFactorial().factorialNWithAccumulator(n, 1));
		long t3 = System.currentTimeMillis();

		System.out.println((t2-t1)+":"+(t3-t2));
	}

}
