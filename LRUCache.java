import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by tianze
 * 2019/3/6 14:09
 */
public class LRUCache  {
    class Node{
        Node pre, next;
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int num;
    private HashMap<Integer, Node> map;
    private Node first, last;   //firstΪ��ͷ Ϊɾ���ĵ�һ��Ԫ�� lastΪ��β ���ɾ����Ԫ��

    public LRUCache(int capacity) {
        this.capacity = capacity;
        num = 0;
        map = new HashMap<Integer, Node>();
        first = null;
        last = null;
    }

    public int get(int key) {
        Node node = map.get(key);

        //����Կ������
        if(node == null){
            return -1;
        }
        else if(node != last){
            if(node == first){
                first = first.next;
            }
            else {
                node.pre.next = node.next;
            }

            node.next.pre = node.pre;
            last.next = node;
            node.pre = last;
            node.next = null;
            last = node;
        }

        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if(node == null){
            Node newNode = new Node(key,value);
            if(num >= capacity){
                map.remove(first.key);   //�Ƴ���һ��Ԫ��
                first = first.next;
                if(first != null){
                    first.pre = null;
                }
                else {
                    last = null;
                }
                num--;
            }

            if(first == null || last == null){
                first = newNode;
            }
            else {
                last.next = newNode;
            }

            newNode.pre = last;
            last = newNode;      //����last
            map.put(key, newNode);
            num++;
        }
    }
}
