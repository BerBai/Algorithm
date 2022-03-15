package offer;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/15 12:06
 */
public class Offer62 {
    class Solution {
        public int lastRemaining(int n, int m) {
            if(n < 1 || m < 1) return -1;
            return (lastRemaining(n-1, m) +m)%n;
        }
    }

    class Solution2 {
        public int lastRemaining(int n, int m) {
            if(n <1 || m <1) {
                return -1;
            }
            int last = 0;
            for(int i=2;i<=n;i++) {
                last = (last + m) % i;
            }
            return last;
        }
    }
}
