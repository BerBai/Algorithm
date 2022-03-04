package daily;

import java.util.Arrays;

public class T838 {

    class Solution {
        /**
         '..L' : 左侧都填充L
         'L..L' : 两个L之间要填充L
         'R..L' : R,L之间要双指针夹逼
         'R..R' : 两个R之间填充R
         'R..' : 右侧都填充R
         */
        public String pushDominoes(String dominoes) {
            char[] chars = dominoes.toCharArray();
            // 记录R、L的位置
            int R = -1, L = 0;
            int len = chars.length;
            for(int i=0; i<len; i++) {
                switch(chars[i]) {
                    case 'R':
                        // R..R
                        if(R!=-1) {
                            Arrays.fill(chars, R, i, 'R');
                        }
                        R = i;
                        break;
                    case 'L':
                        // R..L
                        if(R!=-1) {
                            L = i;
                            while(++R<--L) {
                                chars[R] = 'R';
                                chars[L] = 'L';
                            }
                            // 清除R记录
                            R = -1;
                        } else {
                            // ..L 、 L..L
                            Arrays.fill(chars, L, i, 'L');
                        }
                        L = i;
                        break;
                }
            }
            // R..
            if(R != -1) {
                Arrays.fill(chars, R, len, 'R');
            }

            return String.valueOf(chars);
        }
    }
}
