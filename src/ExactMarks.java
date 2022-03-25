import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ExactMarks {
//	static long count;

	public static long[] checkExactMarksHelper(long N, long X, HashMap<String, long[]> memo) {
		if (N == 0 || (N + X) < 0 || (X - N * 3) > 0) {
			if (X == 0) {
				long[] arr = new long[3];
				return arr;
			} else {
				return null;
			}
		}

		String key = Long.toString(N) + "," + Long.toString(X);

		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		long arr[] = null;

		arr = checkExactMarksHelper(N - 1, X - 3, memo);

		if (arr != null) {
			arr[0] += 1;
			return arr;
		}

		// negative
		arr = checkExactMarksHelper(N - 1, X + 1, memo);

		if (arr != null) {
			arr[1] += 1;
			return arr;
		}

		// no operation
		arr = checkExactMarksHelper(N - 1, X, memo);
		if (arr != null) {
			arr[2] += 1;
			return arr;
		}

		memo.put(key, arr);

		return arr;
	}

	public static long[] checkExactMarks1(long N, long X) {

		HashMap<String, long[]> memo = new HashMap<>();
		return checkExactMarksHelper(N, X, memo);
	}

	public static void checkExactMarks2(long n, long x) {
		int counter[] = new int[3];

		for (long i = n; i >= 1; i--) {
			x -= 3;
			counter[0] += 1;

			if (x < 0) {
				if ((i - 1 + x) >= 0) {
					continue;
				} else {
					x += 3;
					counter[0] -= 1;
				}
			} else {
				continue;
			}

			x += 1;
			counter[1] += 1;
			if (x > 0) {
				if (Math.abs(3 - x) + 1 <= i - 1) {
					continue;
				} else {
					x -= 1;
					counter[1] -= 1;
				}
			} else {
				continue;
			}

			counter[2] += 1;
		}

		if (x == 0) {
			System.out.println("YES\n" + counter[0] + " " + counter[1] + " " + counter[2]);
		} else {
			System.out.println("NO");
		}

	}

	public static void checkExactMarks(long n, long x) {
		long counter[] = new long[3];

		counter[0] = x / 3;
		n -= counter[0];
		x -= (counter[0] * 3);

		counter[1] = x;
		if (counter[1] != 0 && Math.abs(3 - counter[1]) + 1 < n) {
			x = 0;
			n -= (Math.abs(3 - counter[1]) + 1);
			counter[0] += 1;
		}
		
		counter[2] = n;
		
		if (x == 0) {
			System.out.println("YES\n" + counter[0] + " " + counter[1] + " " + counter[2]);

		} else {
			System.out.println("NO");
		}

	}

	private static void printArr(long[] arr) {
		if (arr == null) {
			System.out.println("NO");
		} else {
			System.out.println("YES\n" + arr[0] + " " + arr[1] + " " + arr[2]);
		}
	}

	public static void main(String[] args) throws IOException {

		checkExactMarks(10, 30);
		checkExactMarks(9, 25);
		checkExactMarks(8, 0);
		checkExactMarks(8991, 1);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int t = Integer.parseInt(br.readLine());
//
//		for (int i = 0; i < t; i++) {
//			String[] s = br.readLine().split(" ");
//			checkExactMarks(Long.parseLong(s[0]), Long.parseLong(s[1]));
//		}
//
//		br.close();
	}

}