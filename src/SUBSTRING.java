import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SUBSTRING {

	static void computeLPSArray(String pat, int n, int lps[]) {
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to M-1
		while (i < n) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else // (pat[i] != pat[len])
			{
				if (len != 0) {
					len = lps[len - 1];

				} else {
					lps[i] = len;
					i++;
				}
			}
		}
	}

	public static void computeVisited(int lps[], boolean isVisited[], int n) {
		int i = n - 1;

		while (i >= 0) {
			if (lps[i] != 0) {
				for (int j = i; j > i - lps[i]; j--) {
					isVisited[j] = true;
					isVisited[i - j] = true;
				}
				i -= lps[i];
			} else {
				i--;
			}
		}
	}

	public static int getMaximumSubstr(String str) {
		int n = str.length();
//    	int lps[] = new int[n];
//    	boolean isVisited[] = new boolean[n];
//    	computeLPSArray(str, n, lps);
//    	computeVisited(lps, isVisited, n);

		int maxTill = -1;
		int maxCount = 0;

		for (int i = 0; i < n; i++) {
			if (str.charAt(i) != str.charAt(0) && str.charAt(i) != str.charAt(n - 1)) {
				maxCount++;
			} else {
				maxTill = Math.max(maxCount, maxTill);
				maxCount = 0;
			}
		}

		maxTill = Math.max(maxTill, maxCount);

		return maxTill != 0 ? maxTill : -1;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			System.out.println(getMaximumSubstr(br.readLine()));
		}

		br.close();
	}

}
