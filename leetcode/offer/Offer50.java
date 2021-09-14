package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/14 15:36
 */
public class Offer50 {
    class Solution {
        public char firstUniqChar(String s) {
            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            }
            for (int i = 0; i < chars.length; i++) {
                if (map.get(chars[i]) == 1) {
                    return chars[i];
                }
            }
            return ' ';
        }
    }
}
