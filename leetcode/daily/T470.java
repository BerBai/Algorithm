package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/5 16:00
 */
public class T470 {

    private class SolBase {
        public int rand7() {
            return 7;
        }
    }

    // 10次rand7，平均概率1/10
    class Solution extends SolBase {
        public int rand10() {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += rand7();
            }
            return sum % 10 + 1;
        }
    }


    /**
     * 古典概型
     * 1. 第一次rand7限定[1,6]，判断奇偶性，概率是1/2
     * 2. 第二次rand7限定[1,5]，概率是1/5
     * 3. 二者结合可以得出10种概率相同的结果
     */
    class Solution2 extends SolBase {
        public int rand10() {
            int first, second;
            while ((first = rand7()) > 6) ;
            while ((second = rand7()) > 5) ;
            return (first & 1) == 1 ? second : 5 + second;
        }
    }
}
