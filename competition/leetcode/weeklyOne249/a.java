package leetcode.weeklyOne249;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/14 20:46
 */
public class a {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[i % n];
        }
        return ans;
    }

    public int[] getConcatenation1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[n + i] = nums[i];
        }
        return ans;
    }
}
