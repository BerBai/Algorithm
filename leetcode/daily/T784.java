package daily;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/7 21:21
 */
public class T784 {
    class Solution {


        public List<String> letterCasePermutation(String s) {
            List<String> ans = new ArrayList();
            char[] chs = s.toCharArray();
            int n = chs.length;
            dfs(chs, 0, ans);
            return ans;
        }

        public void dfs(char[] chs, int index, List<String> ans) {
            if (index == chs.length) {
                ans.add(String.valueOf(chs));
                return;
            }
            char cur = chs[index];
            if (Character.isDigit(cur)) {   //是数字不用管 直接index+1 继续dfs
                dfs(chs, index + 1, ans);
            } else if (Character.isLetter(chs[index])) {    //是字母的话 先变为大写  dfs下去
                chs[index] = Character.toUpperCase(chs[index]);
                dfs(chs, index + 1, ans);                        //将大写处理的字母进行回溯
                chs[index] = Character.toLowerCase(chs[index]);  //变为小写 继续dfs
                dfs(chs, index + 1, ans);
            }
        }
    }
}
