/**
 * Created by tianze
 * 2018/12/18 17:22
 */
public class Convert2 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode pLastNodeInList = convertNode(pRootOfTree,null);
        while (pLastNodeInList != null && pLastNodeInList.left != null){
            pLastNodeInList = pLastNodeInList.left;
        }
        return pLastNodeInList;
    }

    private static TreeNode convertNode(TreeNode pNode, TreeNode pLastNodeInList){
        if(pNode == null){
            return null;
        }

        if(pNode.left != null){
            pLastNodeInList = convertNode(pNode.left, pLastNodeInList);
        }
        pNode.left = pLastNodeInList;

        if(pLastNodeInList != null){
            pLastNodeInList.right = pNode;
        }
        pLastNodeInList = pNode;
        if(pNode.right != null){
           pLastNodeInList = convertNode(pNode.right, pLastNodeInList);
        }

        return pLastNodeInList;
    }

    public  static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(12);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(11);
        TreeNode treeNode7 = new TreeNode(14);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        Convert(treeNode1);
    }



}
