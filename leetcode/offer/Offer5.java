package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/15 14:26
 */
public class Offer5 {
    public String replaceSpace(String s) {
        StringBuilder ansstr = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                ansstr.append("%20");
            } else {
                ansstr.append(c);
            }
        }
        return ansstr.toString();
    }
}
