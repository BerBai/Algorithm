class Solution {
    /** 计算最大正方形的个数
        1. 用hash表记录截取正方形个个数，每次➕1
        2. 遍历过程中记录最大截取正方形
        3. 最后返回hash表中最大的正方形个数
        由此可以实现一次遍历求得结果
     */
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = 0;
        int n = rectangles.length;
        for(int i = 0; i < n; i++) {
            int minNum = Math.min(rectangles[i][0], rectangles[i][1]);
            maxNum = Math.max(maxNum, minNum);
            map.put(minNum,map.getOrDefault(minNum,0)+1);
        }
        return map.get(maxNum);
    }
}