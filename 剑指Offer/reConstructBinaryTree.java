/**
 * Created by tianze
 * 2018/12/7 20:44
 */
public class reConstructBinaryTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;
        }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
            if(pre == null || pre.length == 0 || in == null || in.length==0){
                return null;
            }
            return construct(pre,in,0,pre.length-1,0,in.length-1);

    }

    public TreeNode construct(int[] pre,int[] in, int startPre,int endPre,int startIn,int endIn){
            if(startPre > endPre || startIn > endIn){
                return null;
            }

            TreeNode root = new TreeNode(pre[startPre]);

            for(int i = startIn; i <= endIn; i++){
                if(pre[startPre] == in[i]){
                    root.left = construct(pre,in,startPre+1,startPre+i-startIn,startIn,i-1);
                    root.right = construct(pre,in,i-startIn+startPre+1,endPre,i+1,endIn);
                }
            }
            return root;
    }

    }
}
