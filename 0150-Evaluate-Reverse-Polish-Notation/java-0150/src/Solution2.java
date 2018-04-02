// 递归法 排名第一的版本



class Solution2 {
    private int curr;
    public int evalRPN(String[] tokens) {
        curr = tokens.length - 1;
        return eval(tokens);
    }

    private int eval(String[] tokens) {
        String token = tokens[curr--];
        char c = token.charAt(0);
        if (token.length() == 1 && isOp(c)) {
            int b = eval(tokens);
            int a = eval(tokens);
            return applyOp(c, a, b);
        } else {
            return Integer.parseInt(token);
        }
    }

    private boolean isOp(char c) {
        switch (c) {
            case '+': case '-': case '*': case '/': return true;
        }
        return false;
    }

    private int applyOp(char op, int a, int b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return a;
    }
}