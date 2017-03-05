package hw;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 31;
		for (int i = 1; i < 1000; i++) {
			int b = (a + i * i) % 8;
			if (!(b == 3 || b == 0 || b == 7)) {
				System.out.println(i+" "+b);
			}
			
		}System.out.println("null");
	}

}
