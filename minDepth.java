import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by tianze
 * 2018/12/19 16:58
 */
public class minDepth {
    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public static int minDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> data = new LinkedList<>();
        data.push(root);

        int curRoot = 1;
        int nextRoot = 0;
        int minLayer = 1;

        while(data.size() != 0){
            TreeNode temp = data.poll();
            curRoot--;

            if(temp.right == null && temp.left == null){
                return minLayer ;
            }



            if(temp.left != null){
                data.add(temp.left);
                nextRoot++;
            }

            if(temp.right != null){
                data.add(temp.right);
                nextRoot++;
            }

            if(curRoot == 0){
                minLayer++;
                curRoot = nextRoot;
                nextRoot = 0;
            }



        }

        return 0;
    }
    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null || root.right == null){
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;

        if(root.left != null){
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if(root.right != null){
            minDepth = Math.min(minDepth(root.right), minDepth);
        }

        return minDepth + 1;
    }
}
