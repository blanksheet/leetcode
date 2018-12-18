/**
 * Created by tianze
 * 2018/12/18 15:22
 */
public class Clone {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode cur = pHead;

        while(cur != null){
            RandomListNode pCloned = new RandomListNode(cur.label);
            pCloned.next = cur.next;
            cur.next = pCloned;
            cur = pCloned.next;
        }

        cur = pHead;
        while(cur != null){
            RandomListNode pCloned = cur.next;
            if(cur.random != null){
                pCloned.random = cur.random.next;
            }
            cur = pCloned.next;
        }

        cur = pHead;
        RandomListNode pCloneHead = cur.next;
        RandomListNode pCloneCur = pCloneHead;
        cur.next = pCloneCur.next;
        cur = pCloneCur.next;
        while (cur !=null){
            pCloneCur.next = cur.next;
            pCloneCur = cur.next;
            cur.next = pCloneCur.next;
            cur = pCloneCur.next;
        }

        return pCloneHead;
    }

}
