package practice;

public class Dice_Probability {
	public static void main(String[] args) {
		int[] arr = new int[100];
		
		for(int j =0;j<100000000;j++){
			int num = 0;
			for(int i = 0; i< 16;i++){
				 num += Math.random()*6+1;
			}
			arr[num] ++;
		}
		for(int k = 0;k<arr.length;k++){
			System.out.println(k+": "+arr[k]);
		}
	}
}
