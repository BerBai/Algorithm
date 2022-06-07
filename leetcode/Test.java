import java.util.*;

/**
 * @author ber
 * @version 1.0
 * @date 22/4/2 10:35
 */
public class Test {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            while (num >= value) {
                num -= value;
                ans.append(symbols[i]);
            }
            if (num == 0) {
                break;
            }
        }
        return ans.toString();
    }

    public void equalsTest(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        s2 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        int ii1 = 1;
        int ii2 = 1;
        System.out.println(ii1 == ii2);

        Integer i1 = new Integer(12);
        Integer i2 = new Integer(12);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));


        int int1 = 12;
        int int2 = 12;

        Integer integer1 = new Integer(12);
        Integer integer2 = new Integer(12);
        Integer integer21 = 12;
        Integer integer3 = new Integer(127);

        Integer a1 = 127;
        Integer a2 = 127;

        Integer a = 128;
        Integer b = 128;

        System.out.println("int1 == int2 -> " + (int1 == int2));
        System.out.println("int1 == integer1 -> " + (int1 == integer1));
        System.out.println("integer1 == integer2 -> " + (integer1 == integer2));
        System.out.println("integer2 == integer21 -> " + (integer2 == integer21));
        System.out.println("integer3 == a1 -> " + (integer3 == a1));
        System.out.println("a1 == integer3 -> " + (a1 == integer3));
        System.out.println("a1 == a2 -> " + (a1 == a2));
        System.out.println("a == b -> " + (a == b));
    }

    public static void main(String[] args) {
        int i = 10;
        double d = 10;
        System.out.println(i == d);

        int A = 1;
        int B = 2;
        swap(A, B);
        System.out.println("外部" + A + "---" + B);

        String strA = "a";
        String strB = "a";
        System.out.println(strA == strB);

        strA = new String("a");
        strB = new String("a");
        System.out.println(strA == strB);

        String strC = new String("a") + new String("b");
        String intermC = strC.intern();
        String strD = "ab";
        System.out.println(strD == strC);
        System.out.println(strD == intermC);

        int[] ints = new Solution().quickSort(new int[]{2, 5, 2, 8, 10}, 0, 4);
        for (int item : ints) {
            System.out.print(item + " ");
        }
    }

    private static void swap(int A, int B) {
        int tmp = A;
        A = B;
        B = tmp;
        System.out.println("内部" + A + "---" + B);
    }

    static class Solution {
        public int[] quickSort(int[] data, int startIndex, int endIndex) {
            if (startIndex >= endIndex) {
                return data;
            }
            int pivotIndex = startIndex;
            int compareIndex = endIndex; // 基数
            int step = 1;
            while (pivotIndex != compareIndex) {
                int compareResult = data[pivotIndex] <= data[compareIndex] ? 1 : -1;
                if (compareResult != step) {
                    int buff = data[pivotIndex];
                    data[pivotIndex] = data[compareIndex];
                    data[compareIndex] = buff;
//                    step *= -1;
//                    pivotIndex = compareIndex;
                }
//                pivotIndex += step;
                pivotIndex++;
            }
            quickSort(data, startIndex, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, endIndex);
            return data;
        }
    }
}

class tmp {
    public static void main(String[] args) {
        String s = "010101";
        int len = s.length();
        int[] a = new int[len];
        char[] chars = s.toCharArray();

        a[0] = chars[0] == '1' ? 1 : 0;
        int sum = a[0];
        for (int i = 1; i < len; i++) {
            if (chars[i] != chars[i - 1]) {
                a[i] = 1;
            } else {
                a[i] = a[i - 1] + 1;
            }
            sum += a[i];
        }
        System.out.println(sum);
    }
}
