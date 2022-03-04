import java.util.HashMap;
import java.util.Map;

public class T1189 {
    
}

class Solution {
    public int maxNumberOfBalloons(String text) {
        
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<text.length();i++) {
            map.put(text.charAt(i),map.getOrDefault(text.charAt(i), 0)+1);
        }
        
        int ans = Math.min(map.getOrDefault('a',0),map.getOrDefault('b', 0));
        ans = Math.min(ans, map.getOrDefault('n', 0));
        ans = Math.min(ans, map.getOrDefault('l', 0)/2);
        ans = Math.min(ans, map.getOrDefault('o', 0)/2);
        return ans;
    }
}