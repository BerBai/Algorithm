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
            if(num==0) {
                break;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.intToRoman(4));
    }
}
