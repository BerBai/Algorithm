package top100.dictionaryOrder;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/30 11:53
 */
public class T034 {
    /**
     * 题：https://leetcode-cn.com/problems/lwyVBB/
     * 按照给定字典序列进行对比排序，返回对比结果
     *
     * @author ber
     * @version 1.0
     * @description: TODO
     * @date 22/3/30 12:11
     */

    // 记录转换后的字典序列 按照常规数值大小进行赋值
    private int[] index = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        int i = 0;
        // 转换成易理解的序列
        for (char w : order.toCharArray()) {
            index[getIndex(w)] = i++;
        }
        for (i = 0; i < words.length - 1; i++) {
            // 对比排序
            if (!compare(words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }

    // 按照字典序定义排序规则
    private boolean compare(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int i = 0;
        while (i < len1 && i < len2) {
            int a = index[getIndex(s1.charAt(i))], b = index[getIndex(s2.charAt(i))];
            if (a != b) {
                return a < b;
            }
            i++;
        }
        return i == len1;
    }

    private int getIndex(char w) {
        return w - 'a';
    }
}
