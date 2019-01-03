import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by tianze
 * 2019/1/3 12:05
 */
public class TreeDepth {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> linkedList = new LinkedList();
        int layer = 0;
        int curTree = 1;
        int nextTree = 0;

        linkedList.add(root);

        while (linkedList.size() != 0){
            TreeNode treeNode = linkedList.poll();
            curTree--;

            if(treeNode.left != null){
                linkedList.add(treeNode.left);
                nextTree++;
            }

            if(treeNode.right != null){
                linkedList.add(treeNode.right);
                nextTree++;
            }

            if(curTree == 0){
                layer++;
                curTree = nextTree;
                nextTree = 0;
            }
        }

        return layer;
    }
}
