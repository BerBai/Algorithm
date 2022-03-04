public class T717 {
    
}

/**
 * 最后一个字符编码必须是一位字符
 * 决定最后一位是否单独成为一个编码，取决于最后的0前面的连续1的个数，如果成偶数，则符合；反之则不符合。
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length-2;
        int count = 0;
        while(n>=0 && bits[n]==1) {
            count++;
            n--;
        }
        if(count%2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}