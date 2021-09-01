package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/1 07:44
 */
public class T165 {
    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] v1s = version1.split("\\.");
            String[] v2s = version2.split("\\.");
            for (int i = 0; i < v1s.length || i < v2s.length; i++) {
                int x = 0, y = 0;
                if (i < v1s.length) {
                    x = Integer.parseInt(v1s[i]);
                }
                if (i < v2s.length) {
                    y = Integer.parseInt(v2s[i]);
                }
                if (x < y) {
                    return -1;
                }
                if (x > y) {
                    return 1;
                }
            }
            return 0;
        }
    }

    class Solution2 {
        public int compareVersion(String version1, String version2) {
            int n1 = version1.length(), n2 = version2.length();
            int i = 0, j = 0;
            while (i < n1 || j < n2) {
                int x = 0;
                for (; i < n1 && version1.charAt(i) != '.'; i++) {
                    x = x * 10 + version1.charAt(i) - '0';
                }
                i++;
                int y = 0;
                for (; j < n2 && version2.charAt(j) != '.'; j++) {
                    y = y * 10 + version2.charAt(j) - '0';
                }
                j++;
                if (x < y) {
                    return -1;
                }
                if (x > y) {
                    return 1;
                }
            }
            return 0;
        }
    }
}
