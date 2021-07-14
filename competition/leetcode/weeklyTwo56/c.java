package leetcode.weeklyTwo56;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/11 16:46
 */
public class c {

    public static boolean sumGame(String num) {
        int n = num.length(), x = 0, A = 0, B = 0;
        for (int i = 0; i < n >> 1; i++) {
            if (num.charAt(i) == '?') {
                A++;
            } else {
                x+=num.charAt(i)^48;
            }
        }
        for (int i = n >> 1; i < n; i++) {
            if (num.charAt(i) == '?') {
                B++;
            } else {
                x-=num.charAt(i)^48;
            }
        }
        if(((A+B)&1) == 1) {
            return true;
        }
        return 9*((A-B)>>1)+x !=0;
    }

    public static void main(String[] args) {
        System.out.println(c.sumGame("5023"));
        System.out.println(c.sumGame("25??"));
        System.out.println(c.sumGame("?3295???"));
    }
}
