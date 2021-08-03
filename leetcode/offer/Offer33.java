package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/3 12:41
 */
public class Offer33 {
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return dp(postorder, 0, postorder.length - 1);
        }

        boolean dp(int[] postorder, int i, int j) {
            if (i >= j) {
                return true;
            }
            int p = i;
            while (postorder[p] < postorder[j]) {
                p++;
            }
            int m = p;
            while (postorder[p] > postorder[j]) {
                p++;
            }
            return p == j && dp(postorder, i, m - 1) && dp(postorder, m, j - 1);
        }
    }
}
