package hw;

public class Compute_Primes {

	public int computePrimes(long a, long b) {
		if(a>b||b>Math.pow(10, 14)||b-a>Math.pow(10, 9)) {
			System.out.println("error input");
			return -1;
		}
		if(b<1){
			return 0;
		}
		
		if (a < 2)
			a = 2;
		//numbers bigger 
		int sqrt = (int) Math.sqrt(b);
		//initial false
		boolean[] isP = new boolean[sqrt + 1];
		boolean[] numP = new boolean[(int) (b - a + 1)];
		
		
		for (int i = 2; i <= sqrt; i++) {
			if (!isP[i]) {

				for (int j = i; j <= sqrt / i; j++) {
					isP[j * i] = true;
				}
				//big enough
				if (a > sqrt) {
					if (a % i == 0) {
						for (long k = a; k <= b; k = k + i) {
							numP[(int) (k - a)] = true;
						}
					} else {
						for (long k = a + i - a % i; k <= b; k = k + i) {
							numP[(int) (k - a)] = true;
						}
					}
				} else {
					//small number
					for (int j = i * i; j <= b; j = j + i) {
						if (j >= a)
							numP[(int) (j - a)] = true;
					}
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < numP.length; i++) {
			//is not initial
			if (!numP[i]) {
				count++;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		Compute_Primes cp = new Compute_Primes();
		long t = System.currentTimeMillis();
		System.out.println("Result:" + cp.computePrimes(2000000000000L, 2000000100000L));
		//System.out.println("Result:" + cp.computePrimes(1,100));
		//System.out.println("Result:" + cp.computePrimes(-8,90));
		//System.out.println(cp.computePrimes(10, 80));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t);
	}
}
