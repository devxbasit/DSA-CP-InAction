// https://leetcode.com/problems/min-stack/
class MinStack {

    class Node {

        int val;
        int min;

        public Node(int val, int min) {

            this.val = val;
            this.min = min;

        }

    }

    Stack<Node> stack;

    // using only one stack not space efficient

    /*
     * https://leetcode.com/problems/min-stack/discuss/1092624/using-stack-and-class
     * -node
     * 
     * hey @SmartCoder_06 I think this approach is space inefficient (better is to
     * use two stacks approach)
     * suppose int take 1 byte
     * 
     * operations are
     * push 0
     * push 3
     * push 4
     * 
     * in your code each push operation will take 2 bytes
     * total bytes = 2 * 3 = 6 bytes (data redundancy)
     * 
     * but if we solve this problem using two stacks approach [
     * https://www.youtube.com/watch?v=4bjCEJmiPZA ]
     * stack 1 (consists of 3 elements) wil take 3 bytes
     * stack 2/ minStack (only 0 will be pushed into it) will take 1 byte
     * total bytes = (3 + 1) * 1 = 4 bytes
     * If I'm wrong, please correct me
     * 
     */

    /** initialize your data structure here. */
    public MinStack() {

        stack = new Stack<Node>();

    }

    public void push(int x) {

        if (stack.isEmpty()) {

            stack.push(new Node(x, x));
            return;

        }

        int min = Math.min(stack.peek().min, x);

        stack.push(new Node(x, min));

    }

    public void pop() {

        stack.pop();

    }

    public int top() {

        return stack.peek().val;

    }

    public int getMin() {

        return stack.peek().min;

    }

}
