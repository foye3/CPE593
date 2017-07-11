package hw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Primes_Using_Miller_Rabin {
	
	public boolean millerRabin(long n, int k) {
		if (n == 2 || n == 3)
			return true;
		if (n % 2 != 0 && n > 3) {
			long r = 0;
			long d = n - 1;
			// n-1 = 2^r*d
			while (d % 2 == 0) {
				d /= 2;
				r++;
			}
			//witness loop
			LableA: 
			for (int i = 1; i < k; i++) {
				long a = (long) (Math.random() * (n - 3) + 2);
				long x = powerMod(a, d, n);
				if (x == 1 || x == n - 1) {
					continue;
				}
				for (int j = 1; j < r; j++) {
					x = (x * x) % n;
					if (x == 1)
						return false;
					//continue witness loop
					if (x == n - 1) {
						continue LableA;
					}

				}
				return false;
			}

			return true;

		} else {
			return false;
		}

	}

	// x^d mod n
	public long powerMod(long x, long d, long n) {
		long prod = 1;
		while (d > 0) {
			if (d % 2 != 0)
				prod = (prod * x) % n;
			x = (x * x) % n;
			d = d / 2;
		}
		return prod;

	}

	
	
	
	public static void main(String[] args) throws IOException {
		Primes_Using_Miller_Rabin mr = new Primes_Using_Miller_Rabin();
		// System.out.println(mr.millerRabin(961748941, 50));
		BufferedReader br = new BufferedReader(new FileReader("src/hw2/hw2.dat"));
		String content;
		while ((content = br.readLine()) != null) {
			System.out.println(content + " " + mr.millerRabin(Long.parseLong(content), 50));
		}

	}
}
