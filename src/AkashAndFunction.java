import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AkashAndFunction {

	static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

	static int getMaxDistinctElements(int n) {
		return n / 2 + n % 2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			System.out.println(getMaxDistinctElements(Integer.parseInt(br.readLine())));
		}

		br.close();
	}

}
