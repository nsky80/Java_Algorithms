import java.util.Scanner;

public class Experiment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			System.out.println(getTheSplit(n));
		}
		sc.close();
	}

	private static int getTheSplit(int n) {
		// TODO Auto-generated method stub
		// get the nearest log term
		int log2 = (int) Math.ceil(Math.log(n) / Math.log(2));
//		System.out.println("Here: " + log2);
		if((int)Math.pow(n, log2) - 1 == n || n == 0) {
			return 0;
		}
		return 1;
	}
	
}
