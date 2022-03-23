package daily;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/23 11:17
 */
public class T440 {
    class Solution {
        public int findKthNumber(int n, int k) {
            // 1.字典序，根据数字的前缀进行排序，如 1、10、100、101、、、11、110、、、
            // 2.k小就是字典序前序遍历（从小到大）的第k位
            int i=1;  //i前缀
            int p =1;//作为一个指针，指向字典序当前所在的（从小到大，从1开始计数）下标位置，当p==k时，也就是到了排位第k小的数
            while(p<k) {
                // 获取i前缀的子节点数
                int count = getCount(i, n);
                if(p+count > k) {
                    // k小在i前缀的子节点下
                    // 进一步缩小范围
                    i *= 10;
                    // 把指针指向了字典序的（从小到大，从1开始计数）下标位置，比如1乘10后变成10，指针从1指向了10（下标1->2）
                    p++;
                } else {
                    // k小不在i前缀下
                    i++;
                    p+=count; // 指向字典序的（从小到大，从1开始计数）下标位置
                }
            }
            return i;
        }

        // 计算i前缀的数
        private int getCount(long i, int n) {
            // i前缀的个数
            int count = 0;
            // 下一个前缀
            long p = i + 1;
            while(i<=n) {
                count += Math.min(n + 1, p) - i;
                i *= 10;
                p *= 10;
            }
            return count;
        }
    }
}
