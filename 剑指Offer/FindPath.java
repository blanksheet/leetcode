import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tianze
 * 2018/12/17 14:05
 */
public  class FindPath {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Stack<Integer> path = new Stack<>();
        result = recursive(result, root, path, target, 0);
        return result;
    }

    private static ArrayList<ArrayList<Integer>> recursive(ArrayList<ArrayList<Integer>> result, TreeNode root, Stack<Integer> path, int target, int curSum){
        if(root == null){
            return result;
        }
        curSum += root.val;
        path.push(root.val);

        boolean isLeaf = root.left == null && root.right == null;

        if(curSum == target && isLeaf){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < path.size(); i++){
                temp.add(path.elementAt(i));
            }
            result.add(temp);
        }

        recursive(result, root.left, path, target, curSum);
        recursive(result, root.right, path, target, curSum);

        path.pop();
        curSum -= root.val;

        return result;

    }

    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(12);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        FindPath(treeNode1,22);

    }


}
