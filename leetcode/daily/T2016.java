package daily;

public class T2016 {
    
}

class Solution {
    /**
     * 快慢指针，快指针每次+1，在判断慢指针元素比快指针大或等于时更新慢指针
     * @param nums
     * @return
     */
    public int maximumDifference(int[] nums) {
        int ans = -1, len = nums.length;
        for(int l=0,r=1;r<len;r++) {
            if(nums[r] <= nums[l]) {
                l = r;
            } else {
                ans = Math.max(ans, nums[r] - nums[l]);
            }
        }
        return ans;
    }
}