/* 
日期：2021-03-27
232. 用栈实现队列
*/

/*
算法思想：使用两个栈
思路：遍历所有节点，每次遍历到一个节点时，判断该节点此前是否被访问过
时间复杂度：push和empty为 O(1)O(1)，pop和peek为均摊O(1)。
          对于每个元素，至多入栈和出栈各两次，故均摊复杂度为O(1)。
空间复杂度：O(n)
*/

class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }
    
    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}














