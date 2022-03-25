import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/recover-binary-search-tree/
 * 
 * @author satis
 */

// Definition for binary tree
// Uncomment this section for separate execution
//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//		left = null;
//		right = null;
//	}
//}
//
class Solution {
	public ArrayList<Integer> recoverTree(TreeNode A) {
		ArrayList<Integer> arr = inorderTraversal(A);

		int prev = arr.get(0);
		int i = 1;

		// Here trying to find out the min and max displaced element
		// which are responsible for breaking the sorting chain
		int current_min = Integer.MAX_VALUE;
		int current_max = Integer.MIN_VALUE;
		for (i = 1; i < arr.size(); i++) {
			if (arr.get(i) < prev) {
				if (arr.get(i) < current_min) {
					current_min = arr.get(i);
				}
				if (prev > current_max) {
					current_max = prev;
				}
			} else {
				prev = arr.get(i);
			}
		}

		ArrayList<Integer> res = new ArrayList<>();
		res.add(current_min);
		res.add(current_max);

		return res;

	}

	public static ArrayList<Integer> inorderTraversal(TreeNode A) {
		ArrayList<Integer> arr = new ArrayList<>();

		TreeNode current = A;
		ArrayList<TreeNode> stack = new ArrayList<>();

		while (current != null || stack.size() != 0) {
			if (current != null) {
				stack.add(current);
				current = current.left;
			}

			if (current == null) {
//				stack.rem
				current = stack.remove(stack.size() - 1);
				arr.add(current.val);
				current = current.right;
			}
		}

		return arr;
	}

}

public class RecoverBinarySearchTree {

}
