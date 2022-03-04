// 连续子数组最大值与最小值的差值和
class Solution {
    // 模拟求解
    public long subArrayRanges(int[] nums) {
        long  ans = 0;
        int ma, mi;
        for(int i = 0;i<nums.length;i++) {
            ma = nums[i];
            mi = nums[i];
            for(int j=i+1;j<nums.length;j++) {
                ma = Math.max(ma, nums[j]);
                mi = Math.min(mi, nums[j]);
                ans += (ma - mi);
            }
        }
        return ans;
    }
}