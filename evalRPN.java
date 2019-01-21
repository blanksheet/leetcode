import java.util.Stack;

/**
 * @Author: tianze
 * @Date: 2019/1/21 11:16
 */
public class evalRPN {
    public static int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack();

        for(String temp : tokens){
            if(temp.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }
            else if(temp.equals("-")){
                stack.push(-stack.pop() + stack.pop());
            }
            else if(temp.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else if(temp.equals("/")){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second / first);
            }
            else {
                stack.push(Integer.parseInt(temp));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args){
        String[] s = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(s));
    }
}
