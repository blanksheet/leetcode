import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by tianze
 * 2018/12/13 20:56
 */
public class maxDepth {

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    //recursive function
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left),maxDepth(root.right)+1);
    }
    //traverse function;

    public static int maxDepth2(TreeNode root){
        if(root == null){
            return 0;
        }

       LinkedList<TreeNode> data = new LinkedList<>();

        int level = 1;
        int curTree = 1;
        int nextLevelTree = 0;

        data.add(root);

        while(data.size() != 0){
            TreeNode temp = data.pop();
            curTree--;

            if(temp.left != null){
                data.add(temp.left);
                nextLevelTree++;
            }

            if(temp.right != null){
                data.add(temp.right);
                nextLevelTree++;
            }

            if(curTree == 0){
                curTree = nextLevelTree;
                nextLevelTree = 0;
                level++;
            }

        }

        return level - 1;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;

        System.out.println(maxDepth2(node1));
    }


}
