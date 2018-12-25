import java.util.LinkedList;
import java.util.List;

/**
 * Created by tianze
 * 2018/12/22 21:24
 */
public class inorderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }

        result = recursive(result, root);
        return result;
    }

    private LinkedList<Integer> recursive(LinkedList<Integer> result, TreeNode root){
        if(root == null){
            return result;
        }

        recursive(result, root.left);
        result.add(root.val);
        recursive(result, root.right);
        return result;
    }
}
