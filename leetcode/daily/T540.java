public class T540 {
    
}

// 假设最后一个数是单数，先赋值给ans
// 再+2遍历数组，对比nums[i] nums[i+1]，如果是单数则更新
// 否则，则假设成立
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int ans = nums[n-1];
        for(int i=0; i<n-1; i+=2) {
            if(nums[i] != nums[i+1]) {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }
}