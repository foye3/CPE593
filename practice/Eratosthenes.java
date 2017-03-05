package practice;

public class Eratosthenes {
	public void eratosthenes(int n){
		//all false
		boolean[] sieve = new boolean[n];
		for(int i=2;i<sieve.length;i++){
			if(!sieve[i]){
				System.out.println(i);
			}
			for(int j=i*i;j<=n;j+=i){
				sieve[j] =true;
			}
		}
		
	}
}
