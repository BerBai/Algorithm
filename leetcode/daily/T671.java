package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/27 08:54
 */
public class T671 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。 --> 根节点永远是最小的一个
    class Solution {
        int ans, rootValue;

        public int findSecondMinimumValue(TreeNode root) {
            ans = -1;
            rootValue = root.val;
            dfs(root);
            return ans;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            if (ans != -1 && root.val >= ans) {
                return;
            }
            if (root.val > rootValue) {
                ans = root.val;
            }
            dfs(root.left);
            dfs(root.right);
        }

    }
}
