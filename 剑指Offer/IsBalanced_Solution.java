/**
 * Created by tianze
 * 2019/1/3 12:14
 */
public class IsBalanced_Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }

        getDepth(root);

        return flag;
    }

    private int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if(Math.abs(left - right) > 1){
            flag = false;
        }

        return Math.max(left + 1, right + 1);
    }
}
