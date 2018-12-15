import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by tianze
 * 2018/12/15 11:18
 */
public class PrintFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        LinkedList<TreeNode> data = new LinkedList<>();
        data.add(root);

        while(data.size() != 0){
            TreeNode temp = data.poll();

            result.add(temp.val);

            if(temp.left != null){
                data.add(temp.left);

            }
            if(temp.right != null){
                data.add(temp.right);

            }
        }

        return result;
    }
}

