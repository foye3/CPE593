package practice;

public class Greatest_Common_Divisor {
	public int gcd(int a,int b){
		while(b!=0){
			int temp = a;
			a = b;
			b =b%temp;
		}
		return a;
	}
	
	
	//least common multiple
	public int lcm(int a,int b){
		return a*b/gcd(a,b);
	}
	
	
	
}
