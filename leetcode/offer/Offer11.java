package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/18 10:34
 */
public class Offer11 {
    class Solution {
        public int minArray1(int[] numbers) {
            int ans = (int) 1e9;
            for (int number : numbers) {
                ans = Math.min(ans, number);
            }
            return ans;
        }

        // 二分法
        public int minArray2(int[] numbers) {
            int l = 0, r = numbers.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] < numbers[r]) {
                    r = mid;
                } else if (numbers[mid] > numbers[r]) {
                    l = mid + 1;
                } else {
                    // 针对于元素相等的情况
                    r--;
                }
            }
            return numbers[l];
        }
    }
}
