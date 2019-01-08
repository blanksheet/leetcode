/**
 * Created by tianze
 * 2019/1/8 14:42
 */
public class isSymmetrical {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }

        return helper(pRoot.left, pRoot.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }
        else {
            return helper(left.left, right.right) && helper(left.right,right.left);
        }
    }

}
