package daily;

import java.util.Arrays;

public class T1984 {

    class Solution {
        public int minimumDifference(int[] nums, int k) {
            if(k==1 || nums.length == 1) {
                return 0;
            }

            Arrays.sort(nums);
            int ans = nums[nums.length-1];
            for(int l=0,r=k-1;r<nums.length;) {
                ans = Math.min(ans, nums[r++]-nums[l++]);
            }
            return ans;
        }
    }
}
