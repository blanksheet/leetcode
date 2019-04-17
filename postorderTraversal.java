import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tianze on 2019/4/17.
 */
public class postorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> data = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return data;
        }
        /*postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return data;*/

        Stack<TreeNode> stack = new Stack();
        Stack<TreeNode> result = new Stack<>();

        stack.push(root);

        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            result.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        while (!result.empty()){
            data.add(result.pop().val);
        }

        return data;
    }
}
