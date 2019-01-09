import java.util.LinkedList;

/**
 * Created by tianze
 * 2019/1/9 14:59
 */
public class KthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k <= 0){
            return null;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        helper(linkedList,pRoot);

        if(k > linkedList.size()){
            return null;
        }
        return linkedList.get(k - 1);

    }

    void helper( LinkedList<TreeNode> linkedList, TreeNode pRoot){
        if(pRoot == null){
            return;
        }

        helper(linkedList, pRoot.left);
        linkedList.add(pRoot);
        helper(linkedList, pRoot.right);
    }
}
