import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return -1;
        }

        int first;
        int second;
        final Stack<Integer> stack = new Stack<Integer>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    first = stack.pop();
                    second = stack.pop();

                    stack.push(second - first);
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    first = stack.pop();
                    second = stack.pop();

                    stack.push(second / first);
                    break;

                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println((new Solution()).evalRPN(tokens));

    }

}
