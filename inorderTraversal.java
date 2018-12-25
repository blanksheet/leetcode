import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> inorderTraversal2(TreeNode root){
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.empty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }

        }

        return result;
    }

}
