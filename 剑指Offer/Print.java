import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by tianze
 * 2019/1/8 14:49
 */
public class Print {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(pRoot == null){
            return result;
        }

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(pRoot);
        ArrayList<Integer> first = new ArrayList<>();
        first.add(pRoot.val);
        result.add(first);

        int layer = 1;
        int curLayer = 1;
        int nextLayer = 0;

        while (treeNodes.size() != 0){
            TreeNode temp = treeNodes.poll();
            curLayer--;

            if(temp.left != null){
                treeNodes.add(temp.left);
                nextLayer++;
            }
            if(temp.right != null){
                treeNodes.add(temp.right);
                nextLayer++;
            }

            if(curLayer == 0){
                layer++;
                curLayer = nextLayer;
                nextLayer = 0;
                if(curLayer == 0){
                    break;
                }
                ArrayList<Integer> arrayList = new ArrayList<>();
                if(layer % 2 == 0){
                    for(int i = treeNodes.size() - 1; i >= 0; i--){
                        arrayList.add(treeNodes.get(i).val);
                    }
                }
                else {
                    for(TreeNode treeNode : treeNodes){
                        arrayList.add(treeNode.val);
                    }
                }
                result.add(arrayList);
            }
        }

        return result;
    }
}
