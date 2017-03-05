package practice;

public class PrimeNumberWheel {
	public int countPrimes(int n1,int n2){
		if(n1%2==0) n1++;
		int count = 0;
		for(int i=n1;i<=n2;i++){
			if(isPrime(i)){
				count++;
			}
		}
		return count;
	}	
	public boolean isPrime(int a){
		for(int i =3;i<Math.sqrt(a);i+=2){
			if(a%i==0){
				return false;
			}
		}
		return true;
		
	}
	
	
}


	
