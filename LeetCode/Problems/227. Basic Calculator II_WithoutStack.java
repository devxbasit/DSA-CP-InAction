// https://leetcode.com/problems/basic-calculator-ii/
class Solution {

    // see solution using stack
    // approach is same a doing with stack

    // https://www.youtube.com/watch?v=GR8Z1zaQzz0&t=293s&ab_channel=AlgorithmsMadeEasy
    // https://www.youtube.com/watch?v=o2kXcAliqMU&ab_channel=CSNinja-CodingMadeSimple

    public int calculate(String s) {

        if (s.length() == 0)
            return 0;

        int sum = 0;

        int last = 0;

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

                        sum += last;
                        last = num;
                        break;

                    case '-':

                        sum += last;
                        last = -num;
                        break;

                    case '*':

                        last = last * num;
                        break;

                    case '/':

                        last = last / num;
                        break;

                }

                num = 0;
                operation = ch;

            }

        }

        sum += last;

        return sum;
    }
}