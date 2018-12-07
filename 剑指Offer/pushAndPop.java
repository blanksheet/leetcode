import java.util.Stack;

/**
 * Created by tianze
 * 2018/12/7 19:56
 */
public class pushAndPop {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }

        if(stack2.empty()){
            // the queue is empty
        }

        return stack2.pop();
    }
}
