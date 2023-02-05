// https://leetcode.com/problems/basic-calculator-ii/
class Solution {

    public int calculate(String s) {

        if (s.length() == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();

        char operation = '+';

        int num = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                num = num * 10 + (ch - '0');

            }

            if (i == s.length() - 1 || !Character.isDigit(ch) && !Character.isWhitespace(ch)) {

                switch (operation) {

                    case '+':

                        stack.push(num);
                        break;

                    case '-':

                        stack.push(-num);
                        break;

                    case '*':

                        stack.push(stack.pop() * num);
                        break;

                    case '/':

                        stack.push(stack.pop() / num);
                        break;

                }

                num = 0;
                operation = ch;

            }

        }

        int sum = 0;
        while (!stack.isEmpty()) {

            sum += stack.pop();

        }

        return sum;
    }
}