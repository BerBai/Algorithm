package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/14 08:57
 */
public class T1583 {
    /**
     * 比如，x 爱着 u ，却把 x 和 y 组成了一队，同时，u 也爱着 x，却把 u 和 v 组成了一队，这时候 x 和 u 都是不开心的【我爱着你，你也爱着我，却把我们俩分开】。
     * <p>
     * 所以，针对每个 x 我们先找到和他组队的人y，看 x 的亲近程度列表中有没有比 y 更高的，如果有，再看这些人 u与 x 的亲密程度是否比跟他们组队的人 v 更高，如果是，则 x 就是不开心的。
     * <p>
     * 因为，在这个过程中，我们需要快速地找到与 u 配对的 v ，以及 u与 x 的亲密程度是否比 v 高，所以，我们要先整理数据，保存每个人的配对情况及亲密程度情况，一般来说，我们使用哈希表是可以的，但是，本题限定了范围是 0~n-1，所以，我们直接使用两个数组即可。
     */
    class Solution {
        public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
            // close[i][j]表示 i 和 j 的亲密程度
            int[][] close = new int[n][n];
            // teammate[i]表示 i 的队友是谁
            int[] teammate = new int[n];
            // 整理亲密程度
            for (int i = 0; i < preferences.length; i++) {
                for (int j = 0; j < preferences[i].length; j++) {
                    // 数值越小越亲近
                    close[i][preferences[i][j]] = j;
                }
            }
            // 整理配对情况
            for (int[] pair : pairs) {
                teammate[pair[0]] = pair[1];
                teammate[pair[1]] = pair[0];
            }

            // 使用set一次可以找到两个人
            // 但是运行时间更慢了
            // 所以我们不是一个一个找
            int ans = 0;

            // 遍历所有的n个人
            for (int x = 0; x < n; x++) {
                // 找到 x 的队友 y
                int y = teammate[x];
                // 看看有没有亲密程度排在y之前的，即可能的u
                for (int u : preferences[x]) {
                    if (u == y) {
                        break;
                    }
                    // 在y之前找到一个可能的u
                    // 看u与x的亲密程度是否大于u的队友v
                    int v = teammate[u];
                    if (close[u][x] < close[u][v]) {
                        ans++;
                        // x已经确定不开心了，寻找下一个吧
                        break;
                    }
                }
            }

            return ans;
        }
    }

    /**
     * 通过方法一，其实我们可以看到当 x 和 u 同时爱着对方胜过爱其他人的时候才判定 x 为不开心（这时候 u 也是不开心的），但是模拟真实场景，有可能只是 x 爱着 u ，但是 u 并不爱 x，这时候是无法判定 x 为不开心的。
     * <p>
     * 所以，我们引入一个新的概念——单方面不开心，只有满足 x 和 u 两个同时“单方面不开心”时，才判定x不开心，其实，这时候 u 也是不开心的。
     */
    class Solution2 {
        public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
            // 单方面不开心
            boolean[][] unhappyOnly = new boolean[n][n];
            for (int[] pair : pairs) {
                preProcess(unhappyOnly, preferences, pair[0], pair[1]);
                preProcess(unhappyOnly, preferences, pair[1], pair[0]);
            }

            int ans = 0;
            for (int i = 0; i < unhappyOnly.length; i++) {
                for (int j = 0; j < unhappyOnly[i].length; j++) {
                    // 两者都单方面不开心的时候，即判定i不开心，其实j也是不开心的
                    // 这里使用HashSet同时把i和j加进去，做个去重也是可以的
                    // 但是，运行时间还变长了，所以，这里还是一个一个遍历
                    if (unhappyOnly[i][j] && unhappyOnly[j][i]) {
                        ans++;
                        break;
                    }
                }
            }

            return ans;
        }

        private void preProcess(boolean[][] unhappyOnly, int[][] preferences, int x, int y) {
            // 只要和我组队的人不是更亲近的人，我就单方面不开心
            for (int u : preferences[x]) {
                if (u != y) {
                    unhappyOnly[x][u] = true;
                } else {
                    // 遍历到y就停止
                    break;
                }
            }
        }
    }
}
