import java.util.LinkedList;
import java.util.List;

/**
 * Created by tianze
 * 2019/3/4 11:24
 */
public class preorderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    //µ›πÈ–¥∑®
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }

        helper(root, result);

        return result;
    }

    private void helper(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }

    //∑«µ›πÈ–¥∑®
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }

        LinkedList<TreeNode> trees = new LinkedList<>();

        while (root != null || !trees.isEmpty()){
           if(root != null){
               result.add(root.val);
               trees.push(root);
               root = root.left;
           }
           else {
               TreeNode node = trees.pop();
               root = node.right;
           }
        }

        return result;
    }
}
