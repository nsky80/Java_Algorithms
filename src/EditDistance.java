
public class EditDistance {
	public static int editDistance(String s, String t) {
		// Code here
		int sTracker[] = new int[26];
		int tTracker[] = new int[26];

		for (int i = 0; i < 26; i++) {
			sTracker[i] = 0;
			tTracker[i] = 0;
		}

		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i) - 'a');
			sTracker[s.charAt(i) - 'a'] += 1;
		}

		for (int i = 0; i < t.length(); i++) {
			tTracker[t.charAt(i) - 'a'] += 1;
		}

		int diff = 0;

		for (int i = 0; i < 26; i++) {
			if (Math.abs(sTracker[i] - tTracker[i]) > 0) {
				diff += Math.abs(sTracker[i] - tTracker[i]);
			}
		}
		return diff;
	}
	
	public static void main(String [] args) {
		System.out.println(editDistance("geek", "getek"));
		
	}

}
