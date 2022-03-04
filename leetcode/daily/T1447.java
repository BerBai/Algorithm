package daily;

import java.util.ArrayList;
import java.util.List;

public class T1447 {
    class Solution {
        public int simplify(int a, int b) {
            if (b % a == 0) {
                return a;
            }
            return simplify(b, a % b);
        }

        public List<String> simplifiedFractions(int n) {
            if (n == 1) {
                return new ArrayList<>();
            }
            List<String> ans = new ArrayList<>();

            for (int i = 1; i < n; i++) {
                for (int j = i+1; j <= n; j++) {
                    if (simplify(i, j) == 1) {
                        ans.add(i + "/" + j);
                    }
                }
            }
            return ans;
        }
    }
}