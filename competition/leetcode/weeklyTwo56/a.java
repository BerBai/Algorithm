package leetcode.weeklyTwo56;


import java.util.Scanner;


import java.util.LinkedList;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/11 11:16
 */
public class a {

    public static int countTriples(int n) {
        int ans = 0;
        LinkedList<Integer> c = new LinkedList<>();
        // 先计算c*c
        for (int i = 1; i <= n; i++) {
            c.push(i * i);
        }
        // 再统计符合条件的数，降低复杂度
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (c.contains(i * i + j * j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        while (input.hasNext()){
            int n = input.nextInt();
            System.out.println(a.countTriples(n));
        }
    }
}
