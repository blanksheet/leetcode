import java.util.Stack;
/**
 * Created by tianze
 * 2018/12/14 17:30
 */
public class Solution {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();


    public void push(int node) {
        stack.push(node);

        if(minStack.empty() || node < minStack.peek()){
            minStack.push(node);
        }
        else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if(!stack.empty() && !minStack.empty()){
            stack.pop();
            minStack.pop();
        }

    }

    public int top() {
        if(!stack.empty() && !minStack.empty()){
            return minStack.peek();
        }
        return (Integer)null;
    }

    public int min() {
        if(!stack.empty() && !minStack.empty()){
            return minStack.peek();
        }
        return (Integer)null;
    }
}
